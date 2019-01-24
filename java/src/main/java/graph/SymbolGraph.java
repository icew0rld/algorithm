package graph;

import java.util.HashMap;
import java.util.Map;

public class SymbolGraph {
    private Graph g;
    private String[] names;
    private Map<String, Integer> indexes;
    public SymbolGraph() {
        String[][] src = {
                {"zero", "five"},
                {"four", "three"},
                {"zero", "one"},
                {"nine", "twelve"},
                {"six", "four"},
                {"five", "four"},
                {"zero", "two"},
                {"eleven", "twelve"},
                {"nine", "ten"},
                {"zero", "six"},
                {"seven", "eight"},
                {"nine", "eleven"},
                {"five", "three"}
        };
        int count = 0;
        indexes = new HashMap<>();
        for (String[] edge : src) {
            for (int i = 0; i < edge.length; i++) {
                if (!indexes.containsKey(edge[i])){
                    indexes.put(edge[i], count);
                    count++;
                }

            }
        }

        names = new String[count];
        for (String s : indexes.keySet()){
            names[indexes.get(s)] = s;
        }

        g = new Graph(count);
        for (String[] edge : src) {
            g.addEdge(indexes.get(edge[0]), indexes.get(edge[1]));
        }

    }
    public boolean contains(String key) {
        return indexes.get(key) != null;
    }
    public int index(String key) {
        return indexes.get(key);
    }
    public String name(int v) {
        return names[v];
    }
    Graph g() {
        return g;
    }
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph();
        Graph g = sg.g();
        System.out.print(g);

        for (int i = 0; i < g.v(); i++) {
            System.out.println(i + " " + sg.name(i) + " ");
        }
        System.out.println();
    }
}
