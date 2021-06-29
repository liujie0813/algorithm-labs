package com.timberliu.algorithm.tree.no0513_2_findBottomLeftTreeValue;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.Arrays;

/**
 * 513. 找树左下角的值
 *
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    private int maxLevel = -1;
    private int res = -1;

    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 0);
        return res;
    }

    private void findBottomLeftValue(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (level > maxLevel) {
                res = root.val;
                maxLevel = level;
            }
        } else {
            findBottomLeftValue(root.left, level + 1);
            findBottomLeftValue(root.right, level + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/find-bottom-left-tree-value/ -----");
        System.out.println("----- 1 -----");
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.findBottomLeftValue(TreeNode.buildTree(Arrays.asList(2, 1, 3))));

        System.out.println("----- 2 -----");
        Solution1 solution2 = new Solution1();
        System.out.println(solution2.findBottomLeftValue(TreeNode.buildTree(Arrays.asList(1, 2, 3, 4, null, 5, 6, null, null, null, null, 7))));

    }
}
