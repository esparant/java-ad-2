package was.v4;

import static java.nio.charset.StandardCharsets.UTF_8;
import static util.MyLogger.log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;

public class HttpRequestHandlerV4 implements Runnable {
    private final Socket socket;

    public HttpRequestHandlerV4(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            process();
        } catch (Exception e) {
            log(e);
        }
    }

    private void process() {
        try (socket;
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), false, UTF_8)) {

            HttpRequest request = new HttpRequest(br);
            HttpResponse response = new HttpResponse(pw);

            if (request.getPath().equals("/favicon.ico")) {
                log("favicon request");
                return;
            }

            System.out.println("http request information print");
            System.out.println(request);

            if (request.getPath().equals("/site1")) {
                site1(response);
            } else if (request.getPath().equals("/site2")) {
                site2(response);
            } else if (request.getPath().equals("/")) {
                home(response);
            } else if (request.getPath().equals("/search?q=default")) {
                search(request, response);
            }
            else {
                notFound(response);
            }

            response.flush();

            log("completed http response transfer");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void search(HttpRequest request, HttpResponse response) {

        String query = request.getParam("q");

        response.setBody("<h1>Search</h1>");
        response.setBody("<ul>");
        response.setBody("<li>query: " + query + "</li>");
        response.setBody("</ul>");
    }

    private void notFound(HttpResponse response) {
        response.setStatusCode(404);
        response.setBody("<h1>NOT FOUND</h1>");
    }

    private void home(HttpResponse response) {
        response.setBody("<h1>This is a home page</h1>");
        response.setBody("<ul>");
        response.setBody("<li><a href='site1'>site1</a></li>");
        response.setBody("<li><a href='site2'>site2</a></li>");
        response.setBody("<li><a href='search'>search</a></li>");
        response.setBody("</ul>");
    }

    private void site2(HttpResponse response) {
        response.setBody("<h1>This is site2</h1>");
    }

    private void site1(HttpResponse response) {
        response.setBody("<h1>This is site1</h1>");
    }
}
