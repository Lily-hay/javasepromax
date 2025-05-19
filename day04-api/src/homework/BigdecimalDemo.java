package homework;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BigdecimalDemo {
    public static void main(String[] args) {
        double phonePrice=3999;
        double gPrice=9.9;
        double di=0.98;
        int ai=2;
        //double rPrice=(phonePrice+gPrice*2)*0.98;
        BigDecimal a= new BigDecimal(Double.toString(phonePrice));
        BigDecimal b= new BigDecimal(Double.toString(gPrice));
        BigDecimal c= a.add(b.multiply(new BigDecimal(Integer.toString(ai))));
        BigDecimal d= c.multiply(new BigDecimal(Double.toString(di)));
        double allCost=c.doubleValue();
        System.out.println(allCost);
        double result=d.doubleValue();
        System.out.println(result);

        double n1=0.01;
        double n2=0.05;
        BigDecimal b1=new BigDecimal(Double.toString(n1));
        BigDecimal b2=new BigDecimal(Double.toString(n2));
        BigDecimal c1=b1.divide(b2);

        double result1=c1.doubleValue();
        System.out.println(result1);

        String  startTime="2025-05-19 06:00:00";
        LocalDateTime ldt=LocalDateTime.now();
        System.out.println(ldt);

        DateTimeFormatter d1=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime endTime=LocalDateTime.parse(startTime,d1);
        System.out.println(endTime);

        Duration lT=Duration.between(ldt,endTime);

        System.out.println(lT.toHours()+"时"+lT.toSecondsPart()+"分"+lT.toMillisPart()+"秒");
    }
}
