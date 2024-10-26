package io.streams;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamEtcMain {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("temp/print.txt");
        PrintStream printStream = new PrintStream(fileOutputStream);

        printStream.println("Hello World");
        printStream.println("Spring Java");
        printStream.close();
        fileOutputStream.close();
    }
}
