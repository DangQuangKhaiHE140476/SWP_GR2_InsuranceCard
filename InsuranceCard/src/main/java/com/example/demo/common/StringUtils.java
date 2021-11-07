package com.example.demo.common;

import org.springframework.stereotype.Service;

@Service
public class StringUtils {
//	public static void main(String[] args) {  
//		String str="true";  
//		System.out.println(convertStringToSQLDate(str));
//	} 
	public boolean convertStringToBoolean(String gender) {
		return Boolean.parseBoolean(gender);
	}
}
