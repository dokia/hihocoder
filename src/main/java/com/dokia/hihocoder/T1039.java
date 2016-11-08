package com.dokia.hihocoder;

import java.util.Scanner;

public class T1039 {
	
	public static String[] ALFA = {"A", "B", "C"};
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		
		while (testNum-- > 0) {
			String line = in.next();
			System.out.println(delDupString(line));
		}
		in.close();
	}
	
	public static int delDupString(String str) {
		if (str == null || str.length() <= 0) return 0;
		int max = 0;
		for(int i = 0; i < str.length() + 1; i++) {
			for (int j = 0; j < ALFA.length; j++) {
				if (i == 0) {
					String r = delDupWord(ALFA[j] + str);
					max = max > str.length() + 1 - r.length() ? max : str.length() + 1 - r.length();
				} else if (i == str.length()) {
					String r = delDupWord(str + ALFA[j]);
					max = max > str.length() + 1 - r.length() ? max : str.length() + 1 - r.length();
				} else {
					String r = delDupWord(str.substring(0, i) + ALFA[j] + str.substring(i));
					max = max > str.length() + 1 - r.length() ? max : str.length() + 1 - r.length();
				}
			}
		}
		
		return max;
	}
	
	public static String delDupWord(String str) {
		if (str == null || str.length() <= 0) return "";
		
		StringBuilder sb = new StringBuilder();
		
		boolean dup = false;
		int i = 0;
		while (i < str.length() - 1) {
			if (str.charAt(i) == str.charAt(i+1)) {
				i++;
				dup = true;
			} else {
				if (!dup) {
					sb.append(str.charAt(i));
				}
				i++;
				dup = false;
			}
		}
		if (!dup)
			sb.append(str.charAt(i));
		
		if (sb.toString().length() == str.length())
			return sb.toString();
		else
			return delDupWord(sb.toString());
	}
}
