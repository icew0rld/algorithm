package graph;

public class KosarajuSCC {
    private boolean[] marked;     // marked[v] = has vertex v been visited?
    private int[] id;             // id[v] = id of strong component containing v
    private int count;            // number of strongly-connected components

    public KosarajuSCC(Digraph g) {

        DepthFirstOrder dfs = new DepthFirstOrder(g.reverse());

        marked = new boolean[g.v()];
        id = new int[g.v()];
        for (int v : dfs.reversePost()) {
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
        }
    }

    // DFS on graph G
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    public int count() {
        return count;
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }
    public static void main(String[] args) {
        Digraph dg = Util.createTinyDG();
        KosarajuSCC kscc = new KosarajuSCC(dg);
        for (int v = 0; v < dg.v(); v++) {
            System.out.print(v + " " + kscc.id(v) + "\n");
        }
    }
}
