package homework;

import java.util.ArrayList;
import java.util.Iterator;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<>();
        Student s1=new Student(1,"小亮",99);
        Student s2=new Student(2,"小强",85);
        Student s3=new Student(3,"小响",90);
        Student s4=new Student(4,"小勇",75);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        Iterator<Student> it=list.iterator();
        int min=s1.getScore();
        for(Student s:list)
        {
            if(s.getScore()<min)
            {
                min=s.getScore();
            }
        }
        
        Iterator<Student> it1=list.iterator();
        while(it1.hasNext())
        {
            Student s=it1.next();
            if(s.getScore()==min)
            {
                it1.remove();
            }
        }
        System.out.println(list.toString());
    }
}
class Student{
    private int index;
    private String name;
    private int score;

    public Student(int index, String name, int score) {
        this.index = index;
        this.name = name;
        this.score = score;
    }

    public Student() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}'+"\n";
    }
}