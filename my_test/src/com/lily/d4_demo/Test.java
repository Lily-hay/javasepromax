package com.lily.d4_demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Liquid water=new Liquid("水",4,24);
        Liquid wuliangye=new Liquid("五粮液",2,4000);
        Liquid milk=new Liquid("牛奶",8,160);
        Liquid maotai=new Liquid("茅台",1,4000);
        Liquid kola=new Liquid("可乐",6,108);

        ArrayList<Liquid> liquids=new ArrayList<>();
        Collections.addAll(liquids,water,wuliangye,milk,maotai,kola);

        //liquids=liquids.stream().sorted((o1,o2)->Double.compare(o1.getOneValue(),o2.getOneValue())).collect(Collectors.toList());
        Collections.sort(liquids,(o1,o2)->Double.compare(o2.getOneValue(), o1.getOneValue()));
        for (Liquid liquid : liquids) {
            System.out.println(liquid);
        }
        int left=10;
        double total=0;
        for (int i = 0; i < liquids.size(); i++) {
           Liquid liquid=liquids.get(i);
           int volume=liquid.getVolume();
           if(volume>=left)
           {
               System.out.println("取走"+liquid.getName()+left+"升");
               total+=liquid.getOneValue()*left;
               break;
           }
           else {
               System.out.println("取走"+liquid.getName()+volume+"升");
               total+=liquid.getOneValue()*volume;
               left=left-volume;
           }
        }
        System.out.println("总价值"+total);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Liquid{
    private String name;
    private int volume;
    private int value;


    public double getOneValue()
    {
        BigDecimal vol=BigDecimal.valueOf(this.volume);
        BigDecimal val=BigDecimal.valueOf(this.value);
        return val.divide(vol,2, RoundingMode.HALF_UP).doubleValue();
    }
}