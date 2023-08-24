package com.jixs.common.util;

import com.jixs.common.constant.DateStyle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具
 *
 * @author: jixs
 * @date: 2020-08-03
 */
public class DateUtil {
    /**
     * 返回字符串的日期格式
     *
     * @param dateStr 日期字符串
     * @return
     */
    public static String match(String dateStr) {
        String result = null;
        if (dateStr.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}.\\d+")) {
            result = DateStyle.YYYY_MM_DD_HH_MM_SS_SSS;
        } else if (dateStr.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
            result = DateStyle.YYYY_MM_DD_HH_MM_SS;
        } else if (dateStr.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")) {
            result = DateStyle.YYYY_MM_DD_HH_MM;
        } else if (dateStr.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}")) {
            result = DateStyle.YYYY_MM_DD_HH;
        } else if (dateStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
            result = DateStyle.YYYY_MM_DD;
        } else if (dateStr.matches("\\d{4}-\\d{2}")) {
            result = DateStyle.YYYY_MM;
        } else if (dateStr.matches("\\d{14}.\\d+")) {
            result = DateStyle.YYYYMMDDHHMMSSS;
        } else if (dateStr.matches("\\d{14}")) {
            result = DateStyle.YYYYMMDDHHMMSS;
        } else if (dateStr.matches("\\d{12}")) {
            result = DateStyle.YYYYMMDDHHMM;
        } else if (dateStr.matches("\\d{10}")) {
            result = DateStyle.YYYYMMDDHH;
        } else if (dateStr.matches("\\d{8}")) {
            result = DateStyle.YYYYMMDD;
        } else if (dateStr.matches("\\d{6}")) {
            result = DateStyle.YYYYMM;
        } else if (dateStr.matches("\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}.\\d+")) {
            result = DateStyle.YYYY_MM_DD_HH_MM_SS_SSS_EN;
        } else if (dateStr.matches("\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
            result = DateStyle.YYYY_MM_DD_HH_MM_SS_EN;
        } else if (dateStr.matches("\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}")) {
            result = DateStyle.YYYY_MM_DD_HH_MM_EN;
        } else if (dateStr.matches("\\d{4}/\\d{2}/\\d{2} \\d{2}")) {
            result = DateStyle.YYYY_MM_DD_HH_EN;
        } else if (dateStr.matches("\\d{4}/\\d{2}/\\d{2}")) {
            result = DateStyle.YYYY_MM_DD_EN;
        } else if (dateStr.matches("\\d{4}/\\d{2}")) {
            result = DateStyle.YYYY_MM_EN;
        } else if (dateStr.matches("\\d{4}")) {
            result = DateStyle.MMYY;
        }
        return result;
    }

    public static Date getNow() {
        return new Date();
    }

    public static String format(Date date, String datePattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        return simpleDateFormat.format(date);
    }

    public static Date toDate(String dateStr, String datePattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        try {
            return simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date plusYears(Date date, int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }

    public static Date plusDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static Date plusHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hours);
        return calendar.getTime();
    }

    public static Date plusSeconds(Date date, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        // 测试
        System.out.println(DateUtil.toDate("2023-08-24 09:54:03.101", DateStyle.YYYY_MM_DD_HH_MM_SS_SSS));
        System.out.println(DateUtil.format(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS_SSS));
        System.out.println("-----------------------");
        System.out.println(DateUtil.plusDays(new Date(), 1));
        System.out.println(DateUtil.plusHours(new Date(), 1));

        // localTime用法
        System.out.println("localTime用法-----------------------");

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(LocalTime.parse("001122", DateTimeFormatter.ofPattern(DateStyle.HHMMSS)));

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(LocalDate.parse("2023-08-24", DateTimeFormatter.ofPattern(DateStyle.YYYY_MM_DD)));

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern(DateStyle.YYYY_MM_DD_HH_MM_SS_SSS)));
        System.out.println(LocalDateTime.parse("2023-08-24 09:54:03.101", DateTimeFormatter.ofPattern(DateStyle.YYYY_MM_DD_HH_MM_SS_SSS)));

        System.out.println("互转-----------------------");
        // 互转
        Date date = new Date();
        System.out.println("互转-----------------------" + date);
        Instant instant = date.toInstant();
        LocalDateTime aa = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        instant = aa.atZone(ZoneId.systemDefault()).toInstant();
        date = Date.from(instant);
        System.out.println("互转-----------------------" + date);

        for (int i = 0; i < 100; i++) {
            System.out.println(i + "----------" + LocalTime.now().getNano());
        }

    }


}
