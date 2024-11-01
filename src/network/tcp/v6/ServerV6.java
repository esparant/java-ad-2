package network.tcp.v6;

import static util.MyLogger.log;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import network.tcp.v6.SessionV6;

public class ServerV6 {


    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("starting server");
        SessionManagerV6 sessionManager = new SessionManagerV6();
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("listening on port: " + PORT);

        // shutdownHook
        ShutdownHook shutdownHook = new ShutdownHook(serverSocket, sessionManager);
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook, "shutdown-hook"));
        try {
            while (true) {
                Socket accept = serverSocket.accept();

                log("socket connected: " + accept);

                SessionV6 session = new SessionV6(accept, sessionManager);

                new Thread(session).start();
            }
        } catch (IOException e) {
            log("server socket termination" + e);
        }

    }

    static class ShutdownHook implements Runnable {

        private final ServerSocket serverSocket;
        private final SessionManagerV6 sessionManager;

        public ShutdownHook(ServerSocket serverSocket, SessionManagerV6 sessionManager) {
            this.serverSocket = serverSocket;
            this.sessionManager = sessionManager;
        }

        @Override
        public void run() {
            log("shutdownHook run");
            try {
                sessionManager.closeAll();
                serverSocket.close();

                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("e = " + e);
            }
        }
    }
}
