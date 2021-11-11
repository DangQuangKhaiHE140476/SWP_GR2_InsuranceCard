package com.example.demo.common;

import java.util.regex.Pattern;

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
	
	public Boolean emailValidate(String email) {
		Boolean validator = false;
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
		if(email != null && Pattern.matches(regex, email)) {
			validator = true;
		}
		return validator;
	}
}
