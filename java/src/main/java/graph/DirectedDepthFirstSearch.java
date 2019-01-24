package graph;

import util.io.FileName;
import util.io.In;

import java.util.ArrayList;
import java.util.List;

public class DirectedDepthFirstSearch {
    boolean[] marked;
    public DirectedDepthFirstSearch(Digraph g, int s) {
        marked = new boolean[g.v()];
        dfs(g, s);
    }

    public DirectedDepthFirstSearch(Digraph g, Iterable<Integer> sources) {
        marked = new boolean[g.v()];
        for (int s : sources) {
            if (!marked[s]) {
                dfs(g, s);
            }
        }
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public static void main(String[] args) {
        Digraph g = new Digraph(new In(FileName.TINY_DG));
        List<Integer> sources = new ArrayList<>();
        sources.add(0);

        DirectedDepthFirstSearch ddfs = new DirectedDepthFirstSearch(g, sources);
        for (int v = 0; v < g.v(); v++) {
            if (ddfs.marked(v)) {
                System.out.print(v + " ");
            }
        }
        System.out.println();
    }

}
