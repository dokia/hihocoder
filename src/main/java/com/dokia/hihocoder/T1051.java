package com.dokia.hihocoder;

import java.util.Scanner;

public class T1051 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		
		while(testNum-- > 0) {			
			int N = in.nextInt();
			int M = in.nextInt();
			
			int[] arr = new int[N + 2];
			arr[0] = 0;
			arr[N] = 100;
			for(int i = 0; i < N; i++) {
				arr[i+1] = in.nextInt();
			}
			
			System.out.println(getMaxConsist(arr, M));
		}
		in.close();
	}
	
	public static int getMaxConsist(int[] arr, int num) {
		if (num >= arr.length - 1) return 100;
		int max = 0;
		for(int i = 0; i < arr.length - num - 1; i++) {
			int tmpMax = arr[i+num+1] - arr[i] -1;
			max = max > tmpMax ? max : tmpMax;
		}
		return max;
	}

}
