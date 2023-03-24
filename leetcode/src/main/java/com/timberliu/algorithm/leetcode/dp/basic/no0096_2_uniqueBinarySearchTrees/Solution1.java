package com.timberliu.algorithm.leetcode.dp.basic.no0096_2_uniqueBinarySearchTrees;

/**
 * 96. 不同的二叉搜索树
 *   1到n为节点组成的二叉搜索树有多少种
 *
 *  dp[i]：1到i为节点组成的二叉搜索树的个数
 *
 *    dp[i] += dp[以j为头结点的的左子树节点数量] * dp[以j为头结点的的右子树节点数量]
 *             j相当于头结点的元素，从 1 遍历到 i 为止
 *
 *    也就是 dp[i] += dp[j - 1] * dp[i - j]
 *                     j-1：以j为头结点，左子树节点数量
 *                     i-j：以j为头结点，右子树节点数量
 *
 *   dp[0] =  dp[1] = 1
 *
 */

public class Solution1 {

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            // 头结点的元素
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res1 = numTrees(3);
        System.out.println(res1);

        int res2 = numTrees(4);
        System.out.println(res2);
    }

}