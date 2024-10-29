package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class OldFileMain {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");

        System.out.println("File Exists: " + file.exists());

        boolean newFile = file.createNewFile();
        System.out.println("newFile = " + newFile);

        boolean mkdir = directory.mkdir();
        System.out.println("mkdir = " + mkdir);

//        boolean delete = file.delete();
//        System.out.println("delete = " + delete);

        System.out.println("Is File: " + file.isFile());
        System.out.println("Is Directory: " + directory.isDirectory());
        System.out.println("File Name: " + file.getName());
        System.out.println("File Size: " + file.length());

        File file2 = new File("temp/newExample.txt");
        boolean rename = file.renameTo(file2);
        System.out.println("rename = " + rename);

        long modified = file2.lastModified();
        System.out.println("modified = " + new Date(modified));



    }
}
