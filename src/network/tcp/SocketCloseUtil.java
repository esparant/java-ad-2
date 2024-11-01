package network.tcp;

import static util.MyLogger.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketCloseUtil {
    public static void closeAll(Socket socket, InputStream in, OutputStream out) {
        closeInput(in);
        closeOutput(out);
        closeSocket(socket);
    }

    public static void closeSocket(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                log(e.getMessage());
            }
        }
    }

    public static void closeOutput(OutputStream out) {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                log(e.getMessage());
            }
        }
    }

    public static void closeInput(InputStream in) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                log(e.getMessage());
            }
        }
    }
}
