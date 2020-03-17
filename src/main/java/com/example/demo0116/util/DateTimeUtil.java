package com.example.demo0116.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期格式化工具类
 */
public class DateTimeUtil {

    /**
     * 格式 yyyy年MM月dd日 HH:mm:ss
     *
     * @param dateTime
     * @return
     */
    public static String getDateTimeDisplayString(LocalDateTime dateTime) {
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate2 = dtf2.format(dateTime);

        return strDate2;
    }


    /**
     * 格式 yyyy-MM-dd
     *
     * @param dateTime
     * @return
     */
    public static String getDateTime(LocalDateTime dateTime) {
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String strDate2 = dtf2.format(dateTime);

        return strDate2;
    }

    /**
     * LocalDateTime转化为时间戳
     * @param dateTime
     * @return
     */
    public static long getTime(LocalDateTime dateTime) {
        return dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * LocalDateTime转化成Date
     */
    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone( ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date转化为LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return date.toInstant().atZone( ZoneId.systemDefault() ).toLocalDateTime();
    }

    public static LocalDateTime localDateTimeToMinute(LocalDateTime dateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String strDate2 = df.format(dateTime);
        return LocalDateTime.parse(strDate2, df);
    }

    public static LocalDateTime timeToLocalDate(Integer time) {
        return LocalDateTime.ofEpochSecond(time,0,ZoneOffset.ofHours(8));
    }

    public static void main(String[] args) {
        System.out.println(getTime(LocalDateTime.now()) /1000);
    }
}
