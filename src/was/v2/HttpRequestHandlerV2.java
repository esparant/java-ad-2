package was.v2;

import static java.nio.charset.StandardCharsets.UTF_8;
import static util.MyLogger.log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HttpRequestHandlerV2 implements Runnable{
    private final Socket socket;

    public HttpRequestHandlerV2(Socket socket) {
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
            getSleep(1500);
            responseToClient(pw);
            log("completed http response transfer");

        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getSleep(int mills) throws InterruptedException {
        Thread.sleep(mills);
    }

    private void responseToClient(PrintWriter pw) {
        String body = "<h1>Hello World!</h1>";

        String sb = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "Content-Length: " + body.getBytes(UTF_8).length + "\r\n"
                + "\r\n"
                + body;

        pw.write(sb);
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
