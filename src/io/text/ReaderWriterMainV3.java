package io.text;

import static io.text.TextConst.*;
import static java.nio.charset.StandardCharsets.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReaderWriterMainV3 {

    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        System.out.println("Write String: " + writeString);

        FileWriter fileWriter = new FileWriter(FILE_NAME, UTF_8);
        fileWriter.write(writeString);
        fileWriter.close();

        FileReader fileReader = new FileReader(FILE_NAME, UTF_8);
        int ch;
        System.out.print("Read String: ");
        while ((ch = fileReader.read()) != -1) {
            System.out.print((char) ch);
        }

        fileReader.close();

    }
}
