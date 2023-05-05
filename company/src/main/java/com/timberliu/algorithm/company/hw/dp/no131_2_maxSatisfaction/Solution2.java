package com.timberliu.algorithm.company.hw.dp.no131_2_maxSatisfaction;

import java.util.Scanner;

/**
 * @author liujie
 * @date 2023/5/5
 */

public class Solution2 {

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();

		int[][] money = new int[61][3];
		int[][] value = new int[61][3];
		int[][] dp = new int[61][32001];

		for(int i=1;i<=m;i++){
			int a=in.nextInt();
			int b=in.nextInt();
			int c=in.nextInt();
			if(c!=0){//附件
				if(value[c][1]!=0){//附件二
					money[c][2]=a;
					value[c][2]=a*b;
				}
				else{//附件1
					money[c][1]=a;
					value[c][1]=a*b;
				}
			}
			else{
				money[i][0]=a;
				value[i][0]=a*b;

			}
		}
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				dp[i][j]=dp[i-1][j];//什么都不买
				if(money[i][0]<=j){//只主件
					dp[i][j]=Math.max(dp[i][j],dp[i-1][j-money[i][0]]+value[i][0]);

				}
				if(money[i][0]+money[i][1]<=j){//主件+附件1
					dp[i][j]=Math.max(dp[i][j],dp[i-1][j-money[i][0]-money[i][1]]+value[i][0]+value[i][1]);
				}
				if(money[i][0]+money[i][2]<=j){//主件+附件2
					dp[i][j]=Math.max(dp[i][j],dp[i-1][j-money[i][0]-money[i][2]]+value[i][0]+value[i][2]);
				}
				if(money[i][0]+money[i][1]+money[i][2]<=j){//主件+附件1+附件2
					dp[i][j]=Math.max(dp[i][j],dp[i-1][j-money[i][0]-money[i][1]-money[i][2]]+value[i][0]+value[i][1]+value[i][2]);
				}
			}
		}
		System.out.println(dp[m][n]);
	}

}
