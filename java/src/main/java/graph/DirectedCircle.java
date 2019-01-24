package graph;

import util.io.FileName;
import util.io.In;

import java.util.Deque;
import java.util.LinkedList;

public class DirectedCircle {
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Deque<Integer> circle;

    public DirectedCircle(Digraph g) {
        marked = new boolean[g.v()];
        onStack = new boolean[g.v()];
        edgeTo = new int[g.v()];
        for (int v = 0; v < g.v(); v++) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
    }
    public boolean hasCircle() {
        return circle != null;
    }
    public Iterable<Integer> circle() {
        return circle;
    }
    private void dfs(Digraph g, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : g.adj(v)) {
            if (hasCircle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            } else if (onStack[w]) {
                circle = new LinkedList<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    circle.push(x);
                }
                circle.push(w);
                circle.push(v);
            }
        }
        onStack[v] = false;
    }
    public static void main(String[] args) {
        Digraph g = new Digraph(new In(FileName.TINY_DG));
        DirectedCircle dc = new DirectedCircle(g);
        if (dc.hasCircle()) {
            for (int v : dc.circle()) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
