package com.timberliu.algorithm.company.hw.volume_a.tree.no112_2_buildBinaryTree;

import java.util.*;

/**
 * 112. 构建二叉树
 *
 *  operation[i] = [height, index] 对第 height 层的第 index 个节点 node，添加值为 i 的子节点（无左添左，有左添右）
 *  index：所在层的创建顺序
 *
 * @author liujie
 * @date 2023/4/13
 */

public class Solution1 {

	public static class TreeNode {
		private int value;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}
	}

	public static TreeNode buildTree(int[][] opeartions) {
		TreeNode root = new TreeNode(-1);
		List<List<TreeNode>> treeList = new ArrayList<>();
		treeList.add(new ArrayList<TreeNode>() {{
			add(root);
		}});

		for (int i = 0; i < opeartions.length; i++) {
			int height = opeartions[i][0];
			int index = opeartions[i][1];

			if (treeList.size() <= height + 1) {
				treeList.add(new ArrayList<>());
			}

			TreeNode node = new TreeNode(i);
			TreeNode parent = treeList.get(height).get(index);
			if (parent.left == null) {
				parent.left = node;
				treeList.get(height + 1).add(node);
			} else if (parent.right == null) {
				parent.right = node;
				treeList.get(height + 1).add(node);
			}
		}
		return root;
	}

	public static String printTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		LinkedList<String> list = new LinkedList<>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node != null) {
				list.add(String.valueOf(node.value));
				queue.offer(node.left);
				queue.offer(node.right);
			} else {
				list.add("null");
			}
		}
		while ("null".equals(list.getLast())) {
			list.removeLast();
		}
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			if (i != list.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * eg1: [[0, 0], [0, 0], [1, 1], [1, 0], [0, 0]]
	 * eg2: [[0, 0], [1, 0], [1, 0], [2, 1], [2, 1], [2, 1], [2, 0], [3, 1], [2, 0]]
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String[] splits = str.replace("[", "").replace("]", "").split(", ");
		int n = splits.length;
		int[][] operations = new int[n / 2][2];
		for (int i = 0; i < n; i += 2) {
			operations[i / 2][0] = Integer.parseInt(splits[i]);
			operations[i / 2][1] = Integer.parseInt(splits[i + 1]);
		}

		TreeNode root = buildTree(operations);
		String res = printTree(root);
		System.out.println(res);
	}

}
