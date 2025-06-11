package com.lily.d5_dataOutputStream;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataOutputStreamDemo2 {
    public static void main(String[] args) {
        try(DataInputStream dis=new DataInputStream(new FileInputStream("day10-io/src/com/lily/data.txt"))) {
            char c=dis.readChar();
            System.out.println(c);
            Byte b=dis.readByte();
            System.out.println(b);
            Boolean bl=dis.readBoolean();
            System.out.println(bl);
            String s=dis.readUTF();
            System.out.println(s);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
