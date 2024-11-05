package chat.server;

import java.io.IOException;
import java.util.List;

public class CommandManagerV2 implements CommandManager {

    private static final String DETERMINE = "\\|";

    private final SessionManager sessionManager;

    public CommandManagerV2(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {

        if (totalMessage.startsWith("/join")) {
            session.setUsername(totalMessage.split(DETERMINE)[1]);
            sessionManager.sendAll(session.getUsername() + " has joined.");
        } else if (totalMessage.startsWith("/message")) {
            sessionManager.sendAll(session.getUsername() + ": " + totalMessage.split(DETERMINE)[1]);
        } else if (totalMessage.startsWith("/change")) {
            String changedName = totalMessage.split(DETERMINE)[1].trim();
            sessionManager.sendAll(session.getUsername() + " has changed name -> " + changedName);
            session.setUsername(changedName);
        } else if (totalMessage.startsWith("/users")) {
            List<String> allUsername = sessionManager.getAllUsername();
            StringBuilder sb = new StringBuilder();
            sb.append("user count: ").append(allUsername.size()).append("\n");
            for (String username : allUsername) {
                sb.append(" - ").append(username).append("\n");
            }
            session.send(sb.toString());
        }
        else if (totalMessage.startsWith("/exit")) {
            throw new IOException("exit");
        } else {
            session.send("this command does not exist: " + totalMessage);
        }
    }
}
