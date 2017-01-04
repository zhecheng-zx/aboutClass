package com.aboutClass.utils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateHelper {
	// 获取系统当前时间
	public static String getNow() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	/**
	 * 获取到期时间
	 * @param day 3:试用3天用户;30:认证试用30用户;365:续约一年用户
	 * @return Date
	 */
	public static Date getEndTime(int day) {
	    Date date =null;
	    Calendar c = Calendar.getInstance();
	    c.setTime(new Date());
	    if(day==7){
	        c.add(Calendar.DAY_OF_MONTH, 7);//day增加3天
	    }
	    else if(day==30){
	    	 c.add(Calendar.MONTH, 1);//month增加1月
	    }else if(day==365){
	    	 c.add(Calendar.YEAR, 1);//year增加1年
	    }
	    date = c.getTime();
		return date;
	}
	public static String getToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Calendar cal = Calendar.getInstance();
		Date currentTime = cal.getTime();
		cal.clear();
		return sdf.format(currentTime);
	}

	/**
	 * 获取的本周开始日期时间
	 * 
	 * @return
	 */
	public static Date getWeekStart() {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY); // 以周1为首日
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date weekStart = cal.getTime();
		cal.clear();
		return weekStart;
	}

	/**
	 * 获取的本月开始日期时间
	 * 
	 * @return
	 */
	public static Date getMonthStart() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date monthStart = cal.getTime();
		cal.clear();
		return monthStart;
	}

	public static Date getday() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date currentTime = cal.getTime();
		cal.clear();
		return currentTime;
	}

	public static Date getYesterdayStart() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date yesterday = cal.getTime();
		cal.clear();
		return yesterday;
	}

	public static Date getYesterdayEnd() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 59);
		Date yesterday = cal.getTime();
		cal.clear();
		return yesterday;
	}

	/**
	 * 最近7天start
	 * @return
	 */
	public static Date getlastweek() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date lastweek = cal.getTime();
		cal.clear();
		return lastweek;
	}

	/**
	 * 最近30天start
	 * @return
	 */
	public static Date getlastmonth() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -30);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date lastmonth = cal.getTime();
		cal.clear();
		return lastmonth;
	}
	/**
	 * 时间大小比较
	 * @param DATE1
	 * @param DATE2
	 * @return  DATE1>DATE2 返回1;
	 */
	public static int compareDate(Date DATE1, Date DATE2) {
        try {
            if (DATE1.getTime() > DATE2.getTime()) {
                return 1;
            } else if (DATE1.getTime() < DATE2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
	
	public static void main(String[]a){
		System.out.println(getlastweek());
	}
}