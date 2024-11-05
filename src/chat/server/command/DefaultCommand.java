package chat.server.command;

import chat.server.Session;
import java.io.IOException;
import java.util.Arrays;

public class DefaultCommand implements Command {
    @Override
    public void execute(String[] args, Session session) throws IOException {
        session.send("this command does not exist: " + Arrays.toString(args));

    }
}
