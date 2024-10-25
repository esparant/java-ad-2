package io.buffered;

import static io.buffered.BufferedConst.BUFFER_SIZE;
import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFileV2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);

        long startTime = System.currentTimeMillis();

        byte[] bytes = new byte[BUFFER_SIZE];
        int bufferIndex = 0;

        for (int i = 0; i < FILE_SIZE; i ++) {
            bytes[bufferIndex++] = 1;

            if (bufferIndex == BUFFER_SIZE) {
                fileOutputStream.write(bytes);
                bufferIndex = 0;
            }
        }

        if (bufferIndex > 0) {
            fileOutputStream.write(bytes, 0, bufferIndex);
        }

        fileOutputStream.close();


        long endTime = System.currentTimeMillis();

        System.out.println("File create: " + FILE_NAME);
        System.out.println("File size: " + FILE_SIZE / 1000 / 1000 + "MB");
        System.out.println("Time taken: " + (endTime - startTime));


    }
}
