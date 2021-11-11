//package com.example.demo;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class test {
//    public static void main(String[] args) {
//    	String number = "";
//    	int min;
//    	int max;
//    	List<Integer> numbers = new ArrayList<>();
//    	String stop ="";
//    	Scanner scn = new Scanner(System.in);
//    	
//    	//vòng này chỉ dùng để nhập
//        do {
//        	//check người dùng nhập vào cái j ko phải số hoặc số âm thì bắt nhập lại
//        	try {
//        		System.out.println("Enter a number : ");
//            	number = scn.nextLine();
//        		int x = Integer.parseInt(number); 
//        	}catch(NumberFormatException e) {
//        		System.out.println("input is not an int value"); 
//        	}
//        	
//        	//check trùng số trong list
//        	if(numbers.contains(Integer.parseInt(number))) System.out.println("This number already exists in the list !");
//        	else numbers.add(Integer.parseInt(number));
//        	
//        	//đoạn này bắt nhập y/n nếu nhập cái j khác thì ko nhận input bắt nhập lại
//        	System.out.println("Do you want to continue ?");
//        	do{
//        		stop = scn.nextLine();
//        		if(!stop.equalsIgnoreCase("y") && !stop.equalsIgnoreCase("n")){
//        			System.out.println("Only enter \"y\" or \"n\"! ");
//        		}
//        	}while(!stop.equalsIgnoreCase("y") && !stop.equalsIgnoreCase("n"));
//        //đoạn này để check y thì dừng, n là tiếp tục. T đặt tên biến là stop mà. Cái này ngược với yêu cầu đề
//        }while (stop.trim().equalsIgnoreCase("y"));
//        
//        //thuật toán tìm min max tự lên mạng tìm nhá
//        min = numbers.get(0);
//        max = numbers.get(0);
//        int sum = 0;
//        for(int num : numbers) {
//        	sum += num;
//        	if(num > max) max = num;
//        	if(num < min) min = num;
//        }
//        
//        //Kết quả
//        System.out.println("Max = " + max);
//        System.out.println("Min = " + min);
//        System.out.println("Average = " + (float) sum/numbers.size());
//    }
//}