package main;

public class EdgeImpl implements Edge {
  String dest_node;
  double dist;

  public EdgeImpl(String next_node, double next_dist) {
    dest_node = next_node;
    dist = next_dist;
  }

  public String getName() {
    return dest_node;
  }

  public double getDist() {
    return dist;
  }
}
