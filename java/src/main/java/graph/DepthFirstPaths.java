package graph;

import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstPaths implements Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    public DepthFirstPaths(Graph g, int s) {
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        this.s = s;
        dfs(g, s);
    }
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Deque<Integer> q = new LinkedList<Integer>();
        for (int w = v; w != s; w = edgeTo[w]) {
            q.offerFirst(w);
        }
        q.offerFirst(s);
        return q;
    }
    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }
    public static void main(String[] args) {
        Graph g = Util.createGraph();
        int s = 0;
        Paths p = new DepthFirstPaths(g, s);
        for (int w = 0; w < g.v(); w++) {
            if (p.hasPathTo(w)) {
                System.out.print("path from " + s + " to " + w + ":");
                for (int v : p.pathTo(w)) {
                    System.out.print(v + " ");
                }
                System.out.println();
            }
        }
    }
}
