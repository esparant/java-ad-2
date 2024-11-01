package network.tcp.v6;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import network.tcp.SocketCloseUtil;

public class SessionV6 implements Runnable{

    private final Socket socket;
    private final DataInputStream dis;
    private final DataOutputStream dos;
    private final SessionManagerV6 sessionManager;
    private boolean closed = false;

    public SessionV6(Socket socket, SessionManagerV6 sessionManager) throws IOException {
        this.socket = socket;
        this.dis = new DataInputStream(socket.getInputStream());
        this.dos = new DataOutputStream(socket.getOutputStream());
        this.sessionManager = sessionManager;
        this.sessionManager.add(this);
    }

    @Override
    public void run() {
        try {

            while (true) {
                String readMessage = dis.readUTF();
                log("read message: " + readMessage);

                if (readMessage.equals("exit")) {
                    break;
                }

                String writeMessage = readMessage + " hello";
                dos.writeUTF(writeMessage);
                log("write message: " + writeMessage);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            sessionManager.remove(this);
            close();
        }
    }

    public synchronized void close() {

        if (closed) {
            return;
        }

        SocketCloseUtil.closeAll(socket, dis, dos);
        closed = true;
        log("connection termination: " + socket);
    }
}
