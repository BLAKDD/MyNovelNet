package edu.njit.mynovelnet.myutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
    /**
     * 获得当前时间
     *
     * @return
     */
    public static String getNowTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 按中国习惯获得上周7天的日期，从最后一天往前排列
     *
     * @return
     */
    public static List<String> getPastWeek() {
        Date date = getLastWeekMondayDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Date today = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            String day = format.format(today);
            result.add(day);
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
        }
        return result;
    }

    /**
     * 获得上周周一日期
     *
     * @return
     */
    public static String getLastWeekMonday() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(getLastWeekMondayDate());
    }

    public static Date getLastWeekMondayDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMondayDate());
        cal.add(Calendar.DATE, -7);
        return cal.getTime();
    }

    /**
     * 获取本周周一Date
     *
     * @return
     */
    public static Date getThisWeekMondayDate() {
        Calendar cal = Calendar.getInstance();
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        if (day == 1) {
            day = 8;
        }
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    public static String getThisWeekMonday() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(getThisWeekMondayDate());
    }

    /**
     * 获取当前年份月份，如202004
     *
     * @return
     */
    public static String getNowYearMonth() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(date);
    }

    /**
     * 获取上月年份月份，如202003
     *
     * @return
     */
    public static String getLastYearMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取上个月全部日期String，格式为yyyyMMdd
     *
     * @return
     */
    public static List<String> getLastMonthAllDate() {
        List<String> list = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        int year = calendar.get(Calendar.YEAR);//年份
        int month = calendar.get(Calendar.MONTH) + 1;//月份
        int day = calendar.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <= day; i++) {
            String aDate = String.valueOf(year);
            aDate += month < 10 ? "0" + month : month;
            aDate += i < 10 ? "0" + i : i;
            list.add(aDate);
        }
        return list;
    }

    /**
     * 获得当前日期
     *
     * @return
     */
    public static String getNowDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }


    public static String getNowDate2() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String getYesterday() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 1);
        return sdf.format(calendar.getTime());
    }

    public static Long getNowDateLong() {
        return tolong(getNowDate2());
    }

    /**
     * 获得过去past天的日期，今天不算
     *
     * @param past
     * @return
     */
    public static List<String> getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < past; i++) {
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 1);
            Date today = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            String day = format.format(today);
            result.add(day);
        }
        return result;
    }

    /**
     * 将yyyy-MM-dd的日期转为long
     *
     * @param st
     * @return
     */
    public static long tolong(String st) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return s.parse(st).getTime();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
    }
}
