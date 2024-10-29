package io.file.text;

import static java.nio.charset.StandardCharsets.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadTextFileV1 {

    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        Path path = Path.of(PATH);
        String writeString = "abc\nHello";

        System.out.println("== writeString == ");
        Files.writeString(path, writeString, UTF_8);
        System.out.println(writeString);

        System.out.println(" == readString == ");
        String s = Files.readString(path, UTF_8);
        System.out.println(s);
    }
}
