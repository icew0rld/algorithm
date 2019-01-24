package graph;

import util.io.In;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {
    private final int v;
    private int e;
    private List<Edge>[] adj;
    public EdgeWeightedGraph(int v) {
        this.v = v;
        this.e = 0;
        adj = (List<Edge>[])new List[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }
    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++) {
            Edge newE = new Edge(in.readInt(), in.readInt(), in.readDouble());
            addEdge(newE);
        }
    }
    public int v() {
        return v;
    }
    public int e() {
        return e;
    }
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        this.e++;
    }
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
    public Iterable<Edge> edges() {
        List<Edge> l = new ArrayList<>();
        for (int v = 0; v < this.v; v++) {
            for (Edge e : adj[v]) {
                if (e.other(v) > v) {
                    l.add(e);
                }
            }
        }
        return l;
    }
}
