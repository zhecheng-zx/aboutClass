package com.aboutClass.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 获取时间段
 * @author hftan
 */
public class DateUtils {
	
	private static final SimpleDateFormat formatter_yyyymmdd = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat formatter_yyyymmddhhmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 将日期转化为格式字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateFormat(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 将给定日期转化为yyyy-MM-dd格式字符串
	 * @param date
	 * @return
	 */
	public static String dateToYYYYMMDD(Date date){
		return formatter_yyyymmdd.format(date);
	}
	
	/**
	 * 将给定日期转化为yyyy-MM-dd HH:mm:ss格式字符串
	 * @param date
	 * @return
	 */
	public static String dateToYYYYMMDDHHMMSS(Date date){
		return formatter_yyyymmddhhmmss.format(date);
	}
	
	/**
	 * 获取yyyy-MM-dd格式的当前时间
	 * @return
	 */
	public static String currentTimeToYYYYMMDD(){
		return formatter_yyyymmdd.format(Calendar.getInstance().getTime());
	}
	
	/**
	 * 前几天 -1 前1天 -7 前一周 -30 前一个月
	 * 
	 * @param day,天数
	 * @return
	 */
	public static String getBeforeDay(Integer day) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, day);
		return formatter_yyyymmdd.format(c.getTime());
	}
	/**
	 * 获取当前时间Timestamp格式yyyy-MM-dd HH:mm:ss
	 * 2016-3-28
	 */
	public static Timestamp getTimestampYYYYMMDDHHMMSS(){
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = null;
		date = format.format(new Date());
		return Timestamp.valueOf(date);
	}
	public static Date stringTimeToDate(String timeStr){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d = null;
		try {
			d = sim.parse(timeStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	/**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        smdate=formatter_yyyymmdd.parse(formatter_yyyymmdd.format(smdate));  
        bdate=formatter_yyyymmdd.parse(formatter_yyyymmdd.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }    
      
	/** 
	*字符串的日期格式的计算 
	*/  
    public static int daysBetween(String smdate,String bdate) throws ParseException{  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(formatter_yyyymmdd.parse(smdate));    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(formatter_yyyymmdd.parse(bdate));    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));     
    }
}
