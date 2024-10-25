package io.buffered;

import static io.buffered.BufferedConst.BUFFER_SIZE;
import static io.buffered.BufferedConst.FILE_NAME;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileV2 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);

        long startTime = System.currentTimeMillis();

        byte[] bytes = new byte[BUFFER_SIZE];
        int fileSize = 0;

        while (fileInputStream.read(new byte[BUFFER_SIZE]) != -1) {

            fileSize += bytes.length;

        }

        fileInputStream.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File create: " + FILE_NAME);
        System.out.println("File size: " + fileSize / 1000 / 1000 + "MB");
        System.out.println("Time taken: " + (endTime - startTime));

    }
}
