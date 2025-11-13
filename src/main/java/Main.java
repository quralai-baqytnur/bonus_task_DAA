import graph.*;
import algorithms.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 2);
        g.addEdge(2, 3, 4);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 5, 6);

        List<Edge> mst = Kruskal.buildMST(g);
        System.out.println("MST");
        printEdges(mst);

        Edge removed = mst.get(2);
        mst.remove(removed);
        System.out.println("\nRemoved edge: " + removed);

        List<Set<Integer>> comps = Kruskal.getComponents(mst, g.getVerticesCount());
        System.out.println("\nComponends after removal");
        printComponents(comps);

        Edge replacement = Kruskal.findReplacementEdge(comps, g.getEdges(), mst);
        if (replacement != null) {
            mst.add(replacement);
            System.out.println("\nReplacement edge found: " + replacement);
        } else {
            System.out.println("\nNo replacement edge found!");
        }

        System.out.println("\nnew MST");
        printEdges(mst);

        System.out.println("\nTotal MST cost = " + totalWeight(mst));
    }

    private static void printEdges(List<Edge> edges) {
        int id = 1;
        for (Edge e : edges) {
            System.out.println(id++ + ") " + e);
        }
    }
    private static void printComponents(List<Set<Integer>> comps) {
        int id = 1;
        for (Set<Integer> s : comps) {
            System.out.println("Component " + id++ + ": " + s);
        }
    }
    private static int totalWeight(List<Edge> mst) {
        int sum = 0;
        for (Edge e : mst) sum += e.weight;
        return sum;
    }
}
