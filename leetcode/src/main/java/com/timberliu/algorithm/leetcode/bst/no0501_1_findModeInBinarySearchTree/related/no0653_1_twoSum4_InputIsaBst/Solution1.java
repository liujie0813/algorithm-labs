package com.timberliu.algorithm.leetcode.bst.no0501_1_findModeInBinarySearchTree.related.no0653_1_twoSum4_InputIsaBst;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.*;

/**
 * 653. 两数之和 IV - 输入 BST
 *
 * Created by liujie on 2021/7/27
 */

public class Solution1 {

    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        int i = 0, j = res.size() - 1;
        while (i < j) {
            int sum = res.get(i) + res.get(j);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    private List<Integer> res = new ArrayList<>();

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/ -----");
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.findTarget(TreeNode.buildTree(Arrays.asList(5, 3, 6, 2, 4, null, 7)), 9));

        Solution1 solution2 = new Solution1();
        System.out.println(solution2.findTarget(TreeNode.buildTree(Arrays.asList(5, 3, 6, 2, 4, null, 7)), 28));

        Solution1 solution3 = new Solution1();
        System.out.println(solution3.findTarget(TreeNode.buildTree(Arrays.asList(2, 1, 3)), 4));

    }
}
