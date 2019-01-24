package graph;

public class ConnectedComponent {
    private int[] component;
    private boolean[] marked;
    private int count;
    public ConnectedComponent(Graph g) {
        component = new int[g.v()];
        marked = new boolean[g.v()];
        count = 0;
        for (int v = 0; v < g.v(); v++) {
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
        }
    }
    public boolean connected(int v, int w) {
        return component[v] == component[w];
    }
    public int count() {
        return count;
    }
    public int id(int v) {
        return component[v];
    }
    private void dfs(Graph g, int v) {
        marked[v] = true;
        component[v] = count;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }
    public static void main(String[] args) {
        Graph g = Util.createGraph();
        ConnectedComponent cc = new ConnectedComponent(g);
        for (int v = 0; v < g.v(); v++) {
            System.out.println(v + " " + cc.id(v) + " ");
        }
    }
}
