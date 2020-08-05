package com.jixs.common.util;

import com.jixs.common.constant.DateStyle;

/**
 * 日期工具
 *
 * @author: jixs
 * @date: 2020-08-03
 */
public class DateUtil extends cn.hutool.core.date.DateUtil {
    /**
     * 返回字符串的日期格式
     *
     * @param dateStr 日期字符串
     * @return
     */
    public static String matchs(String dateStr) {
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
}
