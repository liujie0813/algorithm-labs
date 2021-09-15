package com.timberliu.algorithm.basic.graph.weightd.graph;

import java.util.LinkedList;

/**
 * 加权无向图
 *
 * @author liujie
 * @date 2021/9/14
 */

public class WeightedGraph {

	private final int vertexCount;
	private int edgeCount;
	private LinkedList<Edge>[] adj;

	public WeightedGraph(int vertexCount) {
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

	public void addEdge(Edge e) {
		int vertex = e.either();
		int another = e.other(vertex);
		adj[vertex].add(e);
		adj[another].add(e);
		edgeCount++;
	}

	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	public Iterable<Edge> edges() {
		LinkedList<Edge> b = new LinkedList<>();
		for (int v = 0; v < vertexCount; v++) {
			for (Edge e : adj[v]) {
				// 已知一个顶点 v，可以使用 other(v) 得到另一个顶点
				if (e.other(v) > v) {
					// 每条边只添加一次
					b.add(e);
				}
			}
		}
		return b;
	}

	public static void main(String[] args) {
		/*
		 *  0 --> 1 --> 2
		 *        |     |
		 *        |     |
		 *        >     >
		 *  4 <-- 3 --> 5 -- > 6
		 */
		WeightedGraph weightedGraph = new WeightedGraph(7);
		weightedGraph.addEdge(new Edge(0, 1, 0.45));
		weightedGraph.addEdge(new Edge(1, 2, 0.49));
		weightedGraph.addEdge(new Edge(1, 3, 0.55));
		weightedGraph.addEdge(new Edge(2, 5, 0.40));
		weightedGraph.addEdge(new Edge(5, 6, 0.59));
		weightedGraph.addEdge(new Edge(3, 4, 0.35));
		weightedGraph.addEdge(new Edge(3, 5, 0.72));

		for (Edge edge : weightedGraph.edges()) {
			System.out.println(edge);
		}
	}

}
