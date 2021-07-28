package com.timberliu.algorithm.leetcode.tree.no0112_1_pathSum.related.no0257_1_binaryTreePaths;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 *
 * Created by liujie on 2021/5/7
 */

public class Solution1 {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        binaryTreePaths(root, new ArrayList<>(), res);
        return res;
    }

    private static void binaryTreePaths(TreeNode root, List<Integer> cur, List<String> res) {
        if (root == null) {
            return;
        }
        cur.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(cur.get(0));
            for (int i = 1; i < cur.size(); i++) {
                sb.append("->").append(cur.get(i));
            }
            res.add(sb.toString());
        } else {
            binaryTreePaths(root.left, cur, res);
            binaryTreePaths(root.right, cur, res);
        }
        cur.remove(cur.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/binary-tree-paths/ -----");
        System.out.println("----- 1 -----");
        System.out.println(binaryTreePaths(TreeNode.buildTree(Arrays.asList(1, 2, 3, null, 5))));

    }
}
