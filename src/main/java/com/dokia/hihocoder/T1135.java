package com.dokia.hihocoder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class T1135 {

	private final static char R = 'R';
	private final static char Y = 'Y';
	private final static char B = 'B';
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int x = in.nextInt();
		int y = in.nextInt();
		int z = in.nextInt();
		String sequence = in.next();
		
		System.out.println(getMaxNum(sequence, x, y, z));
		in.close();
	}

	private static int getMaxNum(String sequence, int x, int y, int z) {
		int Cr = 0;
		int Cy = 0;
		int Cb = 0;
		int maxNum = 0;
		for(int i = 0; i < sequence.length(); i++) {
			switch (sequence.charAt(i))
			{
			case R:
				Cr++;
				break;
			case Y:
				Cy++;
				break;
			case B:
				Cb++;
				break;
			}
			if (match(Cr, Cy, Cb, x, y, z)) {
				maxNum = maxNum > (Cr + Cy + Cb) ? maxNum : (Cr + Cy + Cb);
				Cr = 0;
				Cy = 0;
				Cb = 0;
			}
		}
		maxNum = maxNum > (Cr + Cy + Cb) ? maxNum : (Cr + Cy + Cb);
		
		return maxNum;
	}
	
	private static boolean match(int Cr, int Cy, int Cb, int x, int y, int z) {
		List<Integer> list1 = new LinkedList<Integer>();
		List<Integer> list2 = new LinkedList<Integer>();
		
		list1.add(Math.abs(Cr - Cy));
		list1.add(Math.abs(Cr - Cb));
		list1.add(Math.abs(Cy - Cb));
		list2.add(x);
		list2.add(y);
		list2.add(z);
		
		Collections.sort(list1);
		Collections.sort(list2);
		
		for(int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != list2.get(i))
				return false;
		}
		return true;
	}
}
