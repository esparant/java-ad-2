package io.buffered;

import static io.buffered.BufferedConst.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileV1 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);

        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        while (fileInputStream.read() != -1) {
            fileSize++;
        }
        fileInputStream.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File create: " + FILE_NAME);
        System.out.println("File size: " + fileSize / 1000 / 1000 + "MB");
        System.out.println("Time taken: " + (endTime - startTime));

    }
}
