package com.timberliu.algorithm.tree.no0112_1_pathSum.related.no0113_2_pathSum2;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 *   所有从根节点到叶子节点 路径总和等于给定目标和的路径
 *
 * Created by liujie on 2021/4/28
 */

public class Solution1 {

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, new ArrayList<>(), res, targetSum);
        return res;
    }

    private static void pathSum(TreeNode root, List<Integer> curPath, List<List<Integer>> res, int targetSum) {
        if (root == null) {
            return;
        }
        curPath.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            res.add(new ArrayList<>(curPath));
        } else {
            pathSum(root.left, curPath, res, targetSum - root.val);
            pathSum(root.right, curPath, res, targetSum - root.val);
        }
        curPath.remove(curPath.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/path-sum-ii/solution/lu-jing-zong-he-ii-by-leetcode-solution/ -----");
        System.out.println("----- 1 -----");
        List<List<Integer>> lists = pathSum(TreeNode.buildTree(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1)), 22);
        System.out.println(lists);

    }
}
