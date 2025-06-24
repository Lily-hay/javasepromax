package com.lily.d3_demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        String info="10001,张无忌,男,2023-07-22 11:11:12,东湖-黄鹤楼#10002,赵敏,女,2023-07-22 09:11:21,黄鹤楼-归元禅寺"+
                "#10003,周芷诺,女,2023-07-22 04:11:21,木兰文化区-东湖#10004,小昭,女,2023-07-22 08:11:21,东湖#10005,灭绝,女,2023-07-22 17:11:21,归元禅寺";
        String[] studentsInfo=info.split("#");
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ArrayList<Student> students=new ArrayList<>();
        for (String studentInfo : studentsInfo) {
            String[] studentInfoAll=studentInfo.split(",");
            LocalDateTime ldt=LocalDateTime.parse(studentInfoAll[3],dtf);
            Student s=new Student(Long.parseLong(studentInfoAll[0]),studentInfoAll[1],studentInfoAll[2],ldt,studentInfoAll[4]);
            students.add(s);
        }
        int count1=0,count2=0,count3=0,count4=0;
        for (Student student : students) {
            String selectLoc=student.getSelectAddress();
            if(selectLoc.contains("黄鹤楼"))
            {
                count1 ++;
            }
            if (selectLoc.contains("东湖")) {
                count2 ++;
            }
            if (selectLoc.contains("木兰文化区")) {
                count3++;
            }
            if(selectLoc.contains("归元禅寺"))
            {
                count4++;
            }
        }
        ArrayList<Location> locations=new ArrayList<>();
        Location loc1=new Location("黄鹤楼",count1);
        Location loc2=new Location("东湖",count2);
        Location loc3=new Location("木兰文化区",count3);
        Location loc4=new Location("归元禅寺",count4);
        Collections.addAll(locations,loc1,loc2,loc3,loc4);
        int max=loc1.getCount();
        int i=0;
        for (Location location : locations) {
            System.out.println(location.getName()+"选择的人有"+location.getCount());
            if(location.getCount()>max)
            {
                i++;
                max=location.getCount();
            }
        }
        System.out.println("选择人最多的景点是"+locations.get(i).getName()+",选择的人数为"+max);
        for (Student student : students) {
            if(!(student.getSelectAddress().contains(locations.get(i).getName())))
            {
                System.out.println(student.getName()+"没有选择最热门的景点");
            }
        }
    }


}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Student
{
    private long id;
    private String name;
    private String sex;
    private LocalDateTime localDateTime;
    private String selectAddress;
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Location
{
    private String name;
    private int count;
}