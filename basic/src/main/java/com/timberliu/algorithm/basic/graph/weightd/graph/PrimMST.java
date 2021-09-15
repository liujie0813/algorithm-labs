package com.timberliu.algorithm.basic.graph.weightd.graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 切分定理
 *    加权图中，将图的顶点分为两个任意集合，在横切边中权重最小的边一定属于图的最小生成树
 *
 * 最小生成树（mst，minimum spanning tree）
 *    一棵含有图的所有顶点，且树中所有边的权重之和最小的生成树
 *
 * Prim 算法
 *    初始时最小生成树中只有一个顶点，随后向它添加 V-1 条边，每次将(下一条连接树中的顶点)与(不在树中的顶点)且权重最小的边加入到树中
 *
 * 实现
 *    维护一个包含所有横切边的优先队列
 *    最坏情况下：
 *      时间：O(ElogE)
 *      空间：O(E)
 *
 * @author liujie
 * @date 2021/9/14
 */

public class PrimMST {

	private boolean[] marked;
	private Deque<Edge> mst;
	// 维护一个包含所有横切边的优先队列
	private PriorityQueue<Edge> priorityQueue;

	public PrimMST(WeightedGraph weightedGraph) {
		marked = new boolean[weightedGraph.vertexCount()];
		mst = new LinkedList<>();
		priorityQueue = new PriorityQueue<>(Edge::compareTo);

		visit(weightedGraph, 0);
		while (!priorityQueue.isEmpty()) {
			Edge edge = priorityQueue.poll();
			int vertex = edge.either();
			int another = edge.other(vertex);
			if (marked[vertex] && marked[another]) {
				continue;
			}
			mst.offer(edge);
			if (!marked[vertex]) {
				visit(weightedGraph, vertex);
			}
			if (!marked[another]) {
				visit(weightedGraph, another);
			}
		}
	}

	private void visit(WeightedGraph weightedGraph, int v) {
		marked[v] = true;
		for (Edge edge : weightedGraph.adj(v)) {
			if (!marked[edge.other(v)]) {
				priorityQueue.offer(edge);
			}
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public static void main(String[] args) {
		/*
		 *  0 --> 1 --> 2
		 *     /  |     | \
		 *    /   |     |  \
		 *   <    >     >   >
		 *  4 <-- 3 --> 5 -- > 6
		 */
		WeightedGraph weightedGraph = new WeightedGraph(7);
		weightedGraph.addEdge(new Edge(0, 1, 0.45));
		weightedGraph.addEdge(new Edge(1, 2, 0.49));
		weightedGraph.addEdge(new Edge(1, 3, 0.55));
		weightedGraph.addEdge(new Edge(1, 4, 0.32));
		weightedGraph.addEdge(new Edge(2, 5, 0.40));
		weightedGraph.addEdge(new Edge(2, 6, 0.20));
		weightedGraph.addEdge(new Edge(5, 6, 0.59));
		weightedGraph.addEdge(new Edge(3, 4, 0.35));
		weightedGraph.addEdge(new Edge(3, 5, 0.72));

		PrimMST primMST = new PrimMST(weightedGraph);
		for (Edge edge : primMST.edges()) {
			System.out.println(edge);
		}
	}

}
