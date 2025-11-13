package algorithms;

import graph.*;
import java.util.*;

public class Kruskal {

    public static List<Edge> buildMST(Graph graph) {
        List<Edge> edges = new ArrayList<>(graph.getEdges());
        Collections.sort(edges);
        UnionFind uf = new UnionFind(graph.getVerticesCount());
        List<Edge> mst = new ArrayList<>();
        for (Edge e : edges) {
            if (uf.find(e.src) != uf.find(e.dest)) {
                uf.union(e.src, e.dest);
                mst.add(e);
            }
        }
        return mst;
    }
    public static List<Set<Integer>> getComponents(List<Edge> mst, int vertices) {
        UnionFind uf = new UnionFind(vertices);
        for (Edge e : mst)
            uf.union(e.src, e.dest);

        Map<Integer, Set<Integer>> comps = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            int root = uf.find(i);
            comps.putIfAbsent(root, new HashSet<>());
            comps.get(root).add(i);
        }
        return new ArrayList<>(comps.values());
    }
    public static Edge findReplacementEdge(List<Set<Integer>> comps,
                                           List<Edge> allEdges,
                                           List<Edge> mst) {

        Set<Edge> mstSet = new HashSet<>(mst);
        Edge best = null;
        for (Edge e : allEdges) {
            if (mstSet.contains(e)) continue;
            for (Set<Integer> comp : comps) {
                boolean inA = comp.contains(e.src);
                boolean inB = comp.contains(e.dest);
                if (inA && !inB || inB && !inA) {
                    if (best == null || e.weight < best.weight) {
                        best = e;
                    }
                    break;
                }
            }
        }
        return best;
    }
}
