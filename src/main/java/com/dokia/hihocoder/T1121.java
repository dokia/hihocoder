package com.dokia.hihocoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class T1121 {
	public enum COLOR {UNCOLOR, WHITE, BLACK}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		
		while (num-- > 0) {
			int N = in.nextInt();
			int M = in.nextInt();
			
			Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
			List<Integer> status = new ArrayList<Integer>(N); // 0 for no status, 1 for white, 2 from black
			for(int i = 0; i < N; i++) status.add(0);
			
			for(int i = 0; i < M; i++) {
				int first = in.nextInt();
				int second = in.nextInt();
				
				if (!graph.containsKey(first)) {
					graph.put(first, new HashSet<Integer>());
				}
				if (!graph.containsKey(second)) {
					graph.put(second, new HashSet<Integer>());
				}
				graph.get(first).add(second);
				graph.get(second).add(first);
			}
			
			boolean flag = true;
			for (Integer i : graph.keySet()) {
				if (status.get(i - 1) != 0) continue;
				if (!setColor(i, 1, status, graph)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("Correct");
			} else {
				System.out.println("Wrong");
			}
		}
		
		in.close();
	}
	
	public static boolean setColor(int node, int color, List<Integer> status, Map<Integer, Set<Integer>> graph) {
		Queue<Integer> queue = new LinkedList<Integer>();
		status.set(node - 1, color);
		
		for (int n : graph.get(node)) {
			queue.add(n);
		}
		while(!queue.isEmpty()) {
			int localNode = queue.poll();
			int localColor = status.get(localNode - 1);
			if (localColor == color) {
				return false;
			}
			if (localColor + color == 3) continue;
			
			if (!setColor(localNode, 3-color, status, graph)) {
				return false;
			}
		}
		return true;
	}
	
}