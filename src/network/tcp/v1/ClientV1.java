package network.tcp.v1;

import static util.MyLogger.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import util.MyLogger;

public class ClientV1 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("Client started");
        Socket clientSocket = new Socket("localhost", PORT);

        DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

        log("socket connect: " + clientSocket);

        String sendMessage = "Hello";
        dos.writeUTF(sendMessage);
        log("client -> server: " + sendMessage);

        String receiveMessage = dis.readUTF();
        log("client <- server: " + receiveMessage);

        log("연결 종료: " + clientSocket);
        dis.close();
        dos.close();
        clientSocket.close();
    }
}
