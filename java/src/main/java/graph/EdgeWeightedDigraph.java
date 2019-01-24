package graph;

import util.io.In;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDigraph {
    private final int v;
    private int e;
    private List<DirectedEdge>[] adj;
    public EdgeWeightedDigraph(int v) {
        this.v = v;
        this.e = 0;
        adj = (List<DirectedEdge>[])new List[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }
    public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++) {
            DirectedEdge newE = new DirectedEdge(in.readInt(), in.readInt(), in.readDouble());
            addEdge(newE);
        }
    }
    public int v() {
        return v;
    }
    public int e() {
        return e;
    }
    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        this.e++;
    }
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }
    public Iterable<DirectedEdge> edges() {
        List<DirectedEdge> l = new ArrayList<>();
        for (int v = 0; v < this.v; v++) {
            for (DirectedEdge e : adj[v]) {
                l.add(e);
            }
        }
        return l;
    }
}
