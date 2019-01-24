package graph;

import queue.IndexMinPQ;
import util.io.FileName;
import util.io.In;

import java.util.Deque;
import java.util.LinkedList;

public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;
    public DijkstraSP(EdgeWeightedDigraph g, int s) {
        edgeTo = new DirectedEdge[g.v()];
        distTo = new double[g.v()];
        pq = new IndexMinPQ<>(g.v());
        for (int v = 0; v < g.v(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[0] = 0.0;

        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(g, pq.delMin());
        }
    }
    public double distTo(int v) {
        return distTo[v];
    }
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Deque<DirectedEdge> path = new LinkedList<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
    private void relax(EdgeWeightedDigraph g, int v) {
        for (DirectedEdge e : g.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }
    public static void main(String[] args) {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(new In(FileName.TINY_EWD));
        DijkstraSP sp = new DijkstraSP(g, 0);
        for (int v = 0; v < g.v(); v++) {
            System.out.print("path to ");
            for (DirectedEdge e : sp.pathTo(v)) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
