package com.timberliu.algorithm.bst.no0501_1_findModeInBinarySearchTree;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.*;

/**
 *  501. 二叉搜索树中的众数
 *
 * Created by liujie on 2021/7/27
 */

public class Solution1 {

    List<Integer> answer = new ArrayList<>();
    int base, count, maxCount;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] res = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            res[i] = answer.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    private void update(int x) {
        if (base == x) {
            count++;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(x);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/ -----");
        Solution1 solution1 = new Solution1();
        int[] res1 = solution1.findMode(TreeNode.buildTree(Arrays.asList(1, null, 2, null, null, 2)));
        System.out.println(Arrays.toString(res1));

    }
}
