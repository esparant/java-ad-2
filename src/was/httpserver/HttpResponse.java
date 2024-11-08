package was.httpserver;

import static java.nio.charset.StandardCharsets.*;

import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class HttpResponse {
    private final PrintWriter writer;
    private int statusCode = 200;
    private final StringBuilder bodyBuilder = new StringBuilder();
    private String contentType = "text/html; charset=UTF-8";

    public HttpResponse(PrintWriter writer) {
        this.writer = writer;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setBody(String body) {
        bodyBuilder.append(body);
    }

    public void flush() throws IOException {
        int ContentLength = bodyBuilder.toString().getBytes(UTF_8).length;
        writer.println("HTTP/1.1 " + statusCode + " " + ContentLength + " " + contentType);
        writer.println("Content-Type: " + contentType);
        writer.println("Content-Length: " + ContentLength);
        writer.println();
        writer.println(bodyBuilder);
        writer.flush();
    }

    private String getReasonParse(int statusCode) {
        return switch (statusCode) {
            case 200 -> "OK";
            case 404 -> "Not Found";
            case 500 -> "Internal Server Error";
            default -> "Unknown";
        };
    }


}
