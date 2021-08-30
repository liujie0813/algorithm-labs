package com.timberliu.algorithm.basic.graph;

/**
 * 深度优先搜索
 *
 * @author liujie
 * @date 2021/8/30
 */

public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int s) {
        marked = new boolean[g.V()];

    }

    private void dfs(Graph g, int V) {

    }

    public boolean marked(int w) {
        return marked[w];
    }
}
