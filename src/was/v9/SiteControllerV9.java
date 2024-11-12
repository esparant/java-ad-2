package was.v9;

import was.httpserver.HttpResponse;
import was.httpserver.servlet.annotation.Mapping;

public class SiteControllerV9 {

    @Mapping("/")
    public void home(HttpResponse response) {
        response.setBody("<h1>This is a home page</h1>");
        response.setBody("<ul>");
        response.setBody("<li><a href='site1'>site1</a></li>");
        response.setBody("<li><a href='site2'>site2</a></li>");
        response.setBody("<li><a href='search?q=default'>search</a></li>");
        response.setBody("</ul>");
    }


    @Mapping("/site1")
    public void site1(HttpResponse response) {
        response.setBody("<h1>This is site1</h1>");
    }

    @Mapping("/site2")
    public void site2(HttpResponse response) {
        response.setBody("<h1>This is site2</h1>");
    }

    @Mapping("/site2")
    public void hello(HttpResponse response) {
        response.setBody("<h1>This is site2</h1>");
    }
}
