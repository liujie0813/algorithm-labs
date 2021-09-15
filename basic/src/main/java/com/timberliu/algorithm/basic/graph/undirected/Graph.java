package com.timberliu.algorithm.basic.graph.undirected;

import java.util.LinkedList;

/**
 * 无向图：邻接表表示
 *
 * @author liujie
 * @date 2021/8/30
 */

public class Graph {

    /**
     * 节点数目
     */
    private final int vertexCount;

    /**
     * 边的数目
     */
    private int edgeCount;

    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adj;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.edgeCount = 0;
        adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public int vertexCount() { return vertexCount; }
    public int edgeCount() { return edgeCount; }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        edgeCount++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public static void main(String[] args) {
        /*
         *  0 --- 1
         *    \   |
         *      \ |
         *  3 --- 2
         */
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(0, 2);

        System.out.println("2: ");
        for (Integer edge : graph.adj(2)) {
            System.out.println(" -> " + edge);
        }
    }
}
