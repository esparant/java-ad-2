package was.v5.servlet;

import java.io.IOException;
import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.HttpServlet;

public class SearchServlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) {
        String query = request.getParam("q");

        response.setBody("<h1>Search</h1>");
        response.setBody("<ul>");
        response.setBody("<li>query: " + query + "</li>");
        response.setBody("</ul>");
    }
}
