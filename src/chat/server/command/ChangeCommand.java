package chat.server.command;

import chat.server.Session;
import chat.server.SessionManager;
import java.io.IOException;

public class ChangeCommand implements Command {
    private final SessionManager sessionManager;

    public ChangeCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) {
        String changedName = args[1].trim();
        sessionManager.sendAll(session.getUsername() + " has changed name -> " + changedName);
        session.setUsername(changedName);
    }

}
