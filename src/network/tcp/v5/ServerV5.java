package network.tcp.v5;

import static util.MyLogger.log;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import network.tcp.v5.SessionV5;

public class ServerV5 {


    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("starting server");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("listening on port: " + PORT);

        while (true) {
            Socket accept = serverSocket.accept();

            log("socket connected: " + accept);

            SessionV5 session = new SessionV5(accept);

            new Thread(session).start();
        }

    }
}
