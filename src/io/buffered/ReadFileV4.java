package io.buffered;

import static io.buffered.BufferedConst.FILE_NAME;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileV4 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);

        long startTime = System.currentTimeMillis();

        byte[] bytes = fileInputStream.readAllBytes();
        fileInputStream.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File create: " + FILE_NAME);
        System.out.println("File size: " + bytes.length / 1000 / 1000 + "MB");
        System.out.println("Time taken: " + (endTime - startTime));

    }
}
