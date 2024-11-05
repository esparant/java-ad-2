package chat.server.command;

import chat.server.Session;
import chat.server.SessionManager;
import java.io.IOException;
import java.util.List;

public class UsersCommand implements Command {

    private final SessionManager sessionManager;


    public UsersCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }


    @Override
    public void execute(String[] args, Session session) throws IOException {
        List<String> allUsername = sessionManager.getAllUsername();
        StringBuilder sb = new StringBuilder();
        sb.append("user count: ").append(allUsername.size()).append("\n");
        for (String username : allUsername) {
            sb.append(" - ").append(username).append("\n");
        }
        session.send(sb.toString());
    }
}