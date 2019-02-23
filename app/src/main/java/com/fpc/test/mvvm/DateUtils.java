package com.fpc.test.mvvm;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.databinding.BindingConversion;

public class DateUtils {
    /**
     * date2Str()方法在那个类中不重要，重要的是@BindingConversion注解
     */
    @BindingConversion
    public static String date2Str(Date date){
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
