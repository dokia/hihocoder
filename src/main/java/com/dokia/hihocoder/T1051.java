package com.dokia.hihocoder;

import java.util.Scanner;

public class T1051 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		
		while(testNum-- > 0) {			
			int N = in.nextInt();
			int M = in.nextInt();
			
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
			}
			
			int[] aInt = new int[arr.length + 1];
			aInt[0] = arr[0] - 1;
			for (int i = 1; i < arr.length; i++) {
				aInt[i] = arr[i] - arr[i-1] - 1;
			}
			aInt[arr.length] = 100 - arr[arr.length - 1];
			
			System.out.println(getMaxConsist(aInt, M));
		}
		in.close();
	}
	
	public static int getMaxConsist(int[] arr, int num) {
		if (num >= arr.length - 1) return 100;
		
		int max = 0;
		while(num-- > 0) {
			max = 0;
			int loc = 0;
			for(int i = 0; i < arr.length - 1; i++) {
				if (max < arr[i] + arr[i+1]) {
					loc = i;
					max = arr[i] + arr[i+1];
				}
			}
			int[] tempArr = new int[arr.length - 1];
			for(int i = 0; i < arr.length - 1; i++) {
				if (i < loc) {
					tempArr[i] = arr[i];
				} else if (i == loc) {
					tempArr[i] = arr[i] + arr[i+1] + 1;
				} else {
					tempArr[i] = arr[i+1];
				}
			}
			arr = tempArr;
		}
		
		return max + 1;
	}

}
