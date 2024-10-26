package io.text;

import static io.text.TextConst.*;
import static java.nio.charset.StandardCharsets.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class ReaderWriterMainV2 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";

        System.out.println("Write String: " + writeString);

        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, UTF_8);

        outputStreamWriter.write(writeString);
        outputStreamWriter.close();

        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, UTF_8);

        int ch;

        System.out.print("Read String: ");
        while ((ch = inputStreamReader.read()) != -1) {
            System.out.print((char) ch);
        }
        inputStreamReader.close();

    }
}
