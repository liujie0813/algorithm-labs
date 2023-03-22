package com.timberliu.algorithm.leetcode.tree.no0968_3_binaryTreeCameras;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 968. 监控二叉树
 *  监控所有节点所需的最小摄像头数量
 *
 *  优先把摄像头放到叶子节点的父节点上，然后隔一个节点放一个摄像头，直到根节点
 *    （从上往下，根节点不放置，就省下一个摄像头；
 *      从下往上，叶子节点不放置，省下的摄像头是指数级别的）
 *
 *   如何遍历？后序遍历（就可以从上往下的推导了）
 *
 *   如何推导？
 *    节点状态：0.节点有摄像头；1.节点已覆盖；2.节点未覆盖
 *
 *    分情况：
 *    1. 空节点表示已覆盖（表示未覆盖的话，叶子节点就需要放置摄像头了）
 *    2. 左右子节点至少有一个有摄像头，当前节点就应该是已覆盖
 *    2. 左右子节点都有覆盖，当前节点就应该是未覆盖
 *    3. 左右子节点至少有一个未覆盖，当前节点就应该放置摄像头
 *    4. 最后还要判断头结点，如果未覆盖，就应该放置摄像头
 */

public class Solution1 {

	private int result;

    public int minCameraCover(TreeNode root) {
		result = 0;
		if (dfs(root) == 2) {
			result++;
		}
		return result;
    }

	private int dfs(TreeNode root) {
		if (root == null) {
			return 1;
		}
		int left = dfs(root.left);
		int right = dfs(root.right);
		// 至少有一个未覆盖
		if (left == 2 || right == 2) {
			result++;
			return 0;
		}
		// 都有覆盖
		if (left == 1 && right == 1) {
			return 2;
		}
		// 至少有一个摄像头
		if (left == 0 || right == 0) {
			return 1;
		}
		// 不会走到这里
		return -1;
	}

    public static void main(String[] args) {
		Solution1 solution1 = new Solution1();

		TreeNode tree1 = TreeNode.buildTree(Arrays.asList(0, 0, null, 0, 0));
		int res1 = solution1.minCameraCover(tree1);
		System.out.println(res1);

		TreeNode tree2 = TreeNode.buildTree(Arrays.asList(0,0,null,0,null,0,null,null,0));
		int res2 = solution1.minCameraCover(tree2);
		System.out.println(res2);

		TreeNode tree3 = TreeNode.buildTree(Arrays.asList(0,0,0,null,null,null,0));
		int res3 = solution1.minCameraCover(tree3);
		System.out.println(res3);

	}

}