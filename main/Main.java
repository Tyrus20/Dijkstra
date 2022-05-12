package main;

public class Main {

  public static void main(String[] args) {
    Graph graph1 = new GraphImpl();

    //nodes
    graph1.addNode("A");
    graph1.addNode("B");
    graph1.addNode("C");
    graph1.addNode("D");
    graph1.addNode("E");
    graph1.addNode("F");

    //edges
    graph1.addEdge("A", "B", 2.0);
    graph1.addEdge("A", "D", 1.0);
    graph1.addEdge("B", "E", 5.0);
    graph1.addEdge("C", "E", 4.0);
    graph1.addEdge("C", "F", 6.0);
    graph1.addEdge("D", "B", 3.0);
    graph1.addEdge("D", "C", 3.0);
    graph1.addEdge("E", "F", 5.0);

    //source node
    String source1 = "A";

    System.out.println();
    System.out.println("Graph 1");
    System.out.println("Length of shortest path from source node to destination node: ");
    System.out.println(graph1.dijkstra(source1));

    /*------------------------------------------------------------------------------------------*/
    Graph graph2 = new GraphImpl();

    //airports
    graph2.addNode("DEN"); //Denver International Airport - Denver, Colorado
    graph2.addNode("IAH"); //George Bush Intercontinental Airport - Houston, Texas
    graph2.addNode("JFK"); //John F. Kennedy International Airport - New York City, New York
    graph2.addNode("LAX"); //Los Angeles International Airport - Los Angeles, California
    graph2.addNode("MIA"); //Miami International Airport - Miami, Florida
    graph2.addNode("ORD"); //O'Hare International Airport - Chicago, Illinois
    graph2.addNode("SEA"); //Seattle-Tacoma International Airport - Seattle, Washington

    //flights
    graph2.addEdge("JFK", "MIA", 1089);
    graph2.addEdge("JFK", "ORD", 740);
    graph2.addEdge("ORD", "MIA", 1197);
    graph2.addEdge("ORD", "DEN", 888);
    graph2.addEdge("DEN", "SEA", 1024);
    graph2.addEdge("DEN", "LAX", 862);
    graph2.addEdge("SEA", "LAX", 954);
    graph2.addEdge("MIA", "IAH", 964);
    graph2.addEdge("DEN", "IAH", 862);
    graph2.addEdge("ORD", "IAH", 862);

    //starting airport
    String source2 = "MIA";

    System.out.println();
    System.out.println("Graph 2");
    System.out.println("Length of shortest path from source (" + source2 + ") to destination (in statute miles): ");
    System.out.println(graph2.dijkstra(source2));

    /*------------------------------------------------------------------------------------------*/
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
