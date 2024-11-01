package network.tcp.v4;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import network.tcp.SocketCloseUtil;

public class SessionV4 implements Runnable {

    private final Socket socket;

    public SessionV4(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        DataInputStream dis = null;
        DataOutputStream dos = null;

        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

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
            SocketCloseUtil.closeAll(socket, dis, dos);
            log("connection termination: " + socket);
        }

    }
}
