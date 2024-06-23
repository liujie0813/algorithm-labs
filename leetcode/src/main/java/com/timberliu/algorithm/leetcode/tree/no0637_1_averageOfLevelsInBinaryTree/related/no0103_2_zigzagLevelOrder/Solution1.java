package com.timberliu.algorithm.leetcode.tree.no0637_1_averageOfLevelsInBinaryTree.related.no0103_2_zigzagLevelOrder;

import com.timberliu.algorithm.leetcode.tree.TreeNode;
import com.timberliu.algorithm.leetcode.utils.PrintUtils;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 *
 * @author Timber
 * @date 2024/6/10
 */
public class Solution1 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> firstStack = new LinkedList<>();
        Deque<TreeNode> secondStack = new LinkedList<>();
        firstStack.add(root);
        int level = 1;
        while (true) {
            List<Integer> list = new ArrayList<>();
            if (level % 2 == 1 && !firstStack.isEmpty()) {
                while (!firstStack.isEmpty()) {
                    TreeNode pop = firstStack.pop();
                    list.add(pop.val);
                    if (pop.left != null) {
                        secondStack.push(pop.left);
                    }
                    if (pop.right != null) {
                        secondStack.push(pop.right);
                    }
                }
            } else if (level % 2 == 0 && !secondStack.isEmpty()) {
                while (!secondStack.isEmpty()) {
                    TreeNode pop = secondStack.pop();
                    list.add(pop.val);
                    if (pop.right != null) {
                        firstStack.push(pop.right);
                    }
                    if (pop.left != null) {
                        firstStack.push(pop.left);
                    }
                }
            } else {
                break;
            }
            res.add(list);
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        TreeNode treeNode = TreeNode.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
        List<List<Integer>> res = solution1.zigzagLevelOrder(treeNode);
        PrintUtils.printListListInteger(res);
    }

}
