package was.v7;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.servlet.annotation.Mapping;

public class SearchControllerV7 {

    @Mapping("/search")
    public void search(HttpRequest request, HttpResponse response) {
        String query = request.getParam("q");

        response.setBody("<h1>Search</h1>");
        response.setBody("<ul>");
        response.setBody("<li>query: " + query + "</li>");
        response.setBody("</ul>");
    }
}
