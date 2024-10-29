package io.file;

import java.io.File;
import java.io.IOException;

public class OldFilePath {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/..");
        System.out.println("path: " + file.getPath());

        System.out.println("absolute path: " + file.getAbsolutePath());
        System.out.println("Canonical path: " + file.getCanonicalPath());

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println((f.isDirectory() ? "directory" : "file") + "|" + f.getName());
        }
    }
}
