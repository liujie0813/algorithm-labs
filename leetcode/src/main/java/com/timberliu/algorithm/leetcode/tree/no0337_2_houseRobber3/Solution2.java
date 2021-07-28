package com.timberliu.algorithm.leetcode.tree.no0337_2_houseRobber3;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 337. 打家劫舍 III
 *
 *   树形 DP，不像常规 DP 在迭代中"填表格"，而是在递归遍历中"填表格"
 *   result[0] 以 root 为根节点的子树，打劫 root 节点的收益
 *   result[1] 以 root 为根节点的子树，不打劫 root 节点的收益
 *
 *   base case 是遍历到 null 时，result[0] 和 result[1] 都为 0
 *
 *   时间复杂度：O(n)，后序遍历
 *   空间复杂度：O(n)，栈空间
 *
 * Created by liujie on 2021/6/28
 */

public class Solution2 {

    public static int rob(TreeNode root) {
        int[] res = doRob(root);
        return Math.max(res[0], res[1]);
    }

    private static int[] doRob(TreeNode root) {
        // 0、包含当前节点的最大值
        // 1、不包含当前节点的最大值
        int[] results = new int[2];
        if (root == null) {
            return results;
        }

        int[] left = doRob(root.left);
        int[] right = doRob(root.right);

        // 包含当前根节点（子节点肯定不包含）
        results[0] = root.val + left[1] + right[1];
        // 不包含当前根节点（子节点可能包含，可能不包含）
        results[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return results;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/house-robber-iii/ -----");
        System.out.println("----- 1 -----");
        System.out.println(rob(TreeNode.buildTree(Arrays.asList(3,2,3,null,3,null,1))));

        System.out.println("----- 2 -----");
        System.out.println(rob(TreeNode.buildTree(Arrays.asList(3,4,5,1,3,null,1))));
    }
}
