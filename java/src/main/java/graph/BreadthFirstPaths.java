package graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths implements Paths{
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    public BreadthFirstPaths(Graph g, int s) {
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        this.s = s;
        bfs(g, s);
    }
    private void bfs(Graph g, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        marked[v] = true;
        while (!q.isEmpty()){
            int w = q.poll();
            for (int x : g.adj(w)) {
                if (!marked[x]) {
                    q.offer(x);
                    marked[x] = true;
                    edgeTo[x] = w;
                }
            }

        }
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
    public static void main(String[] args) {
        Graph g = Util.createGraph();
        int s = 0;
        Paths p = new BreadthFirstPaths(g, s);
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
