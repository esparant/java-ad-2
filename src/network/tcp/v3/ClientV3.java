package network.tcp.v3;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientV3 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("Client started");
        Socket clientSocket = new Socket("localhost", PORT);

        DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

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


        log("연결 종료: " + clientSocket);
        dis.close();
        dos.close();
        clientSocket.close();
    }
}
