package com.timberliu.algorithm.basic.graph.digraph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 深度优先遍历
 *
 * @author liujie
 * @date 2021/9/14
 */

public class DepthFirstOrder {

	private boolean[] marked;
	private Deque<Integer> pre;
	private Deque<Integer> post;
	private Deque<Integer> reversePost;

	public DepthFirstOrder(Digraph digraph) {
		marked = new boolean[digraph.vertexCount()];
		pre = new LinkedList<>();
		post = new LinkedList<>();
		reversePost = new LinkedList<>();
		for (int i = 0; i < digraph.vertexCount(); i++) {
			if (!marked[i]) {
				dfs(digraph, i);
			}
		}
	}

	private void dfs(Digraph digraph, int vertex) {
		pre.offer(vertex);

		marked[vertex] = true;
		for (Integer w : digraph.adj(vertex)) {
			if (!marked[w]) {
				dfs(digraph, w);
			}
		}

		post.offer(vertex);
		reversePost.push(vertex);
	}

	public Deque<Integer> pre() { return pre; }
	public Deque<Integer> post() { return post; }
	public Deque<Integer> reversePost() { return reversePost; }

	public static void main(String[] args) {
		/*
		 *  0 --> 1 --> 3
		 *        |     |
		 *        |     |
		 *        >     >
		 *  5 <-- 2 <-- 4
		 */
		Digraph digraph = new Digraph(6);
		digraph.addEdge(0, 1);
		digraph.addEdge(1, 2);
		digraph.addEdge(1, 3);
		digraph.addEdge(3, 4);
		digraph.addEdge(4, 2);
		digraph.addEdge(2, 5);

		DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph);
		Deque<Integer> pre = depthFirstOrder.pre();
		while (!pre.isEmpty()) {
			System.out.print(pre.poll() + " -> ");
		}
		System.out.println();
		Deque<Integer> post = depthFirstOrder.post();
		while (!post.isEmpty()) {
			System.out.print(post.poll() + " -> ");
		}
		System.out.println();
		Deque<Integer> reversePost = depthFirstOrder.reversePost();
		while (!reversePost.isEmpty()) {
			System.out.print(reversePost.pop() + " -> ");
		}
	}

}
