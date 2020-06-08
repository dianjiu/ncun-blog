package cn.org.dianjiu.core.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: Point9
 * @Date: 2020/1/14 22:03
 */
public class DateUtils {


    public static int daysBetween(String bgnTime, String endTime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return daysBetween(df.parse(bgnTime),df.parse(endTime));
    }

    public static int daysBetween(Date bgnTime, Date endTime) {
        int between_days = ((int)(endTime.getTime()/1000)-(int)(bgnTime.getTime()/1000))/3600/24+1;
        return between_days;
    }

    /**
     * 日期格式转换
     * @param outputFormat 输出格式
     * @param formatDate 输入格式
     * @return
     */
    public static String formatDate(String formatDate,String outputFormat){
        if(StringUtils.isBlank(formatDate)){
            return formatDate;
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
        DateFormat format3 = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            if(formatDate.indexOf("　")>-1){
                formatDate = formatDate.replaceAll("　", "");
            }
            if((formatDate).matches("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}")){
                date = format.parse(formatDate);
            }else if((formatDate).matches("[0-9]{4}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}")){
                date = format2.parse(formatDate);
            }else if((formatDate).matches("[0-9]{4}[0-9]{2}[0-9]{2}")){
                date = format3.parse(formatDate);
            }else {
                date = format1.parse(formatDate);
            }
            DateFormat outDf = new SimpleDateFormat(outputFormat);
            return outDf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate;
    }

    /**
     * 时间戳转制定日期格式
     * @param strDate 日期字符串
     * @param pattern 日期的格式，如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date longToDate(String strDate, String pattern) {
        if (StringUtils.isBlank(strDate)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            strDate = sdf.format(new Date(Long.parseLong(String.valueOf(strDate))));
            date = stringToDate(strDate, pattern);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 字符串转换成日期
     * @param strDate 日期字符串
     * @param pattern 日期的格式，如：yyyy-MM-dd HH:mm:ss
     */
    public static Date stringToDate(String strDate, String pattern) {
        if (StringUtils.isBlank(strDate)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日期格式转换
     * @param formatDate 日期对象
     * @param outputFormat 输出格式
     * @return
     */
    public static String formatDate(Date formatDate,String outputFormat){
        if( formatDate == null ){
            return null;
        }
        DateFormat outDf = new SimpleDateFormat(outputFormat);
        return outDf.format(formatDate);
    }

    /**
     * 获取两个日期间隔天数(不满24小时算1天，超过24小时算2天)
     * 如：
     * beginDate：2017-07-10 23:00:00
     * endDate：2017-07-11 23:01:00
     * return 2 天
     * 入参为null或异常则返回-1
     * @param beginDate
     * @param endDate
     * @return int
     */
    public static int getUpIntervalDays(Date beginDate, Date endDate) {
        if (null == beginDate || null == endDate) {
            return -1;
        }
        try{
            long diff =  endDate.getTime() - beginDate.getTime();
            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
            long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
            //超过1分钟+1天
            if (hours > 0 || minutes > 0) {
                days +=1;
            }
            return new Long(days).intValue();
        }catch(Exception e){
            return -1;
        }
    }


    /**
     * 计算年龄
     * @param birthDate   生日
     * @param compareDate 需要比较的日期
     * @return int
     */
    public static int getAgeByBirthDate(Date birthDate,Date compareDate){
        if(birthDate == null || compareDate == null){
            return 0;
        }
        //生日
        Calendar birthC = Calendar.getInstance();
        birthC.setTime(birthDate);
        //比较时间
        Calendar compareC = Calendar.getInstance();
        compareC.setTime(compareDate);

        //生日晚于比较日期
        if (compareC.before(birthC)) {
            return 0;
        }

        //计算年龄
        int year = compareC.get(Calendar.YEAR);
        int month = compareC.get(Calendar.MONTH);
        int dayOfMonth = compareC.get(Calendar.DAY_OF_MONTH);

        int yearBirth = birthC.get(Calendar.YEAR);
        int monthBirth = birthC.get(Calendar.MONTH);
        int dayOfMonthBirth = birthC.get(Calendar.DAY_OF_MONTH);

        int age = year - yearBirth;
        if (month <= monthBirth) {
            if (month == monthBirth) {
                if (dayOfMonth < dayOfMonthBirth) {
                    age--;
                }
            }else{
                age--;
            }
        }
        return age;
    }


    /**
     * 日期格式转换
     * @param formatDate 输出格式
     * @return
     */
    public static Date parseDate(String formatDate){
        if(StringUtils.isBlank(formatDate)){
            return null;
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
        DateFormat format3 = new SimpleDateFormat("yyyyMMdd");
        DateFormat format4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            if(formatDate.indexOf("　")>-1){
                formatDate = formatDate.replaceAll("　", "");
            }
            if((formatDate).matches("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}")){
                date = format.parse(formatDate);
            }else if((formatDate).matches("[0-9]{4}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}")){
                date = format2.parse(formatDate);
            }else if((formatDate).matches("[0-9]{4}[0-9]{2}[0-9]{2}")){
                date = format3.parse(formatDate);
            }else if((formatDate).matches("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}")){
                date = format4.parse(formatDate);
            }else {
                date = format1.parse(formatDate);
            }
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = format.parse("2019-04-22 11:20");
        System.out.println(date);

    }
    /**
     * 功能描述：返回月
     *
     * @param date
     *            Date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 功能描述：返回日
     *
     * @param date
     *            Date 日期
     * @return 返回日份
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 功能描述：返回小时
     *
     * @param date
     *            日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 功能描述：返回分
     *
     * @param date
     *            日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     *
     * @param date
     *            Date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 功能描述：返回毫
     *
     * @param date
     *            日期
     * @return 返回毫
     */
    public static long getMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }
    /**
     * 功能描述：返回要求格式的日期字符串
     *
     * @param date
     *            日期
     * @return 返回要求格式的日期字符串
     */
    public static String dateToStr(Date date, String format)
    {
        if (format == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
    public static String getSystemDateStr(String format)
            throws Exception
    {
        return dateToStr(new Date(), format);
    }
    /**
     * 获取两个日期之间的年差
     * @param beginDateStr
     * @param endDateStr
     * @return
     */
    public static BigDecimal getUpIntervalYears(String beginDateStr, String endDateStr){
        BigDecimal num1 = new BigDecimal(12);
        Date beginDate = parseDate(beginDateStr);
        Date endDate = parseDate(endDateStr);
        Calendar c = Calendar.getInstance();
        //获取保险月数(不够一个月的视为一个月)
        c.setTime(beginDate);
        int year1 = c.get(Calendar.YEAR);
        int month1 = c.get(Calendar.MONTH);
        int day1 = c.get(Calendar.DATE);
        c.setTime(endDate);
        int year2 = c.get(Calendar.YEAR);
        int month2 = c.get(Calendar.MONTH);
        int day2 = c.get(Calendar.DATE);
        int monthDiff;
        //同年
        if (year1 == year2) {
            monthDiff = month2 - month1;
            if (day2 > day1) {
                monthDiff = monthDiff + 1;
            }
        } else {//不同年
            monthDiff = 12 * (year2 - year1) + month2 - month1;
            if (day2 > day1) {
                monthDiff = monthDiff + 1;
            }
        }
        return new BigDecimal(monthDiff/12);
    }



}
