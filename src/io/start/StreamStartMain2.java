package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("temp/hello.dat");
        fileOutputStream.write(65);
        fileOutputStream.write(66);
        fileOutputStream.write(67);
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("temp/hello.dat");
        while (fileInputStream.available() > 0) {
            System.out.println(fileInputStream.read());
        }
        fileInputStream.close();
    }
}
