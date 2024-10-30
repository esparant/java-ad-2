package network.tcp.v3;

import static util.MyLogger.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import util.MyLogger;

public class ServerV3 {


    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("starting server");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("listening on port: " + PORT);

        while (true) {
            Socket accept = serverSocket.accept();

            log("socket connected: " + accept);

            SessionV3 session = new SessionV3(accept);

            new Thread(session).start();
        }

    }
}
