package homework;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Random r = new Random();
        Set<Integer> set=new HashSet<>();
        while(true)
        {
            set.add(r.nextInt(33)+1);
            if(set.size()==6)
            {
                break;
            }
        }
        ArrayList<Integer> redBalls=new ArrayList<>();
        for (Integer b : set) {
            redBalls.add(b);
        }
        Collections.sort(redBalls);
        System.out.println(redBalls);
        int bureBall=r.nextInt(16)+1;
        System.out.println("红球号码为："+redBalls);
        System.out.println("绿球号码为："+bureBall);
    }
}
