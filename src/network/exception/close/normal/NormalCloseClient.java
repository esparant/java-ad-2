package network.exception.close.normal;

import static util.MyLogger.*;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class NormalCloseClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 12345);
        log("소캣 연결: " + socket);

        InputStream is = socket.getInputStream();
//        readByInputStream(is, socket);
//        readByBufferedReader(is, socket);
//        reedByDataInputStream(is, socket);

        log("연결 종료: " + socket.isClosed());
    }

    private static void reedByDataInputStream(InputStream is, Socket socket) throws IOException {
        DataInputStream dis = new DataInputStream(is);

        try {
            dis.readUTF();
        } catch (EOFException e) {
            log(e);
        } finally {
            dis.close();
            socket.close();
        }
    }

    private static void readByBufferedReader(InputStream is, Socket socket) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String rs = br.readLine();

        log("readByBufferedReader: " + rs);
        if (rs == null) {
            br.close();
            socket.close();
        }

    }

    private static void readByInputStream(InputStream is, Socket socket) throws IOException {
        int read = is.read();
        log("read = " + read);
        if (read == -1) {
            is.close();
            socket.close();
        }
    }
}
