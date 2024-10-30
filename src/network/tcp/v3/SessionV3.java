package network.tcp.v3;

import static util.MyLogger.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import util.MyLogger;

public class SessionV3 implements Runnable {

    private final Socket socket;

    public SessionV3(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

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

            log("disconnect");
            dis.close();
            dos.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
