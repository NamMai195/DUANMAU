/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.utlis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nam
 */
public class XDate {
    static SimpleDateFormat formater= new SimpleDateFormat();
//    chuyen string sang date
    public static Date toDate(String date, String pattern){
        try {
            formater.applyPattern(pattern);
            return formater.parse(date);
        } catch (ParseException e) {
        throw new RuntimeException(e);
        }
    }
//    nguoc lai
    public static String toString(Date date,String pattern){
        formater.applyPattern(pattern);
        return formater.format(date);
    }
//    lay h hien tai
    public static Date now(){
        return new Date();
    }
    public static Date addDays(Date date,long days){
        date.setTime(date.getTime()+days *24 *60*60*1000);
        return date;
    }
}
