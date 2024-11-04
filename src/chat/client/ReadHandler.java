package chat.client;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.IOException;

public class ReadHandler implements Runnable {

    private final DataInputStream input;
    private final Client client;
    public boolean closed = false;

    public ReadHandler(DataInputStream input, Client client) {
        this.input = input;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String receivedMessage = input.readUTF();
                System.out.println(receivedMessage);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    public synchronized void close() {
        if (closed) {
            return;
        }

        closed = true;
        log("readHandler closed");
    }
}