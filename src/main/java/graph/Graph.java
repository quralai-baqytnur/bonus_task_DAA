package graph;

import java.util.*;

public class Graph {
    private int vertices;
    private List<Edge> edges;

    public Graph(int v) {
        this.vertices = v;
        this.edges = new ArrayList<>();
    }
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }
    public List<Edge> getEdges() {
        return edges;
    }
    public int getVerticesCount() {
        return vertices;
    }
}
