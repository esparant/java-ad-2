package was.v3;

import static java.nio.charset.StandardCharsets.UTF_8;
import static util.MyLogger.log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HttpRequestHandlerV3 implements Runnable {
    private final Socket socket;

    public HttpRequestHandlerV3(Socket socket) {
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

            String requestToString = requestToString(br);

            if (requestToString.contains("/favicon.ico")) {
                log("favicon request");
                return;
            }

            System.out.println("http request information print");
            System.out.println(requestToString);

            log("creating http response...");
            if (requestToString.startsWith("GET /site1")) {
                site1(pw);
            } else if (requestToString.startsWith("GET /site2")) {
                site2(pw);
            } else if (requestToString.startsWith("GET / ")) {
                home(pw);
            } else {
                notFound(pw);
            }

            log("completed http response transfer");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void notFound(PrintWriter pw) {
        pw.println("HTTP/1.1 404 NOT FOUND");
        pw.println("Content-Type: text/html");
        pw.println();
        pw.println("<h1>NOT FOUND</h1>");
    }

    private void home(PrintWriter pw) {
        pw.println("HTTP/1.1 200 OK");
        pw.println("Content-Type: text/html");
        pw.println();
        pw.println("<h1>This is a home page</h1>");
        pw.println("<ul>");
        pw.println("<li><a href='site1'>site1</a></li>");
        pw.println("<li><a href='site2'>site2</a></li>");
        pw.println("</ul>");
        pw.flush();
    }

    private void site2(PrintWriter pw) {
        pw.println("HTTP/1.1 200 OK");
        pw.println("Content-Type: text/html");
        pw.println();
        pw.println("<h1>This is site2</h1>");
        pw.flush();
    }

    private void site1(PrintWriter pw) {
        pw.println("HTTP/1.1 200 OK");
        pw.println("Content-Type: text/html");
        pw.println();
        pw.println("<h1>This is site1</h1>");
        pw.flush();
    }

    private static String requestToString(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}
