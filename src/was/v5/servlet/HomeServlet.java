package was.v5.servlet;

import java.io.IOException;
import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.HttpServlet;

public class HomeServlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        response.setBody("<h1>This is a home page</h1>");
        response.setBody("<ul>");
        response.setBody("<li><a href='site1'>site1</a></li>");
        response.setBody("<li><a href='site2'>site2</a></li>");
        response.setBody("<li><a href='search?q=default'>search</a></li>");
        response.setBody("</ul>");
    }
}
