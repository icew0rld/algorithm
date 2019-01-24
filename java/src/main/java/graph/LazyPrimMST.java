package graph;

import queue.MinPQ;
import util.io.FileName;
import util.io.In;

import java.util.LinkedList;
import java.util.Queue;

public class LazyPrimMST {
    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph g) {
        pq = new MinPQ<>(100);// trick
        marked = new boolean[g.v()];
        mst = new LinkedList<>();
        visit(g, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.offer(e);
            if (!marked[v]) {
                visit(g, v);
            }
            if (!marked[w]) {
                visit(g, w);
            }
        }

    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double res = 0;
        for (Edge e : mst) {
            res += e.weight();
        }
        return res;
    }

    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    public static void main(String[] args) {
        EdgeWeightedGraph g = new EdgeWeightedGraph(new In(FileName.TINY_EWG));
        LazyPrimMST p = new LazyPrimMST(g);
        for (Edge e : p.edges()) {
            System.out.println(e);
        }
        System.out.println();
        System.out.println(p.weight());
    }

}
