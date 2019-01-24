package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch implements Search {
    private boolean[] marked;
    private int count;
    public BreadthFirstSearch(Graph g, int s) {
        marked = new boolean[g.v()];
        count = 0;
        bfs(g, s);
    }
    public boolean marked(int w) {
        return marked[w];
    }
    public int count() {
        return count;
    }
    private void bfs(Graph g, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        while (!q.isEmpty()){
            int w = q.poll();
            if (!marked[w]) {
                marked[w] = true;
                count++;
                for (int x : g.adj(w)) {
                    q.offer(x);
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph g = Util.createGraph();
        Search dfs = new BreadthFirstSearch(g, 0);

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
