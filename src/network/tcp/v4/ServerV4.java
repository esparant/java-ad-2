package network.tcp.v4;

import static util.MyLogger.log;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import network.tcp.v4.SessionV4;

public class ServerV4 {


    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("starting server");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("listening on port: " + PORT);

        while (true) {
            Socket accept = serverSocket.accept();

            log("socket connected: " + accept);

            SessionV4 session = new SessionV4(accept);

            new Thread(session).start();
        }

    }
}
