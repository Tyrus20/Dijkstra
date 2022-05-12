package main;

public class Main {

  public static void main(String[] args) {
    //airport map of the US
    Graph graph1 = new GraphImpl();

    //airports
    graph1.addNode("DEN"); //Denver International Airport - Denver, Colorado
    graph1.addNode("IAH"); //George Bush Intercontinental Airport - Houston, Texas
    graph1.addNode("JFK"); //John F. Kennedy International Airport - New York City, New York
    graph1.addNode("LAX"); //Los Angeles International Airport - Los Angeles, California
    graph1.addNode("MIA"); //Miami International Airport - Miami, Florida
    graph1.addNode("ORD"); //O'Hare International Airport - Chicago, Illinois
    graph1.addNode("SEA"); //Seattle-Tacoma International Airport - Seattle, Washington

    //flights
    graph1.addEdge("JFK", "MIA", 1089);
    graph1.addEdge("JFK", "ORD", 740);
    graph1.addEdge("ORD", "MIA", 1197);
    graph1.addEdge("ORD", "DEN", 888);
    graph1.addEdge("DEN", "SEA", 1024);
    graph1.addEdge("DEN", "LAX", 862);
    graph1.addEdge("SEA", "LAX", 954);
    graph1.addEdge("MIA", "IAH", 964);
    graph1.addEdge("DEN", "IAH", 862);
    graph1.addEdge("ORD", "IAH", 862);

    //starting airport
    String source2 = "MIA";

    System.out.println();
    System.out.println("Graph 1");
    System.out.println("Length of shortest path from source (" + source2 + ") to destination (in statute miles): ");
    System.out.println(graph1.dijkstra(source2));

    /*------------------------------------------------------------------------------------------*/
    //example node graph
    Graph graph2 = new GraphImpl();

    //nodes
    graph2.addNode("A");
    graph2.addNode("B");
    graph2.addNode("C");
    graph2.addNode("D");
    graph2.addNode("E");
    graph2.addNode("F");

    //edges
    graph2.addEdge("A", "B", 2.0);
    graph2.addEdge("A", "C", 4.0);
    graph2.addEdge("B", "C", 1.0);
    graph2.addEdge("B", "D", 4.0);
    graph2.addEdge("B", "E", 2.0);
    graph2.addEdge("C", "E", 3.0);
    graph2.addEdge("D", "E", 3.0);
    graph2.addEdge("D", "F", 2.0);
    graph2.addEdge("E", "F", 2.0);

    //source node
    String source1 = "A";

    System.out.println();
    System.out.println("Graph 2");
    System.out.println("Length of shortest path from source node to destination node: ");
    System.out.println(graph2.dijkstra(source1));

    /*------------------------------------------------------------------------------------------*/
    //feel free to test out your own graph
    Graph graph3 = new GraphImpl();

    //nodes
    graph3.addNode("");

    //edges
    graph3.addEdge("", "", 0.0);

    //source node
    String source3 = "";

    System.out.println();
    System.out.println("Graph 3");
    System.out.println("Length of shortest path from source node to destination node: ");
    System.out.println(graph3.dijkstra(source3));
  }
}
