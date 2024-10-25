package io.buffered;

import static io.buffered.BufferedConst.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFileV1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < FILE_SIZE; i++) {
            fileOutputStream.write(1);
        }
        fileOutputStream.close();

        long endTime = System.currentTimeMillis();

        System.out.println("File create: " + FILE_NAME);
        System.out.println("File size: " + FILE_SIZE / 1000 / 1000 + "MB");
        System.out.println("Time taken: " + (endTime - startTime));


    }
}
