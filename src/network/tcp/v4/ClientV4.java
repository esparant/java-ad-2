package network.tcp.v4;

import static network.tcp.SocketCloseUtil.*;
import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import network.tcp.SocketCloseUtil;

public class ClientV4 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("Client started");

        Socket clientSocket = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;

        try {
            clientSocket = new Socket("localhost", PORT);
            dis = new DataInputStream(clientSocket.getInputStream());
            dos = new DataOutputStream(clientSocket.getOutputStream());

            log("socket connect: " + clientSocket);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("message: ");
                String sendMessage = scanner.nextLine();

                dos.writeUTF(sendMessage);
                log("client -> server: " + sendMessage);

                if (sendMessage.equals("exit")) {
                    break;
                }

                String receiveMessage = dis.readUTF();
                log("client <- server: " + receiveMessage);
            }
        } catch (IOException e) {
            log("client error: " + e);
        } finally {
            closeAll(clientSocket, dis, dos);
            log("client connection closed: " + clientSocket);
        }
    }
}
