package io.file.copy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateCopyFile {
    private static final int FILE_SIZE = 500 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        String fileName = "temp/copy.dat";

        long startTime = System.currentTimeMillis();
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(new byte[FILE_SIZE]);
        fos.close();
        long endTime = System.currentTimeMillis();
        System.out.println("file created in " + (endTime - startTime) + "ms");
        System.out.println("file size: " + FILE_SIZE/1024/1024 + "MB");

    }
}
