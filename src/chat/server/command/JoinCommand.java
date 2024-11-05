package chat.server.command;

import chat.server.Session;
import chat.server.SessionManager;
import java.io.IOException;

public class JoinCommand implements Command {

    private final SessionManager sessionManager;

    public JoinCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) {
        session.setUsername(args[1]);
        sessionManager.sendAll(session.getUsername() + " has joined.");
    }
}
