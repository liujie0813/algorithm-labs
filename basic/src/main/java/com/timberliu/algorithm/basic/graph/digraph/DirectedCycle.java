package com.timberliu.algorithm.basic.graph.digraph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 有向环
 *
 * @author liujie
 * @date 2021/9/14
 */

public class DirectedCycle {

	// 是否访问过
	private boolean[] marked;
	// 顶点是否在栈上
	private boolean[] onStack;

	// 存储遍历过的边
	private int[] edgeTo;
	// 存储环
	private Deque<Integer> cycle;

	public DirectedCycle(Digraph digraph) {
		onStack = new boolean[digraph.vertexCount()];
		edgeTo = new int[digraph.vertexCount()];
		marked = new boolean[digraph.vertexCount()];
		// 并不是所有节点都相连，用所有节点作为起点各遍历一次
		for (int i = 0; i < digraph.vertexCount(); i++) {
			if (!marked[i]) {
				dfs(digraph, i);
			}
		}
	}

	public boolean hasCycle() {
		return cycle != null;
	}

	private void dfs(Digraph digraph, int vertex) {
		onStack[vertex] = true;
		marked[vertex] = true;
		for (Integer w : digraph.adj(vertex)) {
			if (hasCycle()) {
				return;
			} else if (!marked[w]) {
				edgeTo[w] = vertex;
				dfs(digraph, w);
			} else if (onStack[w]) {
				cycle = new LinkedList<>();
				for (int i = vertex; i != w; i = edgeTo[i]) {
					cycle.push(i);
				}
				cycle.push(w);
				cycle.push(vertex);
			}
		}
		onStack[vertex] = false;
	}

	public static void main(String[] args) {
		/*
		 *  0 --> 1
		 *  <     |
		 *  |     |
		 *  |     >
		 *  3 <-- 2
		 */
		Digraph digraph = new Digraph(4);
		digraph.addEdge(0, 1);
		digraph.addEdge(1, 2);
		digraph.addEdge(2, 3);
		digraph.addEdge(3, 1);

		DirectedCycle directedCycle = new DirectedCycle(digraph);
		System.out.println(directedCycle.hasCycle());
	}

}
