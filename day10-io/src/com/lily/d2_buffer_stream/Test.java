package com.lily.d2_buffer_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try(
                BufferedReader br=new BufferedReader(new FileReader("day10-io/src/com/lily/csb.txt"));
                BufferedWriter bw=new BufferedWriter(new FileWriter("day10-io/src/com/lily/csb-new.txt"));
                ) {
            List<String> data= new ArrayList<>();
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
            }
            System.out.println(data);
            Collections.sort(data);
            System.out.println(data);
            for (String ln : data) {

                    bw.write(ln);
                    bw.newLine();

            }
            System.out.println("完成了");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
