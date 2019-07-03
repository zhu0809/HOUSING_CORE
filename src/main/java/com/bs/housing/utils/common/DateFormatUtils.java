package com.bs.housing.utils.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2019/7/3 16:33</p>
 */
public class DateFormatUtils {
    public static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(dateFormat);

    public static String format(Date date) {
        return SIMPLE_DATE_FORMAT.format(date);
    }

    public static Date parse(String dateFormat) throws ParseException {
        return SIMPLE_DATE_FORMAT.parse(dateFormat);
    }
}
