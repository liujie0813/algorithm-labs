package com.timberliu.algorithm.basic.graph.undirected;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 单点路径
 *
 * @author liujie
 * @date 2021/8/30
 */

public class DepthFirstPaths {

    // 是否已访问
    private boolean[] marked;
    // 记录路径
    // edgeTo[w] = v, 表示 v-w
    private int[] edgeTo;
    private int start;

    public DepthFirstPaths(Graph graph, int start) {
        marked = new boolean[graph.vertexCount()];
        edgeTo = new int[graph.vertexCount()];
        this.start = start;
        dfs(graph, start);
    }

    private void dfs(Graph graph, int vertex) {
        marked[vertex] = true;
        for (Integer w : graph.adj(vertex)) {
            if (!marked[w]) {
                edgeTo[w] = vertex;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int vertex) {
        return marked[vertex];
    }

    public Iterable<Integer> pathTo(int vertex) {
        if (!hasPathTo(vertex)) {
            return null;
        }
        Deque<Integer> path = new LinkedList<>();
        for (int x = vertex; x != start; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(start);
        return path;
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

        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graph, 0);
        System.out.println(depthFirstPaths.hasPathTo(1));

        System.out.println(Arrays.asList(depthFirstPaths.pathTo(3)));
    }

}
