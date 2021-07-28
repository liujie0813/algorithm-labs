package com.timberliu.algorithm.leetcode.tree.no0572_1_subtreeOfAnotherTree.related.no0872_1_leafSimilarTrees;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 872. 叶子相似的树
 *
 * Created by liujie on 2021/5/8
 */

public class Solution1 {

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        if (root1 != null) {
            dfs(root1, res1);
        }

        List<Integer> res2 = new ArrayList<>();
        if (root2 != null) {
            dfs(root2, res2);
        }

        return res1.equals(res2);
    }

    /**
     * 递归获取叶子节点
     */
    private static void dfs(TreeNode root, List<Integer> res) {
        if (root.left == null && root.right == null) {
            res.add(root.val);
        } else {
            if (root.left != null) {
                dfs(root.left, res);
            }
            if (root.right != null) {
                dfs(root.right, res);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/leaf-similar-trees/ -----");
        System.out.println("----- 1 -----");
        System.out.println(leafSimilar(TreeNode.buildTree(Arrays.asList(3,5,1,6,2,9,8,null,null,7,4)),
                TreeNode.buildTree(Arrays.asList(3,5,1,6,7,4,2,null,null,null,null,null,null,9,8))));

    }
}
