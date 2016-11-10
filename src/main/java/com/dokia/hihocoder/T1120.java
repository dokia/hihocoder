package com.dokia.hihocoder;

import java.util.Scanner;

public class T1120 {

	private static int mineCount = 0;
	private static int notMineCount = 0;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		
		while (num-- > 0) {
			int N = in.nextInt();
			int M = in.nextInt();
			int[][] maze = new int[N][M];
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
					maze[i][j] = in.nextInt();
			
			handleMaze(maze);
			System.out.println(mineCount + " " + notMineCount);
			mineCount = 0;
			notMineCount = 0;
		}
		in.close();
	}

	private static void handleMaze(int[][] maze) {
		int totalCount = 0;
		do {
			totalCount = 0;
			for(int i = 0; i < maze.length; i++)
				for(int j = 0; j < maze[0].length; j++) {
					totalCount += countUnknownNeighbour(maze, i, j);
				}
		} while (totalCount > 0);
	}
	
	private static int countUnknownNeighbour(int[][] maze, int row, int col) {
		if (maze.length <= 0 || maze[0].length <= 0) return 0;
		if (maze.length <= row || maze[0].length <= col) return 0;
		
		int mineMark = maze[row][col];
		
		int unKnownCount = 0;
		int knownMineCount = 0;
		for(int i = -1; i < 2; i++)
			for(int j = -1; j < 2; j++) {
				if (row + i < 0 || row + i >= maze.length 
						|| col + j < 0 || col + j >= maze[0].length)
					continue;
				if (maze[row + i][col + j] == -1) unKnownCount++;
				if (maze[row + i][col + j] == -3) knownMineCount++;
			}
		
		
		if (unKnownCount == 0) return 0;
		if (mineMark != knownMineCount 
				&& mineMark != knownMineCount + unKnownCount)
			return 0;
		
		int type = 0;
		if (mineMark == knownMineCount) {
			type = -2;
		} else if (mineMark == knownMineCount + unKnownCount) {
			type = -3;
		}
		
		for(int i = -1; i < 2; i++)
			for(int j = -1; j < 2; j++) {
				if (row + i < 0 || row + i >= maze.length 
						|| col + j < 0 || col + j >= maze[0].length)
					continue;
				if (maze[row + i][col + j] == -1) {
					// mine set to -3
					maze[row + i][col + j] = type;
					if (type == -2) {
						notMineCount++;
					} else {
						mineCount++;
					}
				}
			}
		return unKnownCount;
	}
}
