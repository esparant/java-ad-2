package io.buffered;

import static io.buffered.BufferedConst.BUFFER_SIZE;
import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFileV4 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);

        long startTime = System.currentTimeMillis();

        byte[] bytes = new byte[FILE_SIZE];

        for (int i = 0; i < FILE_SIZE ; i++) {
            bytes[i++] = 1;
        }

        fileOutputStream.write(bytes);

        fileOutputStream.close();


        long endTime = System.currentTimeMillis();

        System.out.println("File create: " + FILE_NAME);
        System.out.println("File size: " + FILE_SIZE / 1000 / 1000 + "MB");
        System.out.println("Time taken: " + (endTime - startTime));


    }
}
