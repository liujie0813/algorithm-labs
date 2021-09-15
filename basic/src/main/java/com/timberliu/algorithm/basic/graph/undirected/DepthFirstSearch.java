package com.timberliu.algorithm.basic.graph.undirected;

/**
 * 深度优先搜索
 *
 * @author liujie
 * @date 2021/8/30
 */

public class DepthFirstSearch {

    // 是否已访问
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph graph, int start) {
        marked = new boolean[graph.vertexCount()];
        dfs(graph, start);
    }

    private void dfs(Graph graph, int vertex) {
        marked[vertex] = true;
        count++;
        for (Integer w : graph.adj(vertex)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
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

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);
        System.out.println(depthFirstSearch.marked(2));

        System.out.println(depthFirstSearch.count());
    }

}
