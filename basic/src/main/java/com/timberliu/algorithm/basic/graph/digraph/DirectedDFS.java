package com.timberliu.algorithm.basic.graph.digraph;

/**
 * 有向可达性
 *
 * @author liujie
 * @date 2021/9/14
 */

public class DirectedDFS {

	private boolean[] marked;

	public DirectedDFS(Digraph digraph, int start) {
		marked = new boolean[digraph.vertexCount()];
		dfs(digraph, start);
	}

	public boolean marked(int vertex) {
		return marked[vertex];
	}

	private void dfs(Digraph digraph, int vertex) {
		marked[vertex] = true;
		for (Integer w : digraph.adj(vertex)) {
			if (!marked[w]) {
				dfs(digraph, w);
			}
		}
	}

	public static void main(String[] args) {
		/*
		 *  0 --> 1
		 *    \   |
		 *      \ |
		 *       >
		 *  3 <-- 2
		 */
		Digraph digraph = new Digraph(4);
		digraph.addEdge(0, 1);
		digraph.addEdge(1, 2);
		digraph.addEdge(2, 3);
		digraph.addEdge(0, 2);

		DirectedDFS directedDFS = new DirectedDFS(digraph, 0);
		System.out.println(directedDFS.marked(2));
	}

}
