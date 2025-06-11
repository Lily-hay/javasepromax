package com.lily.d5_dataOutputStream;


import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamDemo1 {
    public static void main(String[] args) {
        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream("day10-io/src/com/lily/data.txt"))) {
            dos.writeChar('a');
            dos.writeByte(97);
            dos.writeBoolean(true);
            dos.writeUTF("你好");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
