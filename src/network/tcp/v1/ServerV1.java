package network.tcp.v1;

import static util.MyLogger.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import util.MyLogger;

public class ServerV1 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("server start");
        ServerSocket serverSocket = new ServerSocket(PORT);

        log("server socket start - listening on port: " + PORT);

        Socket accept = serverSocket.accept();
        log("socket connect: " + accept);

        DataInputStream dis = new DataInputStream(accept.getInputStream());
        DataOutputStream dos = new DataOutputStream(accept.getOutputStream());

        String received = dis.readUTF();
        log("client -> server: " + received);
        String sendMessage = received + " World";

        dos.writeUTF(sendMessage);
        log("client <- server: " + sendMessage);

        log("연결 종료: " + accept);
        dis.close();
        dos.close();
        accept.close();
        serverSocket.close();
    }
}
