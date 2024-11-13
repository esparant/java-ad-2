package was.httpserver;

import static java.nio.charset.StandardCharsets.*;
import static util.MyLogger.log;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

    private String method;
    private String path;
    private final Map<String, String> queryParam = new HashMap<>();
    private final Map<String, String> headers = new HashMap<>();

    public HttpRequest(BufferedReader reader) throws IOException {
        parseRequestLine(reader);
        parseHeaders(reader);

        parseBody(reader);
    }

    private void parseBody(BufferedReader reader) throws IOException {
        if (!headers.containsKey("Content-Length")) {
            return;
        }

        int length = Integer.parseInt(headers.get("Content-Length"));
        char[] bodyChars = new char[length];
        int read = reader.read(bodyChars);

        if (read != length) {
            throw new IOException("Fail to read entire body. Expected: " + length + " Actual: " + read);
        }

        String body = new String(bodyChars);

        log("HTTP request body: " + body);

        String contentType = headers.get("Content-Type");
        if ("application/x-www-form-urlencoded".equals(contentType)) {
            parseQueryParameters(body);

        }
    }

    private void parseHeaders(BufferedReader reader) throws IOException {
        String line;
        while (!(line = reader.readLine()).isEmpty()) {
            String[] headerParts = line.split(":");
            headers.put(headerParts[0].trim(), headerParts[1].trim());
        }
    }

    private void parseRequestLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line == null) {
            throw new IOException("EOF: No request line received");
        }

        String[] lineParts = line.split(" ");
        if (lineParts.length != 3) {
            throw new IOException("EOF: Invalid request line: " + line);
        }

        method = lineParts[0];
        String[] pathParts = lineParts[1].split("\\?");
        path = pathParts[0];

        if (pathParts.length > 1) {
            parseQueryParameters(pathParts[1]);
        }
    }

    private void parseQueryParameters(String queryString) {
        for (String param : queryString.split("&")) {
            String[] keyValue = param.split("=");

            queryParam.put(
                    URLDecoder.decode(keyValue[0], UTF_8),
                    keyValue.length > 1 ? URLDecoder.decode(keyValue[1], UTF_8) : "");
        }
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getParam(String name) {
        return queryParam.get(name);
    }

    public String getHeader(String name) {
        return headers.get(name);
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", queryParam=" + queryParam +
                ", headers=" + headers +
                '}';
    }
}
