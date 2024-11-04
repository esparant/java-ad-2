package chat.server;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

public class Session implements Runnable {
    private final Socket socket;
    private final DataInputStream input;
    private final DataOutputStream output;
    private final CommandManager commandManager;
    private final SessionManager sessionManager;

    private boolean closed = false;
    private String username;

    public Session(Socket socket, CommandManager commandManager, SessionManager sessionManager) throws IOException {
        this.socket = socket;
        this.input = new DataInputStream(this.socket.getInputStream());
        this.output = new DataOutputStream(this.socket.getOutputStream());
        this.commandManager = commandManager;
        this.sessionManager = sessionManager;

        this.sessionManager.add(this);
    }


    @Override
    public void run() {
        try {
            while (true) {
                String receivedMessage = input.readUTF();
                log("client -> server: " + receivedMessage);

                commandManager.execute(receivedMessage, this);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            sessionManager.remove(this);
            sessionManager.sendAll(username + " exited");
            close();
        }
    }

    public void send(String message) throws IOException {
        log ("server -> client: " + message);
        output.writeUTF(message);
    }

    public void close() {
        if (closed) {
            return;
        }

        log("session closed: " + socket);
        closeAll(socket, input, output);
        closed = true;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
