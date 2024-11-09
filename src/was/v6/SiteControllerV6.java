package was.v6;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;

public class SiteControllerV6 {
    public void site1(HttpRequest request, HttpResponse response) {
        response.setBody("<h1>This is site1</h1>");
    }

    public void site2(HttpRequest request, HttpResponse response) {
        response.setBody("<h1>This is site2</h1>");
    }
}
