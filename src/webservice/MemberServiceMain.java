package webservice;

import io.member.impl.FileMemberRepository;
import java.io.IOException;
import java.util.List;
import was.httpserver.HttpServer;
import was.httpserver.HttpServlet;
import was.httpserver.ServletManager;
import was.httpserver.servlet.DiscardServlet;
import was.httpserver.servlet.annotation.AnnotationServletV3;

public class MemberServiceMain {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        MemberController memberController = new MemberController(new FileMemberRepository());

        HttpServlet servlet = new AnnotationServletV3(List.of(memberController));
        ServletManager servletManager = new ServletManager();
        servletManager.add("/favicon.ico", new DiscardServlet());
        servletManager.setDefaultServlet(servlet);

        new HttpServer(PORT, servletManager).start();
    }
}
