package com.wetech.core.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Component
public class CommonConvertUtil {

    public static LocalDate stringToLocalDate(String timeString,String format){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateStr = timeString.replaceAll("/","-");
        LocalDate date = LocalDate.parse(dateStr, fmt);
        return date;
    };
}
