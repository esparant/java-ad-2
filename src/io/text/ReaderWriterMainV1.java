package io.text;

import static io.text.TextConst.*;
import static java.nio.charset.StandardCharsets.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ReaderWriterMainV1 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        // 문자 - byte UTF-8 인코딩
        byte[] writeStringBytes = writeString.getBytes(UTF_8);
        System.out.println("Write String: " + writeString);
        System.out.println("Write Bytes: " + Arrays.toString(writeStringBytes));

        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        fileOutputStream.write(writeStringBytes);
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        byte[] readAllBytes = fileInputStream.readAllBytes();
        System.out.println("Read All Bytes: " + Arrays.toString(readAllBytes));

        String decodingBytes = new String(readAllBytes, UTF_8);
        System.out.println("Decoding Bytes: " + decodingBytes);

        fileInputStream.close();
    }
}
