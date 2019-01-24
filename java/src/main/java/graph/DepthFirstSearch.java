package graph;

public class DepthFirstSearch implements Search{
    private boolean[] marked;
    private int count;
    public DepthFirstSearch(Graph g, int s) {
        marked = new boolean[g.v()];
        count = 0;
        dfs(g, s);
    }
    public boolean marked(int w) {
        return marked[w];
    }
    public int count() {
        return count;
    }
    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }
    public static void main(String[] args) {
        Graph g = Util.createGraph();
        Search dfs = new DepthFirstSearch(g, 0);

        for(int i = 0; i < g.v(); i++) {
            if (dfs.marked(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        if (dfs.count() == g.v()) {
            System.out.println("connected");
        } else {
            System.out.println("not connected");
        }
    }
}
