package graph;

import util.io.In;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int v;
    private int e;
    private List<List<Integer>> adj;
    public Graph(int v) {
        this.v = v;
        this.e = 0;
        adj = new LinkedList<List<Integer>>();
        for (int i = 0; i < v; i++) {
            adj.add(new LinkedList<Integer>());
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++) {
            addEdge(in.readInt(), in.readInt());
        }
    }

    public int v() {
        return v;
    }

    public int e() {
        return e;
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
        e++;
    }

    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(v + " vertices, " + e + " edges\n");
        for (int i = 0; i < v; i++) {
            sb.append(i).append(": ");
            for (int w : this.adj(i)) {
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Util.createGraph());
    }

}
