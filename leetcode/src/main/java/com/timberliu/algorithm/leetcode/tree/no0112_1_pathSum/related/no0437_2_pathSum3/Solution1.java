package com.timberliu.algorithm.leetcode.tree.no0112_1_pathSum.related.no0437_2_pathSum3;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 *
 *   前缀和、递归、回溯
 *
 *   1. 前缀和：该节点到根节点的路径和
 *   2. 两节点间的路径和 = 两节点的前缀和之差
 *
 *      整体思路：遍历整棵树，记录每个节点的前缀和，每次查询当前节点的祖先节点中符合条件的个数，加到最终结果中
 *
 * Created by liujie on 2021/5/7
 */

public class Solution1 {

    public static int pathSum(TreeNode root, int targetSum) {
        // <前缀和, 该前缀和的节点数量（有几个节点的前缀和等于该值）>
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        return pathSum(root, prefixSumMap, targetSum, 0);
    }

    private static int pathSum(TreeNode root, Map<Integer, Integer> prefixSumMap, int targetSum, int curSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        curSum += root.val;
        // curSum - targetSum == 0，表示从根节点到当前节点即为一条目标和为 targetSum 的路径，这里该路径是要算入最终答案的，所以返回 1
        res += prefixSumMap.getOrDefault(curSum - targetSum, 0);

        prefixSumMap.put(curSum, prefixSumMap.getOrDefault(curSum, 0) + 1);

        res += pathSum(root.left, prefixSumMap, targetSum, curSum);
        res += pathSum(root.right, prefixSumMap, targetSum, curSum);

        prefixSumMap.put(curSum, prefixSumMap.get(curSum) - 1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/path-sum-iii/ -----");
        System.out.println("----- 1 -----");
        System.out.println(pathSum(TreeNode.buildTree(Arrays.asList(10,5,-3,3,2,null,11,3,-2,null,1)), 8));

    }
}
