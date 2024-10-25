package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("temp/hello.dat");
        byte[] input = {65, 66, 67};
        fileOutputStream.write(input);
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("temp/hello.dat");
        byte[] buffer = new byte[5];
        int read = fileInputStream.read(buffer, 3, 2);
        System.out.println("read count = " + read);
        System.out.println(Arrays.toString(buffer));
        fileInputStream.close();
    }
}
