package homework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeTask {
    private long startTime ;

    // 构造方法，对秒杀开始时间进行初始化
    public TimeTask() {

        // 补全代码

    }


    public void run() {                                 // 每一秒执行一次该方法

        // 补全代码
        DateTimeFormatter d=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime Ldt1=LocalDateTime.parse(Long.toString(startTime),d);
        LocalDateTime ldt=LocalDateTime.now();


    }
}
