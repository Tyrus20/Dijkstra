package main;

public interface Edge {
  /**
   * @return the name of the edge (edge is named after the destination node)
   */
  String getName();

  /**
   * @return the length of the edge
   */
  double getDist();
}
