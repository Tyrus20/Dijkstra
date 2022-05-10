package main;

import java.util.Map;

public interface Graph {
  /**
   * adds a node to the graph
   *
   * @param label - string for name of a5.Node, must be unique
   * @return true if node is successfully added false if label is not unique or is null
   */
  boolean addNode(String label);

  /**
   * adds an edge to the graph
   *
   * @param src - label of source node
   * @param dest - label of destination node
   * @param weight - weight for new edge (use 1 by default)
   * @return true if edge is successfully added false if edge weight is less than 0 false if source
   *     node is not in graph false if destination node is not in graph false is there already is an
   *     edge between these 2 nodes
   */
  boolean addEdge(String src, String dest, double weight);

  /**
   * deletes a node from the graph
   *
   * @param label - label of node to remove
   * @return true if the node is found and successfully removed false if the node does not exist
   */
  boolean deleteNode(String label);

  /**
   * deletes an edge from the graph
   *
   * @param src - label for source node
   * @param dest - label from destination node
   * @return true if the edge is found and successfully removed false if the edge does not exist
   */
  boolean deleteEdge(String src, String dest);

  /**
   * returns how many nodes are in the graph
   *
   * @return - integer 0 or greater that is the number of nodes in the graph
   */
  int numNodes();

  /**
   * returns how many edges are in the graph
   *
   * @return - integer 0 or greater that is the number of edges in the graph
   */
  int numEdges();

  /**
   * runs Dijkstra's algorithm on the graph, starting at the node specified by the start parameter
   * returns a map where the key is the name of the node and the value is the distance from the
   * start node.
   *
   * @param start - source node in the form of a String
   * @return Map of all the nodes in the graph and their distances to the start
   */
  Map<String, Double> dijkstra(String start);
}
