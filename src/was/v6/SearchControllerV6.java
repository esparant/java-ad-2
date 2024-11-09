package was.v6;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;

public class SearchControllerV6 {

    public void search(HttpRequest request, HttpResponse response) {
        String query = request.getParam("q");

        response.setBody("<h1>Search</h1>");
        response.setBody("<ul>");
        response.setBody("<li>query: " + query + "</li>");
        response.setBody("</ul>");
    }
}
