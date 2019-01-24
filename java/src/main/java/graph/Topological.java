package graph;

import util.io.FileName;
import util.io.In;

import java.util.*;

public class Topological {
    Iterable<Integer> order;

    public Topological(Digraph g) {
        DirectedCircle dc = new DirectedCircle(g);
        if (!dc.hasCircle()) {
            DepthFirstOrder dfo = new DepthFirstOrder(g);
            order = dfo.reversePost();
        }
    }
    public boolean isDAG() {
        return order != null;
    }
    public Iterable<Integer> order() {
        return order;
    }
    public static void main(String[] args) {
        Topological t = new Topological(Util.createDigraph());
        for (int v : t.order()) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}

class DepthFirstOrder {
    boolean[] marked;
    Queue<Integer> pre;
    Queue<Integer> post;
    Deque<Integer> reversePost;
    public DepthFirstOrder(Digraph g) {
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new LinkedList<>();

        marked = new boolean[g.v()];
        for (int v = 0; v < g.v(); v++) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
    }

    private void dfs(Digraph g, int v) {
        pre.offer(v);

        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }

        post.offer(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }
    public Iterable<Integer> post() {
        return post;
    }
    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}