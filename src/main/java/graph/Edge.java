package graph;
public class Edge implements Comparable<Edge> {
    public int src, dest, weight;

    public Edge(int s, int d, int w) {
        this.src = s;
        this.dest = d;
        this.weight = w;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }

    @Override
    public String toString() {
        return "(" + src + " - " + dest + ", " + weight + ")";
    }
}
