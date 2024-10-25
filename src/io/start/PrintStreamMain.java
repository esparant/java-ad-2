package io.start;


import static java.nio.charset.StandardCharsets.*;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamMain {
    public static void main(String[] args) throws IOException {

        PrintStream out = System.out;

        byte[] bytes = "Hello World!\n".getBytes(UTF_8);
        out.write(bytes);

        out.println("JAVA");
    }
}
