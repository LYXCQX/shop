package com.lll.shop.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static boolean compare_date(Date dt1 , Date dt2) {
		return dt1.after(dt2);
    }
    public static Date getAfterTme(Date date,int minute) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.add(Calendar.MINUTE, minute);//30分钟后的时间
		return calendar.getTime();
    }
}
