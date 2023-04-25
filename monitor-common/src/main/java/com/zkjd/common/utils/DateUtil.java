package com.zkjd.common.utils;

import com.github.pagehelper.util.StringUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: wangtao
 * @CreateTime: 2021-03-24 15:43
 * @Description: 时间工具类
 */
public class DateUtil {


    public static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    public static final DateFormat formatter1 = new SimpleDateFormat("yyyyMMdd");
    public static final String yyyyMMddHHmmss1 = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyyMMddHHmmss2 = "yyyyMMddHHmmss";
    public static final String DATE_FORMATTER = "yyyy-MM-dd";

    /**
     * 判断 传入的时间 是不是大于当前时间 大于返回TRUE 小于返回FALSE
     *
     * @param myDate
     *            日期
     * @return Boolean
     */
    public static Boolean isThanNowTime(Date myDate) {
        if (null == myDate) {
            return true;
        }
        long bbl = myDate.getTime() - new Date().getTime();
        if (bbl > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 大于number小时限制时间 返回TRUE 小于返回FALSE
     *
     * @param firsttime
     * @param currtime
     * @param number
     * @return
     */
    public static boolean isThanLowTime(Date firsttime, Date currtime, String number) {

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(firsttime);
        c1.add(Calendar.HOUR_OF_DAY, Integer.parseInt(number));
        c2.setTime(currtime);
        // System.out.println(DateUtility.formatDateToString(c1.getTime(),"yyyyMMddHHmmss")+"=before--now="+DateUtility.formatDateToString(c2.getTime(),"yyyyMMddHHmmss"));
        int result = c1.compareTo(c2);
        if (result < 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 大于number分钟限制时间 返回TRUE 小于返回FALSE
     *
     * @param firsttime
     * @param currtime
     * @param Minute
     */
    @SuppressWarnings("unused")
    public static boolean isThanLowTimeByMinute(Date firsttime, Date currtime, String Minute) {

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(firsttime);
        c1.add(Calendar.MINUTE, Integer.parseInt(Minute));
        c2.setTime(currtime);
        // System.out.println(DateUtility.formatDateToString(c1.getTime(),"yyyyMMddHHmmss")+"=before--now="+DateUtility.formatDateToString(c2.getTime(),"yyyyMMddHHmmss"));
        int result = c1.compareTo(c2);
        if (result < 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 得到两个日期的分钟之差
     *
     * @param firstDate
     *            开始日期
     * @param lastDate
     *            结束日期
     * @return 分钟之差
     */
    public static Long getMinutes(Date firstDate, Date lastDate) {

        return (lastDate.getTime() - firstDate.getTime()) % (1000 * 60);
    }

    /**
     * 得到两个日期的小时之差
     *
     * @param firstDate
     *            开始日期
     * @param lastDate
     *            结束日期
     * @return 小时之差
     */
    public static Long getHours(Date firstDate, Date lastDate) {

        return (lastDate.getTime() - firstDate.getTime()) % (1000 * 60 * 60);
    }

    /**
     * 得到两个日期的天数之差
     *
     * @param firstDate
     *            开始日期
     * @param lastDate
     *            结束日期
     * @return 天数之差
     */
    public static Long getDays(Date firstDate, Date lastDate) {

        return (lastDate.getTime() - firstDate.getTime()) / (1000 * 60 * 60 * 24);
    }

    /**
     * 返回当前日期,类型为格式"yyyy-mm-dd"的字符串
     *
     * @return
     */
    public static String getDate() {
        SimpleDateFormat d = new SimpleDateFormat();
        d.applyPattern("yyyy-MM-dd");
        Date nowdate = new Date();
        String str_date = d.format(nowdate);
        return str_date;
    }

    /**
     * 返回当前日期,类型为格式"yyyy-mm-dd"的字符串
     *
     * @return
     */
    public static String getDateInfo() {
        SimpleDateFormat d = new SimpleDateFormat();
        d.applyPattern("yyyy-MM-dd");
        Date nowdate = new Date();
        String str_date = d.format(nowdate);
        return str_date + " 00:00:00 000";
    }

    /**
     * 返回当前日期第二天,类型为格式"yyyy-mm-dd"的字符串
     *
     * @return
     */
    public static String getTomorrowDate() {
        SimpleDateFormat d = new SimpleDateFormat();
        d.applyPattern("yyyy-MM-dd");
        Date nowdate = new Date();
        DateUtil date = new DateUtil();
        nowdate = addMinute(1440);
        String str_date = d.format(nowdate);
        return str_date;
    }

    /**
     * 返回当前日期的上一月,类型为格式"yyyyMM"的字符串
     *
     * @return
     */
    public static String getLastMonth() {
        SimpleDateFormat d = new SimpleDateFormat();
        d.applyPattern("yyyyMM");
        Date nowdate = new Date();
        DateUtil date = new DateUtil();
        nowdate = date.addDate(-30);
        String str_date = d.format(nowdate);
        return str_date;
    }

    /**
     * 返回类型为格式"yyyyMMddHHmmss"的字符串
     *
     * @return
     */
    public static String getNowTimeYMDHMS() {
        SimpleDateFormat d = new SimpleDateFormat();
        d.applyPattern("yyyyMMddHHmmss");
        Date nowdate = new Date();
        String str_date = d.format(nowdate);
        return str_date;
    }

    /**
     * 根据自定义格式格式化字符串为yyyyMMddHHmmss Date
     *
     * @param dateString
     * @return
     */
    public static Date getStrToDateYMDHMS(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            return format.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回当前日期字符串 精确到秒
     *
     * @return
     */
    public static String getNow_Time() {
        Date date = new Date();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now_time = simpledateformat.format(date);
        return now_time;
    }

    /**
     * 获取当天的最后一秒
     *
     * @return
     */
    public static String getDate_end() {
        Date date = new Date();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String date_end = simpledateformat.format(date);
        return date_end;
    }

    /**
     * 获取当天的最后一秒
     *
     * @return
     */
    public static String getDate_endByA() {
        Date date = new Date();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd 23:59 a");
        String date_end = simpledateformat.format(date);
        return date_end;
    }

    /**
     * 返回当前日期字符串 精确到分钟
     *
     * @return
     */
    public static String getNow_Minute() {
        Date date = new Date();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String now_time = simpledateformat.format(date);
        return now_time;
    }

    /**
     * 根据自定义格式返回时间字符串
     *
     * @param date
     * @param datePattern
     * @return
     */
    public static String formatDateToString(Date date, String datePattern) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(datePattern);
            return format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据自定义格式格式化字符串为Date
     *
     * @param dateString
     * @param datePattern
     * @return
     */
    public static Date formatStringToDate(String dateString, String datePattern) {
        SimpleDateFormat format = new SimpleDateFormat(datePattern);
        try {
            return format.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 相对当前时间，增加多少分钟
     *
     * @param num
     * @return
     */
    public static Date addMinute(int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, num);

        return calendar.getTime();
    }

    /**
     * 相对当前时间，增加多少年
     *
     * @param num
     * @return
     */
    public static Date addYear(int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, num);

        return calendar.getTime();
    }

    /**
     * 相对当前时间，增加多少月
     *
     * @param num
     * @return
     */
    public static Date addMonth(int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, num);

        return calendar.getTime();
    }

    /**
     * 相对当前时间，增加多少天
     *
     * @param num
     * @return
     */
    public static Date addDate(int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, num);

        return calendar.getTime();
    }

    /**
     * 相对当前时间，增加或减少多少天 负数为减少
     *
     * @param num
     * @return
     */
    public static Date addHOUR(int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, num);
        return calendar.getTime();
    }

    public static Date addDay(int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, num);
        return calendar.getTime();
    }

    /**
     * 根据自定义格式格式化字符串为Date
     *
     * @param dateString
     * @return
     */
    public static String formatStringDate(String dateString) throws Exception {
        dateString = dateString.substring(0, 4) + "-" + dateString.substring(4, 6) + "-" + dateString.substring(6, 8);
        try {

            if (valid(dateString)) {
                return dateString;
            } else {
                throw new Exception("请输入正确的日期格式");
            }

        } catch (Exception e) {

            throw new Exception("请输入正确的日期格式.");
        }
    }

    /**
     * 方法描述：获取当前日期包含小时、分钟、秒的时间字符串 "yyyy-MM-dd HH:mm:ss"
     *
     * @return 指定格式的日期字符串
     */
    public static String getNowFullFormateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * @param str
     * @return
     */
    public static boolean valid(String str) {
        try {
            Date date = (Date) formatter.parse(str);
            return str.equals(formatter.format(date));
        } catch (Exception e) {
            try {
                Date date1 = (Date) formatter1.parse(str);
                return str.equals(formatter1.format(date1));
            } catch (Exception e2) {
                return false;
            }
        }
    }

    public static String splitTime(String time) {
        String str = "";
        if (time != null && time.length() == 4) {
            str = time.substring(0, 2) + ":" + time.substring(2, 4);
        }
        return str;
    }

    /**
     * 获取现在时间
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    public static Date getNowDate() {
        return java.sql.Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    /**
     * 获取现在时间
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static Date getNowDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(8);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }

    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取现在时间
     *
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
    public static String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取时间 小时:分;秒 HH:mm:ss
     *
     * @return
     */
    public static String getTimeShort() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date currentTime = new Date();
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     *
     * @param strDate
     * @return
     */
    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        if (strDate != null) {
            Date strtodate = formatter.parse(strDate, pos);
            return strtodate;
        }
        return null;
    }

    /**
     * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
     *
     * @param dateDate
     * @return
     */
    public static String dateToStrLong(Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    /**
     * 将短时间格式时间转换为字符串 yyyy-MM-dd
     *
     * @param dateDate
     * @return
     */
    public static String dateToStr(Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
        if (strDate == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    public static Date strToDate(String strDate,String sformat) {
        if (strDate == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(sformat);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
    /**
     * 得到现在时间
     *
     * @return
     */
    public static Date getNow() {
        Date currentTime = new Date();
        return currentTime;
    }

    /**
     * 提取一个月中的最后一天
     *
     * @param day
     * @return
     */
    public static Date getLastDate(long day) {
        Date date = new Date();
        long date_3_hm = date.getTime() - 3600000 * 34 * day;
        Date date_3_hm_date = new Date(date_3_hm);
        return date_3_hm_date;
    }

    /**
     * 得到现在时间
     *
     * @return 字符串 yyyyMMdd HHmmss
     */
    public static String getStringToday() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 得到现在小时
     */
    public static String getHour() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        String hour;
        hour = dateString.substring(11, 13);
        return hour;
    }

    /**
     * 得到现在分钟
     *
     * @return
     */
    public static String getTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        String min;
        min = dateString.substring(14, 16);
        return min;
    }

    /**
     * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
     *
     * @param sformat
     *            yyyyMMddhhmmss
     * @return
     */
    public static String getUserDate(String sformat) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(sformat);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
     */
    public static String getTwoHour(String st1, String st2) {
        String[] kk = null;
        String[] jj = null;
        kk = st1.split(":");
        jj = st2.split(":");
        if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0])) {
            return "0";
        } else {
            double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1]) / 60 + Double.parseDouble(kk[2]);
            double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1]) / 60 + Double.parseDouble(jj[2]);
            if ((y - u) > 0){
                return y - u + "";
            }else{
                return "0";
            }

        }
    }

    /**
     * 得到二个日期间的间隔天数
     */
    public static long getTwoDay(String sj1, String sj2) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        long day = 0;
        try {
            Date date = myFormatter.parse(sj1);
            Date mydate = myFormatter.parse(sj2);
            day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            return 0;
        }
        return day;
    }

    /**
     * 时间前推或后推分钟,其中JJ表示分钟.
     */
    public static String getPreTime(String sj1, String jj) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mydate1 = "";
        try {
            Date date1 = format.parse(sj1);
            long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
            date1.setTime(Time * 1000);
            mydate1 = format.format(date1);
        } catch (Exception e) {
        }
        return mydate1;
    }

    /**
     * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
     */
    public static String getNextDay(String nowdate, String delay) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String mdate = "";
            Date d = strToDate(nowdate);
            long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
            d.setTime(myTime * 1000);
            mdate = format.format(d);
            return mdate;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 判断是否润年
     *
     * @param ddate
     * @return
     */
    public static boolean isLeapYear(String ddate) {

        /**
         * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
         * 3.能被4整除同时能被100整除则不是闰年
         */
        Date d = strToDate(ddate,"yyyy-MM");
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(d);
        int year = gc.get(Calendar.YEAR);
        if ((year % 400) == 0)
            return true;
        else if ((year % 4) == 0) {
            if ((year % 100) == 0)
                return false;
            else
                return true;
        } else
            return false;
    }

    /**
     * 返回美国时间格式 26 Apr 2006
     *
     * @param str
     * @return
     */
    public static String getEDate(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(str, pos);
        String j = strtodate.toString();
        String[] k = j.split(" ");
        return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
    }

    /**
     * 获取一个月的最后一天
     *
     * @param dat
     * @return
     */
    public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd
        String str = dat.substring(0, 8);
        String month = dat.substring(5, 7);
        int mon = Integer.parseInt(month);
        if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
            str += "31";
        } else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
            str += "30";
        } else {
            if (isLeapYear(dat)) {
                str += "29";
            } else {
                str += "28";
            }
        }
        return str;
    }

    /**
     * 判断二个时间是否在同一个周
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameWeekDates(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        if (0 == subYear) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
                return true;
        } else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
            // 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
                return true;
        } else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
                return true;
        }
        return false;
    }

    /**
     * 产生周序列,即得到当前时间所在的年度是第几周
     *
     * @return
     */
    public static String getSeqWeek() {
        Calendar c = Calendar.getInstance(Locale.CHINA);
        String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
        if (week.length() == 1)
            week = "0" + week;
        String year = Integer.toString(c.get(Calendar.YEAR));
        return year + week;
    }

    /**
     * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
     *
     * @param sdate
     * @param num
     * @return
     */
    public static String getWeek(String sdate, String num) {
        // 再转换为时间
        Date dd = strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(dd);
        if (num.equals("1")) // 返回星期一所在的日期
            c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        else if (num.equals("2")) // 返回星期二所在的日期
            c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        else if (num.equals("3")) // 返回星期三所在的日期
            c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        else if (num.equals("4")) // 返回星期四所在的日期
            c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        else if (num.equals("5")) // 返回星期五所在的日期
            c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        else if (num.equals("6")) // 返回星期六所在的日期
            c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        else if (num.equals("0")) // 返回星期日所在的日期
            c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    }

    /**
     * 根据一个日期，返回是星期几的字符串
     *
     * @param sdate
     * @return
     */
    public static String getWeek(String sdate) {
        // 再转换为时间
        Date date = strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // int hour=c.get(Calendar.DAY_OF_WEEK);
        // hour中存的就是星期几了，其范围 1~7
        // 1=星期日 7=星期六，其他类推
        return new SimpleDateFormat("EEEE").format(c.getTime());
    }

    public static String getWeekStr(String sdate) {
        String str = "";
        str = getWeek(sdate);
        if ("1".equals(str)) {
            str = "星期日";
        } else if ("2".equals(str)) {
            str = "星期一";
        } else if ("3".equals(str)) {
            str = "星期二";
        } else if ("4".equals(str)) {
            str = "星期三";
        } else if ("5".equals(str)) {
            str = "星期四";
        } else if ("6".equals(str)) {
            str = "星期五";
        } else if ("7".equals(str)) {
            str = "星期六";
        }
        return str;
    }

    /**
     * 两个时间之间的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDays(String date1, String date2) {
        if (date1 == null || date1.equals(""))
            return 0;
        if (date2 == null || date2.equals(""))
            return 0;
        // 转换为标准时间
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date mydate = null;
        try {
            date = myFormatter.parse(date1);
            mydate = myFormatter.parse(date2);
        } catch (Exception e) {
        }
        long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }

    /**
     * 形成如下的日历 ， 根据传入的一个时间返回一个结构 星期日 星期一 星期二 星期三 星期四 星期五 星期六 下面是当月的各个时间
     * 此函数返回该日历第一行星期日所在的日期
     *
     * @param sdate
     * @return
     */
    public static String getNowMonth(String sdate) {
        // 取该时间所在月的一号
        sdate = sdate.substring(0, 8) + "01";

        // 得到这个月的1号是星期几
        Date date = strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int u = c.get(Calendar.DAY_OF_WEEK);
        String newday = getNextDay(sdate, (1 - u) + "");
        return newday;
    }

    /**
     * 取得数据库主键 生成格式为yyyymmddhhmmss+k位随机数
     *
     * @param k
     *            表示是取几位随机数，可以自己定
     */

    public static String getNo(int k) {

        return getUserDate("yyyyMMddhhmmss") + getRandom(k);
    }

    /**
     * 返回一个随机数
     *
     * @param i
     * @return
     */
    public static String getRandom(int i) {
        Random jjj = new Random();
        // int suiJiShu = jjj.nextInt(9);
        if (i == 0)
            return "";
        String jj = "";
        for (int k = 0; k < i; k++) {
            jj = jj + jjj.nextInt(9);
        }
        return jj;
    }

    /**
     * @param date
     */
    public static boolean RightDate(String date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if (date == null)
            return false;
        if (date.length() > 10) {
            sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        } else {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }
        try {
            sdf.parse(date);
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    /**
     * 将formBean 里的字符时间(yyyy-MM-dd) 转换成Date类型
     *
     * @param formDate
     * @return
     */
    public static Date formBeanDateToPODate(String formDate) {
        try {
            if (null != formDate && !"".equals(formDate.trim())) {

                System.out.println("---------formdate:" + formDate);
                return java.sql.Date.valueOf(formDate);

            }
        } catch (Exception e) {
            System.out.println("DateUtils:时间转换异常");
            return new Date();
        }
        return null;
    }

    /**
     * yyyy-MM-dd
     */
    private static final DateFormat DAY_FROMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final DateFormat CURRENTTIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final DateFormat CURRENTHOUR_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH");

    /**
     * 返回跨两个指定日期的日期和时间边界数
     *
     * @param datepart
     * @param startDate
     * @param endDate
     * @return
     */
    public static int DateDiff(String datepart, Date startDate, Date endDate) {

        return 0;

    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param date1
     * @param date2
     */
    public static int diffDate(Date date1, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(date2);

        return diffDate(calendar, calendar2);
    }

    public static int diffDate(Calendar d1, Calendar d2) {
        if (d1.after(d2)) {
            Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
        int y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2) {
            d1 = (Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);// 得到当年的实际天数
                d1.add(Calendar.YEAR, 1);
            } while (d1.get(Calendar.YEAR) != y2);
        }
        return days;
    }

    /**
     * * Get the previous time, from how many days to now. * * 得到当前日期之前的时间
     *
     * @param days
     *            How many days. *
     * @return The new previous time.
     */
    public static long previous(int days) {
        return System.currentTimeMillis() - days * 3600000L * 24L;
    }

    // System.out.println(new Date(previous(10)).toLocaleString());

    /**
     * 根据指定的格式 格式化DATE
     */
    public static String dateFromat(String fromat, Date date) {
        DateFormat dateFormat = new SimpleDateFormat(fromat);

        return dateFormat.format(date);

    }

    /**
     * 返回年份
     *
     * @param date
     *            日期
     * @return 返回年份
     */
    public static int getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    /**
     * 返回月份
     *
     * @param date
     *            日期
     * @return 返回月份
     */
    /*
     * public static int getMonth(Date date) { Calendar c =
     * Calendar.getInstance(); c.setTime(date); return c.get(Calendar.MONTH) +
     * 1; }
     */

    /**
     * 获取日期中的月
     *
     * @param date
     *            日期
     * @return 月份
     */
    public static String getMonth(Date date) {
        // 这个比上面的性能好
        DateFormat f_month = new SimpleDateFormat("MM");
        return f_month.format(date).toString();
    }

    /**
     * 返回日份
     *
     * @param date
     *            日期
     * @return 返回日份
     */
    public static int getDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回小时
     *
     * @param date
     *            日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 返回分钟
     *
     * @param date
     *            日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    /**
     * 获取日期中的星期
     *
     * @param date
     *            日期
     * @return 星期
     */
    public static String getWeek(Date date) {
        DateFormat f_week = new SimpleDateFormat("EEEEEEE");
        return f_week.format(date).toString();
    } // System.out.println("---------"+getWeek(date));

    /**
     * 获取日期中的时间
     *
     * @param date
     *            日期
     * @return 时间
     */
    public static String getTime(Date date) {
        DateFormat f_time = new SimpleDateFormat("HH时mm分 ss秒");
        return f_time.format(date).toString();
    } // System.out.println("---------"+getTime(date));

    /**
     * 返回秒钟
     *
     * @param date
     *            日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.SECOND);
    }

    /**
     * 返回毫秒
     *
     * @param date
     *            日期
     * @return 返回毫秒
     */
    public static long getMillis(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     * 得到某年某月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirestDayOfMonth(int year, int month) {
        month = month - 1;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);

        int day = c.getActualMinimum(c.DAY_OF_MONTH);

        c.set(Calendar.DAY_OF_MONTH, day);
        return c.getTime();

    }

    /**
     * 提到某年某月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(int year, int month) {
        month = month - 1;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        int day = c.getActualMaximum(c.DAY_OF_MONTH);
        c.set(Calendar.DAY_OF_MONTH, day);
        return c.getTime();
    }

    /**
     * 取得当前日期所在周的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return c.getTime();
    }

    /**
     * 取得当前日期所在周的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return c.getTime();
    }

    /**
     * 返回今天是本月的第几天 *
     */
    public static int dayOfMonthOfToday() {
        GregorianCalendar vTodayCal = new GregorianCalendar();
        return vTodayCal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 取得当前时间
     *
     * @return
     */
    public static String getCurrTime() {
        return dateFromat("HH:mm:ss", new Date());
    }

    /**
     * 获取该月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getMonthEnd(Date date) {
        Calendar clar = Calendar.getInstance();
        clar.setTime(date);
        clar.set(Calendar.YEAR, clar.get(Calendar.YEAR));
        clar.set(Calendar.DAY_OF_MONTH, clar.getActualMaximum(Calendar.DATE));// 该月的最后一天
        // clar.set(Calendar.DAY_OF_MONTH,
        // clar.getActualMinimum(Calendar.DATE));//该月的头一天
        return clar.getTime();
    }// System.out.println(getMonthEnd(date));

    /**
     * 获取该月的头天
     *
     * @param date
     * @return <tt>Mon Jun 01 00:00:00 CST 2009</tt>
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar clar = Calendar.getInstance();
        clar.setTime(date);
        clar.set(Calendar.YEAR, clar.get(Calendar.YEAR));
        clar.set(Calendar.DAY_OF_MONTH, clar.getActualMinimum(Calendar.DATE));// 该月的头一天
        clar.set(Calendar.HOUR_OF_DAY, clar.getMinimum(Calendar.HOUR_OF_DAY));
        clar.set(Calendar.MINUTE, clar.getMinimum(Calendar.MINUTE));
        clar.set(Calendar.SECOND, clar.getMinimum(Calendar.SECOND));
        clar.set(Calendar.MILLISECOND, clar.getMinimum(Calendar.MILLISECOND));
        return clar.getTime();
    }// System.out.println(getMonthBegin(date));

    /**
     * 获取当月第一天
     *
     * @return
     */
    public static String getFirstDayOfMonth() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
        return str.toString();
    }

    /**
     * 获取上个月的现在
     *
     * @return
     */
    public static String getNowOfLastMonth() {
        SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        GregorianCalendar aGregorianCalendar = new GregorianCalendar();
        // Get last month GregorianCalendar object
        aGregorianCalendar.set(Calendar.MONTH, aGregorianCalendar.get(Calendar.MONTH) - 1);
        String nowOfLastMonth = aSimpleDateFormat.format(aGregorianCalendar.getTime());
        return nowOfLastMonth;
    }

    /**
     * 获取当前月的第一天，当当前日为1号时获取上一个月的第一天
     *
     * @return
     */
    public static Date getFirstDayOfnMonthAgo(int n) {
        Date date = new Date();
        Calendar clar = Calendar.getInstance();

        clar.setTime(date);
        if (clar.get(Calendar.DAY_OF_MONTH) == 1) {
            clar.set(Calendar.MONTH, clar.get(Calendar.MONTH) - 1);
        }
        clar.set(Calendar.DAY_OF_MONTH, 1);// 该月的头一天
        clar.set(Calendar.HOUR_OF_DAY, 0);
        clar.set(Calendar.MINUTE, 0);
        clar.set(Calendar.SECOND, 0);
        return clar.getTime();
    }

    /**
     * 获取当前月的第一天，当当前日为1号时获取上一个月的第一天
     *
     * @return
     */
    public static Date getFirstDayOf2MonthAgo() {
        Date date = new Date();
        Calendar clar = Calendar.getInstance();
        clar.setTime(date);
        clar.set(Calendar.MONTH, clar.get(Calendar.MONTH) - 2);
        clar.set(Calendar.DAY_OF_MONTH, 1);// 该月的头一天
        clar.set(Calendar.HOUR_OF_DAY, 0);
        clar.set(Calendar.MINUTE, 0);
        clar.set(Calendar.SECOND, 0);
        return clar.getTime();
    }

    /**
     * 得到昨天的最后一秒
     *
     * @return
     */
    public static Date getYesterdayEnd() {
        Date date = new Date();
        Calendar clar = Calendar.getInstance();
        clar.setTime(date);
        clar.set(Calendar.DAY_OF_MONTH, clar.get(Calendar.DAY_OF_MONTH) - 1);
        clar.set(Calendar.HOUR_OF_DAY, 23);
        clar.set(Calendar.MINUTE, 59);
        clar.set(Calendar.SECOND, 59);
        return clar.getTime();
    }

    /**
     * 获取当天查询的开始时间
     *
     * @return
     */
    public static String getNowBeginTime() {
        Date date = new Date();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
        String now_time = simpledateformat.format(date);
        return now_time + " 00:00:00";
    }

    /**
     * 获取当天查询的开始时间
     *
     * @return
     */
    public static String getNowBeginTimeByA() {
        Date date = new Date();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
        String now_time = simpledateformat.format(date);
        return now_time + " 00:00 AM";
    }

    /**
     * 将cst格式转换为yyyy-MM-dd hh:mm:ss
     *
     * @return
     */

    public static String CSTtoString(String olddate) {

        Date date = DateFormat.getDateInstance().parse(olddate, new ParsePosition(1));
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = simpledateformat.format(date);

        return time;

    }

    /**
     * 将cst格式转换为yyyy-MM-dd
     *
     * @return
     */

    public static String CSTtoString2(String olddate) {

        Date date = DateFormat.getDateInstance().parse(olddate, new ParsePosition(1));
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
        String time = simpledateformat.format(date);
        return time;
    }

    public static Date parseDate(String dateStr, SimpleDateFormat format) {
        if (StringUtil.isEmpty(dateStr))
            return null;
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (Exception e) {
            // log.error("parseDate data error:" + dateStr + "!", e);
        }
        return date;
    }

    /**
     * 日期向前后移动几个月
     *
     * @Title: monthMove @Description: TODO @return String @throws
     */
    public static String monthMove(int len) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.MONTH, len);
            return sdf.format(cal.getTime()) + " 00:00:00:000";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取上个月的今天 格式：yyyy-MM-dd
     *
     * @return
     */
    public static String getLastMonthDay() {
        SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar aGregorianCalendar = new GregorianCalendar();
        aGregorianCalendar.set(Calendar.MONTH, aGregorianCalendar.get(Calendar.MONTH) - 1);
        String lastMonthDay = aSimpleDateFormat.format(aGregorianCalendar.getTime());
        return lastMonthDay;
    }

    /**
     * 获取昨天 格式：yyyy-MM-dd
     *
     * @return
     */
    public static String getLastDay() {
        SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar aGregorianCalendar = new GregorianCalendar();
        aGregorianCalendar.set(Calendar.DAY_OF_MONTH, aGregorianCalendar.get(Calendar.DAY_OF_MONTH) - 1);
        String lastDay = aSimpleDateFormat.format(aGregorianCalendar.getTime());
        return lastDay;
    }

    /**
     * 昨天
     *
     * @return
     */
    public static String zuotian() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        return df.format(c.getTime()) + " 00:00:00";
    }

    /**
     * 本周
     *
     * @return
     */
    public static String benzhou() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        c.add(Calendar.DATE, -day_of_week + 1);
        return df.format(c.getTime()) + " 00:00:00";
    }

    /**
     * 本月
     *
     * @return
     */
    public static String benyue() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);
        return df.format(c.getTime()) + " 00:00:00";
    }

    /**
     * 上月
     *
     * @return
     */
    public static String shangyue() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return df.format(c.getTime()) + " 00:00:00";
    }

    /**
     * 上月结束
     *
     * @return
     */
    public static String shangyueend() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.DATE, -1);
        return df.format(c.getTime()) + " 23:59:59";
    }

    /**
     * 计算时间差
     *
     * @param fromDate
     *            开始时间
     * @param toDate
     *            结束时间
     * @return 相差几天
     */
    public static int datePoor(Date fromDate, Date toDate) {
        return (int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24));
    }

    public static String todayStr() {
        return formatDateToStr(new Date(), DATE_FORMATTER);
    }

    /**
     * 按照formatter指定的格式的日期字符串.
     *
     * @param date
     *            需要格式化的日期对像
     * @param formatter
     *            格式化的字符串形式
     */
    public static String formatDateToStr(Date date, String formatter) {
        if (date == null) {
            return "";
        }
        try {
            return new SimpleDateFormat(formatter).format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 计算时间差
     *
     * @param fromDate
     *            开始时间
     * @param toDate
     *            结束时间
     * @return 相差秒
     */
    public static int secondPoor(Date fromDate, Date toDate) {
        return (int) ((toDate.getTime() - fromDate.getTime()) / 1000);
    }

    /**
     * 按格式将字符串日期转为Date类型
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date parseDate(String dateStr, String format) {
        Date date = null;
        DateFormat df = new SimpleDateFormat(format);
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * 将yyyy-MM-dd格式的字符串转为Date类型
     *
     * @param dateStr
     * @return
     */
    public static Date parseDate(String dateStr) {
        return parseDate(dateStr, DATE_FORMATTER);
    }

    public static Date longToDate(long time) {
        Date dt = new Date(time);
        return dt;
    }

    public static String longToString(Long time) {
        if (time == null) {
            return "";
        }
        Date dt = new Date(time);
        return formatDateToStr(dt, DATE_FORMATTER);
    }

    public static String longToSSString(Long time) {
        if (time == null) {
            return "";
        }
        Date dt = new Date(time);
        return formatDateToStr(dt, yyyyMMddHHmmss1);
    }

    /**
     * date:传进来的时间 len:需要改变的天数，正负均可.
     */

    public static String getDay(String date, int len) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(date));
            cal.add(Calendar.DATE, len);
            return sdf.format(cal.getTime());
        } catch (Exception e) {
            return date;
        }
    }

    /**
     * date:传进来的时间 len:需要改变的天数，正负均可. format输入输出的时间格式
     */

    public static String getDay(String date, int len, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(date));
            cal.add(Calendar.DATE, len);
            return sdf.format(cal.getTime());
        } catch (Exception e) {
            return date;
        }
    }

    /**
     * len:距离今天的天数，正负均可.
     */

    public static String getDay(int len) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(date));
            cal.add(Calendar.DATE, len);
            return sdf.format(cal.getTime());
        } catch (Exception e) {
            return date;
        }
    }

    /**
     * 获取当前时间前后len天的时间. format输出的时间格式 len:距离今天的天数，正负均可.
     */

    public static String getDay(int len, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String date = sdf.format(new Date());
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(date));
            cal.add(Calendar.DATE, len);
            return sdf.format(cal.getTime());
        } catch (Exception e) {
            return date;
        }
    }

    /**
     * 获取当前时间前后len小时的时间. format输入输出的时间格式 len:距离当前时间的小时数，正负均可.
     */
    public static String getTimeDistHour(String date, int len, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(date));
            cal.add(Calendar.HOUR, len);
            return sdf.format(cal.getTime());
        } catch (Exception e) {
            return date;
        }
    }

    /**
     * 获取当前时间前后len分钟的时间. format输入输出的时间格式 len:距离当前时间的分钟数，正负均可.
     */
    public static String getTimeDistMinute(String date, int len, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(date));
            cal.add(Calendar.MINUTE, len);
            return sdf.format(cal.getTime());
        } catch (Exception e) {
            return date;
        }
    }

    /**
     * 时间sting转long，自定义格式.
     *
     * @return Long, 如为null或不正确return-1.
     */
    public static long strDateFormatToLong(String date, String format) {
        if (date != null && date.length() >= 8) {
            return (DateUtil.parseDate(date, format).getTime());
        }
        return -1;
    }

    /**
     * 将秒数转换为时分秒
     *
     * @param minitues
     *            秒数
     * @return
     */
    public static String minToHHmmss(String minitues) {
        int seconds = Integer.parseInt(minitues);
        int temp = 0;
        StringBuffer sb = new StringBuffer();
        temp = seconds / 3600;
        if (temp != 0) {
            sb.append((temp < 10) ? "0" + temp + "时" : "" + temp + "时");
        }

        temp = seconds % 3600 / 60;
        if (temp != 0) {
            sb.append((temp < 10) ? "0" + temp + "分" : "" + temp + "分");
        }

        temp = seconds % 3600 % 60;
        if (temp != 0) {
            sb.append((temp < 10) ? "0" + temp + "秒" : "" + temp + "秒");
        }

        return sb.toString();
    }

    public static String dealDateFormat(String oldDate) {
        Date date1 = null;
        DateFormat df2 = null;
        try {
            oldDate= oldDate.replace("Z", " UTC");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
            Date date = df.parse(oldDate);
            SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            date1 = df1.parse(date.toString());
            df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return df2.format(date1);
    }

    /**
     * 计算两个日期相差多少天小时分钟
     * @param endDate
     * @param nowDate
     * @return 返回字符串几时几分钟
     */
    public static String getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return   hour + "小时" + min + "分钟";//day + "天" + hour + "小时" + min + "分钟";
    }




    //获取每个月共有多少天
    public static   Integer getDayOgMOnth(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date date = format.parse(time);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        Integer result = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return result;
    }


    /**
     * 根据日期 找到对应日期的 星期
     */
    public static String getDayOfWeekByDate(String date) {
        String dayOfweek = "-1";
        try {
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate = myFormatter.parse(date);
            SimpleDateFormat formatter = new SimpleDateFormat("E");
            String str = formatter.format(myDate);
            dayOfweek = str;

        } catch (Exception e) {
            System.out.println("错误!");
        }
        return dayOfweek;
    }

    /**
     * 根据年月,获取该月有多少工作日
     */
    public static Integer getWorkdaySizeByMonth(String month) {
        String[] split = month.split("-");
        int year = Integer.parseInt(split[0]);
        int monthNum = Integer.parseInt(split[1]);
        List list = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);// 不设置的话默认为当年
        calendar.set(Calendar.MONTH, monthNum - 1);// 设置月份
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为当月第一天
        int daySize = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);// 当月最大天数
        for (int i = 0; i < daySize-1; i++) {
            calendar.add(Calendar.DATE, 1);//在第一天的基础上加1
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            if (week == Calendar.SATURDAY || week == Calendar.SUNDAY) {// 1代表周日，7代表周六 判断这是一个星期的第几天从而判断是否是周末
                list.add(year+"-"+monthNum+"-"+calendar.get(Calendar.DAY_OF_MONTH));// 得到当天是一个月的第几天
            }
        }
        System.out.println(list);
        return daySize - list.size();
    }

    // 根据两个月份获取两个月份之间的月份列表
    public static List<String> getAllMonthsByBeginAndEnd(String beginMonthStr, String endMonthStr) throws ParseException {
        Date startDate = new SimpleDateFormat("yyyy-MM").parse(beginMonthStr);
        Date endDate = new SimpleDateFormat("yyyy-MM").parse(endMonthStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        // 获取开始年份和开始月份
        int startYear = calendar.get(Calendar.YEAR);
        int startMonth = calendar.get(Calendar.MONTH);
        // 获取结束年份和结束月份
        calendar.setTime(endDate);
        int endYear = calendar.get(Calendar.YEAR);
        int endMonth = calendar.get(Calendar.MONTH);
        //
        List<String> list = new ArrayList<String>();
        for (int i = startYear; i <= endYear; i++) {
            String date = "";
            if (startYear == endYear) {
                for (int j = startMonth; j <= endMonth; j++) {
                    if (j < 9) {
                        date = i + "-0" + (j + 1);
                    } else {
                        date = i + "-" + (j + 1);
                    }
                    list.add(date);
                }

            } else {
                if (i == startYear) {
                    for (int j = startMonth; j < 12; j++) {
                        if (j < 9) {
                            date = i + "-0" + (j + 1);
                        } else {
                            date = i + "-" + (j + 1);
                        }
                        list.add(date);
                    }
                } else if (i == endYear) {
                    for (int j = 0; j <= endMonth; j++) {
                        if (j < 9) {
                            date = i + "-0" + (j + 1);
                        } else {
                            date = i + "-" + (j + 1);
                        }
                        list.add(date);
                    }
                } else {
                    for (int j = 0; j < 12; j++) {
                        if (j < 9) {
                            date = i + "-0" + (j + 1);
                        } else {
                            date = i + "-" + (j + 1);
                        }
                        list.add(date);
                    }
                }

            }

        }

        return list;
    }


    /**
     * @param date 时间格式化转成yyyy年MM月dd日字符串
     * @return
     */
    public static String DateToStrFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String newStr = sdf.format(date);
        return newStr;
    }

    /**
     *
     * 获取传入日期所在月的第一天
     * */

    public static Date getFirstDayDateOfMonth(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTime();
    }
    public static int getWorkDays(int theYear, int theMonth) {
        // 计算指定月有多少工作日
        int workDays = 0;
        Calendar cal = Calendar.getInstance();
        cal.set(theYear, theMonth - 1, 1);// 从每月1号开始
        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < days; i++) {
            int day = cal.get(Calendar.DAY_OF_WEEK);
            if (!(day == Calendar.SUNDAY || day == Calendar.SATURDAY)) {
                workDays++;
            }
            cal.add(Calendar.DATE, 1);
        }
        return workDays;
    }
    /**
     *
     * 获取传入日期所在月的最后一天
     * */
    public static Date getLastDayOfMonth(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTime();
    }
    /**
     * 计算两个日期之间相差的bai天数
     * @param smdate 较小的时间du
     * @param bdate 较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate,Date bdate) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     *
     * @param date 某个月份
     * @return 返回该月份的上个月
     */
    public static Date getOneLastMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }

    /**
     *
     * @return 获取当前时间前几天的日期
     */
    public static String getCurrentBeforeDay(int i) {
        Date dNow = new Date(); //当前时间
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -i);//设置为前一天
        Date dBefore = calendar.getTime(); //得到前一天的时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
        String defaultStartDate = sdf.format(dBefore);//格式化前一天
        return defaultStartDate;
    }

    /**
     * @return 当前时间格式化转成yyyy-MM
     */
    public static String dateToMonthStrFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String date = sdf.format(new Date());
        return date;
    }

    /**
     * @param date 传入的时间
     * @return 时间格式化转成yyyy-MM-dd
     */
    public static String dateToStrFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = sdf.format(date);
        return str;
    }

    /**
     * @param date 传入的时间
     * @return 时间格式化转成yyyy-MM-dd
     */
    public static String dateToTimeStrFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(date);
        return str;
    }




    public static void main(String args[]) {
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        Date lastDayOfMonth = getLastDayOfMonth(new Date());
        System.out.println(sp.format(lastDayOfMonth));
//        Integer weekendSizeByMonth = getWorkdaySizeByMonth("2020-07");
//        System.out.println(weekendSizeByMonth);
//
//        String str = "330";
//        int seconds = Integer.parseInt(str);
//        int temp = 0;
//        StringBuffer sb = new StringBuffer();
//        temp = seconds / 3600;
//        sb.append((temp < 10) ? "0" + temp + ":" : "" + temp + ":");
//
//        temp = seconds % 3600 / 60;
//        sb.append((temp < 10) ? "0" + temp + ":" : "" + temp + ":");
//
//        temp = seconds % 3600 % 60;
//        sb.append((temp < 10) ? "0" + temp : "" + temp);
//
//        System.out.println(getDay(-2,DATE_FORMATTER));
//
//        Date sdate = strToDateLong("2019-08-29 12:10:10");
//
//        int i= diffDate(getNowDate(),sdate);
//        System.out.println(i);
//        Date edate = strToDateLong("2019-08-29 13:56:00");
//
//        String poor = getDatePoor(edate,sdate);
//        // System.out.println(str.substring(str.indexOf("T")+1,str.indexOf(".")));
//        System.out.println("poor==="+poor);
    }
}