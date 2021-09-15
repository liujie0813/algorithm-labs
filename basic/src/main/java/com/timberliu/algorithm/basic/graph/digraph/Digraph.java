package com.timberliu.algorithm.basic.graph.digraph;

import com.timberliu.algorithm.basic.graph.undirected.Graph;

import java.util.LinkedList;

/**
 * 有向图
 *
 * @author liujie
 * @date 2021/9/14
 */

public class Digraph {

	private final int vertexCount;

	private int edgeCount;

	private LinkedList<Integer>[] adj;

	public Digraph(int vertexCount) {
		this.vertexCount = vertexCount;
		this.edgeCount = 0;
		adj = new LinkedList[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public int vertexCount() {
		return vertexCount;
	}

	public int edgeCount() {
		return edgeCount;
	}

	public Iterable<Integer> adj(int vertex) {
		return adj[vertex];
	}

	public void addEdge(int vertex, int w) {
		// 与无向图基本类似，只是这里调用了一次 add
		adj[vertex].add(w);
		edgeCount++;
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

		System.out.print("1");
		for (Integer edge : digraph.adj(1)) {
			System.out.println(" -> " + edge);
		}
	}

}
