package com.dokia.hihocoder;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class T1082 {

	private final static String SIGN = "marshtomp";
	private final static String REPLACE = "fjxmlhx";
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String line;
		while(in.hasNext()) {
			line = in.nextLine();
			System.out.println(replaceStr(line));
		}
		in.close();
	}
	
	private static String replaceStr(String str) {
		if (str == null || str.length() < SIGN.length())
			return str;
		List<Integer> list1 = new LinkedList<Integer>();
		List<Integer> list2 = new LinkedList<Integer>();
		for(int i = 0; i < str.length() - SIGN.length() + 1; i++) {
			int j = 0;
			int loc = i;
			while (j < SIGN.length() &&
					(str.charAt(i) == SIGN.charAt(j) || 
					str.charAt(i) == SIGN.charAt(j) - 32)) {
				i++;
				j++;
			}
			if (j == SIGN.length()) {
				list1.add(i - SIGN.length());
				list2.add(i);
				i--;
			} else if (loc != i){
				i = loc;
			}
		}
		if (list1.size() == 0)
			return str;
		StringBuilder sb = new StringBuilder();
		sb.append(str.substring(0, list1.get(0)));
		sb.append(REPLACE);
		
		for(int i = 0; i < list2.size() - 1; i++) {
			sb.append(str.substring(list2.get(i), list1.get(i+1)));
			sb.append(REPLACE);
		}
		sb.append(str.substring(list2.get(list2.size() - 1)));
		
		return sb.toString();
	}
}