package homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        try {
            // 1. 已知日期字符串
            String dateStr = "2015-10-20";

            // 2. 转换为日期对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);

            // 3. 转换为Calendar对象
            Calendar calendar = Calendar.getInstance();
            //calendar.setTime(date);

            // 获取星期几（注意：1=星期日，2=星期一，...）
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            // 获取一年中的第几天
            int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

            // 星期几转换为中文
            String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
            String weekDayStr = weekDays[dayOfWeek - 1];

            System.out.println("日期对象: " + date);
            System.out.println("该日期是: " + weekDayStr);
            System.out.println("是一年中的第 " + dayOfYear + " 天");

        } catch (ParseException e) {
            System.out.println("日期格式不正确，请输入 yyyy-MM-dd 格式的日期。");
        }
    }
}
