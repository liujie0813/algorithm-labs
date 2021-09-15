package com.timberliu.algorithm.basic.graph.undirected;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 广度优先搜索
 *
 *          数据结构  类比
 *  广度优先   队列   层级遍历
 *  深度优先   栈     前序遍历
 *
 * @author liujie
 * @date 2021/8/30
 */

public class BreadthFirstPaths {

    // 是否已访问
    private boolean[] marked;
    // 记录路径
    // edgeTo[w] = v, 表示 v-w
    private int[] edgeTo;
    private int start;

    public BreadthFirstPaths(Graph graph, int start) {
        marked = new boolean[graph.vertexCount()];
        edgeTo = new int[graph.vertexCount()];
        this.start = start;
        bfs(graph, start);
    }

    private void bfs(Graph graph, int vertex) {
        Deque<Integer> queue = new LinkedList<>();
        marked[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll == null) {
                break;
            }
            for (Integer w : graph.adj(poll)) {
                if (!marked[w]) {
                    edgeTo[w] = poll;
                    marked[w] = true;
                    queue.offer(w);
                }
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

        BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(graph, 0);
        System.out.println(breadthFirstPaths.hasPathTo(1));

        System.out.println(Arrays.asList(breadthFirstPaths.pathTo(3)));
    }

}
