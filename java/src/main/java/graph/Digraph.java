package graph;

import util.io.FileName;
import util.io.In;

import java.util.LinkedList;
import java.util.List;

public class Digraph {
    private int v;
    private int e;
    private List<List<Integer>> adj;
    public Digraph(int v) {
        this.v = v;
        this.e = 0;
        adj = new LinkedList<List<Integer>>();
        for (int i = 0; i < v; i++) {
            adj.add(new LinkedList<Integer>());
        }
    }

    public Digraph(In in) {
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

    public Digraph reverse() {
        Digraph g = new Digraph(v());
        for (int i = 0; i < v(); i++) {
            for (int w : adj(i)) {
                g.addEdge(w, i);
            }
        }
        return g;
    }

    public static void main(String[] args) {
        Digraph g = Util.createDigraph();
        System.out.println(g);
        System.out.println(g.reverse());

        Digraph g2 = new Digraph(new In(FileName.TINY_DG));
        System.out.println(g2);
    }
}
