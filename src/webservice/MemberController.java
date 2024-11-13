package webservice;

import static util.MyLogger.log;

import io.member.Member;
import io.member.MemberRepository;
import java.util.List;
import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.servlet.annotation.Mapping;

public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Mapping("/")
    public void home(HttpResponse response) {
        String str = "<html><body>"
                + "<h1>Member Management System</h1>"
                + "<ul>"
                + "<li><a href='/members'>Member List</a></li>"
                + "<li><a href='/add-member-form'>Add New Member</a></li>"
                + "</ul>";
        response.setBody(str);
    }

    @Mapping("/members")
    public void members(HttpResponse response) {
        List<Member> members = memberRepository.getMembers();

        StringBuilder page = new StringBuilder();
        page.append("<html><body>");
        page.append("<h1>Member List</h1>");
        page.append("<ul>");
        for (Member member : members) {
            page.append("<li>");
            page.append("ID: ").append(member.getId());
            page.append(", Name: ").append(member.getName());
            page.append(", Age: ").append(member.getAge());
            page.append("</li>");
        }
        page.append("</ul>");
        page.append("<a href='/'>Back to Home</a>");
        page.append("</body></html>");

        response.setBody(page.toString());
    }

    @Mapping("/add-member-form")
    public void addMemberForm(HttpResponse response) {
        String body = "<html><body>"
                + "<h1>Add New Member</h1>"
                + "<form action='/add-member' method='post'>"
                + "ID: <input type='text' name='id'><br>"
                + "Name: <input type='text' name='name'><br>"
                + "Age: <input type='text' name='age'><br>"
                + "<input type='submit' value='Complete'>"
                + "</form>"
                + "<a href='/'>Back to Home</a>"
                + "</body></html>";

        response.setBody(body);
    }

    @Mapping("/add-member")
    public void addMember(HttpRequest request, HttpResponse response) {
        log("Called MemberController.addMember");
        log("request = " + request);

        String id = request.getParam("id");
        String name = request.getParam("name");
        int age = Integer.parseInt(request.getParam("age"));

        memberRepository.add(new Member(id, name, age));

        response.setBody("<h1>Completed Adding Member</h1>"
                + "<a href='/'>Back to Home</a>");
    }
}
