package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectMain {

    public static void main(String[] args) {
        unknownHostEx1();
        unknownHostEx2();
        ConnectionRefused();

    }

    private static void ConnectionRefused() {
        try {
            Socket socket = new Socket("localhost", 45789);
        } catch (ConnectException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static void unknownHostEx2() {
        try {
            Socket socket = new Socket("google.hey", 80);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void unknownHostEx1() {
        try {
            Socket socket = new Socket("999.999.999.999", 80);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
