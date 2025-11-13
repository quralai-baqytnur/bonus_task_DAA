Project description

This project implements a program that builds a MST of a graph using Kruskal’s
algorithm. After building the MST, the program removes one edge and finds another
edge that can reconnect the graph with the smallest possible total weight. The purpose 
of the program is to show how an MST can be rebuilt efficiently when one connection is lost.

Edge lass, Graph class

The project is written in Java and divided into several classes. 
The Edge class represents a connection between two vertices. It stores the start vertex,
end vertex, and weight of the edge. It also implements the Comparable interface so that edges
can be sorted by weight. The Graph class holds information about all vertices and edges in the 
graph. It allows adding edges and provides access to the list of edges and the number of vertices.

UnionFind class

The UnionFind class is an implementation of the disjoint set data structure,
also known as union-find. It helps to check whether two vertices belong to the same 
component and to merge components without creating cycles. This is an essential part of Kruskal’s algorithm.

Kruskal class

The Kruskal class contains the main algorithm. 
It first sorts all edges by weight and then adds them one by one, skipping any that
would create a cycle. This produces the minimum spanning tree. It also contains a
method to find connected components after removing an edge, and another method to
find the smallest edge that reconnects the components, called the replacement edge.

Main class

The Main class runs the program. It creates a graph with several vertices
and weighted edges, builds the MST, removes one edge, finds the connected components, 
searches for a replacement edge, and then builds and prints the new MST. 
It also prints the total cost of the tree before and after the replacement.

Conclusion

In summary, the program successfully demonstrates the process of constructing 
a minimum spanning tree, removing one edge, and finding a replacement edge to keep
the graph connected. The structure of the code is clear and easy to understand. 
The algorithm is correct and efficient enough for small to medium graphs.