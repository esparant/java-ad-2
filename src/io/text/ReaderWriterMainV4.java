package io.text;

import static io.text.TextConst.*;
import static java.nio.charset.StandardCharsets.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class ReaderWriterMainV4 {

    private static final int BUFFER_SIZE = 8000;

    public static void main(String[] args) throws IOException {
        String writeString1 = "Hello World!";
        String writeString2 = "Java Spring";

        FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
        BufferedWriter bufferedWriter = new BufferedWriter(fw, BUFFER_SIZE);
        bufferedWriter.write(writeString1);
        bufferedWriter.newLine();
        bufferedWriter.write(writeString2);
        bufferedWriter.close();

        FileReader fileReader = new FileReader(FILE_NAME, UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader, BUFFER_SIZE);
        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }

    }
}
