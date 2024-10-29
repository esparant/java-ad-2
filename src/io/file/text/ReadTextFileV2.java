package io.file.text;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadTextFileV2 {

    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        Path path = Path.of(PATH);
        String writeString = "abc\nHello";

        System.out.println("== writeString == ");
        Files.writeString(path, writeString, UTF_8);
        System.out.println(writeString);

        System.out.println(" == readString == ");
        List<String> strings = Files.readAllLines(path, UTF_8);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
