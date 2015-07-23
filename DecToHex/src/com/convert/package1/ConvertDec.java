package com.convert.package1;

import java.lang.NumberFormatException;

public class ConvertDec {
	public static void main(String[] args) {
		ConvertDec dec = new ConvertDec();
		String s = dec.convert(args[0]);
		System.out.println(s);
	}

	public String convert(String s) {
		s = s.trim();
		if (!isNumeric(s)) {
			return "Invalid input! Please input again";
		} 
		StringBuilder sb = new StringBuilder();
		long n = Long.parseLong(s);
		boolean neg = false;
		
		if (n < 0) {
			neg = true;
			n = -n;
		}

		while (n != 0) {
			long cur = n % 16;
			n /= 16;
			char c = ((cur >= 0 && cur <= 9) ? (char)(cur+'0') : (char)((cur-10)+'A'));
			sb.insert(0, c);
		}
		if (neg) {
			sb.insert(0, '-');
		}
		return sb.toString();
	}

	private static boolean isNumeric(String str) {  
		try {  
			int d = Integer.parseInt(str); 
		}  
		catch (NumberFormatException nfe) {  
			return false;  
		}  
		return true;  
	}
}
