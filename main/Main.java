package main;

public class Main {

    public static void main(String[] args) {
        GraphImpl g = new GraphImpl();

        g.addNode("A");
        g.addNode("B");
        g.addNode("C");
        g.addNode("D");
        g.addNode("E");
        g.addNode("F");

        g.addEdge("A", "B", 2.0);
        g.addEdge("A", "D", 1.0);
        g.addEdge("B", "E", 5.0);
        g.addEdge("C", "E", 4.0);
        g.addEdge("C", "F", 6.0);
        g.addEdge("D", "B", 3.0);
        g.addEdge("D", "C", 3.0);
        g.addEdge("E", "F", 5.0);

        System.out.println("Number of nodes: " + g.numNodes());
        System.out.println("Number of edges: " + g.numEdges());
        String source = "A";
        System.out.println("Length of shortest path from node to source node: ");
        System.out.println(g.dijkstra(source));
    }
}