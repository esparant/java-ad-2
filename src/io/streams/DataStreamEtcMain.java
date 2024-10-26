package io.streams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamEtcMain {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("temp/data.dat");
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

        dataOutputStream.writeUTF("회원A");
        dataOutputStream.writeInt(999999);
        dataOutputStream.writeDouble(999999.22312);
        dataOutputStream.writeBoolean(true);
        dataOutputStream.close();


        FileInputStream fileInputStream = new FileInputStream("temp/data.dat");
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        String s = dataInputStream.readUTF();
        System.out.println("s = " + s);
        int i = dataInputStream.readInt();
        System.out.println("i = " + i);
        double d = dataInputStream.readDouble();
        System.out.println("d = " + d);
        boolean b = dataInputStream.readBoolean();
        System.out.println("b = " + b);
        dataInputStream.close();

    }
}
