package io.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.xml.xpath.XPath;

public class NewFilesMain {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("temp/example.txt");
        Path directory = Path.of("temp/exampleDir");

        System.out.println("File Exists: " + Files.exists(file));

        try {
            Files.createFile(file);
            System.out.println("completed creating file");
        } catch (FileAlreadyExistsException e) {
            System.out.println("already file exist");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.createDirectory(directory);
            System.out.println("completed creating directory");
        } catch (FileAlreadyExistsException e) {
            System.out.println("already directory exist");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//
//        Files.delete(file);
//        System.out.println("completed deleting file");

        System.out.println("is regular file: " + Files.isRegularFile(file));
        System.out.println("is directory: " + Files.isDirectory(directory));
        System.out.println("file size: " + Files.size(file));
    }
}
