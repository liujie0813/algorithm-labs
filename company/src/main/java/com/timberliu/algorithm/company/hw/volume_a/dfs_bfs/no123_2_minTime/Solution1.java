package com.timberliu.algorithm.company.hw.volume_a.dfs_bfs.no123_2_minTime;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liujie
 * @date 2023/5/4
 */

public class Solution1 {

	/**
	 * 5 5
	 * 1  99 99 99 99
	 * 2  99 8  9  10
	 * 3  99 7  99 11
	 * 4  5  6  99 12
	 * 99 99 99 99 13
	 */
	public static void main(String[] args) {
		// 处理输入
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();

		int[][] matrix=new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j]=in.nextInt();
			}
		}
		//从左上角到右下角
		Map<Integer, Integer> left_map = new HashMap<>();
		int[][] left_arr=new int[n][m];
		int distance = 0;
		for(int i = 0;i<n;i++){
			for(int k = 0;k<m;k++){
				if(i==0){
					if(k==0){
						distance = 0;
						left_arr[i][k]=0;
					}else{
						distance = Math.abs(matrix[i][k]-matrix[i][k-1])+left_arr[i][k-1];
						left_arr[i][k]=distance;
					}
				}
				if(i!=0){
					if(k==0){
						distance =Math.abs(matrix[i][k]-matrix[i-1][k])+left_arr[i-1][k];
						left_arr[i][k]=distance;
					}else{
						int top = matrix[i-1][k];
						int left = matrix[i][k-1];
						distance = Math.min(Math.abs(matrix[i][k]-top)+left_arr[i-1][k],Math.abs(matrix[i][k]-left)+left_arr[i][k-1]);
						left_arr[i][k]=distance;
					}
				}

				if(left_map.containsKey(matrix[i][k])){
					left_map.put(matrix[i][k], Math.min(left_map.get(matrix[i][k]),distance));
				}else{
					left_map.put(matrix[i][k],distance);
				}
			}
		}

		//从右下角到左上角
		Map<Integer, Integer> right_map= new HashMap<>();
		int[][] right_arr=new int[n][m];
		for(int i=n-1;i>=0;i--){
			for(int k = m-1;k>=0;k--){
				if(i==n-1){
					if(k==m-1){
						distance = 0;
						right_arr[i][k]=0;
					}else{
						distance = Math.abs(matrix[i][k]-matrix[i][k+1])+right_arr[i][k+1];
						right_arr[i][k]=distance;
					}
				}
				if(i!=matrix.length-1){
					if(k==matrix[i].length-1){
						distance = Math.abs(matrix[i][k]-matrix[i+1][k])+right_arr[i+1][k];
						right_arr[i][k]=distance;
					}else{
						int bottom = matrix[i+1][k];
						int right = matrix[i][k+1];
						distance = Math.min(Math.abs(matrix[i][k]-bottom)+right_arr[i+1][k],Math.abs(matrix[i][k]-right)+right_arr[i][k+1]);
						right_arr[i][k]=distance;
					}
				}
				if(right_map.containsKey(matrix[i][k])){
					right_map.put(matrix[i][k], Math.min(right_map.get(matrix[i][k]),distance));
				}else{
					right_map.put(matrix[i][k],distance);
				}

			}
		}

		//相加取最小
		int res = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> entry : left_map.entrySet()) {
			res = Math.min(res, left_map.get(entry.getKey())+right_map.get(entry.getKey()));
		}

		System.out.println(res);
	}

}
