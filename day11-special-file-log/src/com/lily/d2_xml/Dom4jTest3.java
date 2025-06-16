package com.lily.d2_xml;

import java.io.PrintStream;

public class Dom4jTest3 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
        sb.append("<user>\r\n");
        sb.append("\t<name>").append("张三").append("</name>\r\n");
        sb.append("\t<age>").append("18").append("</age>\r\n");
        sb.append("\t<sex>").append("男").append("</sex>\r\n");
        sb.append("</user>\r\n");
        PrintStream ps = new PrintStream("day11-special-file-log/user3.xml");
        ps.println(sb);
        ps.close();


    }
}
