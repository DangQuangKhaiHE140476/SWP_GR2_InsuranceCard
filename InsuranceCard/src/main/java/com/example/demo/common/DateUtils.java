package com.example.demo.common;

import java.sql.Date;

import org.springframework.stereotype.Service;

@Service
public class DateUtils {
//	public static void main(String[] args) {  
//	    String str="2021-11-03";  
//	    Date date = convertStringToSQLDate(str);
//	    System.out.println(date);  
//	} 

	public Date convertStringToSQLDate(String dateString) {
		Date date=Date.valueOf(dateString);//converting string into sql date
		return date;
	}
}

