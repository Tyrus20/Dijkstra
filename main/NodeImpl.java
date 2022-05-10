package main;

public class NodeImpl implements Node {
  String name;
  double dist;

  public NodeImpl(String node_name) {
    name = node_name;
    dist = 0;
  }

  @Override
  public String getName() {
    return name;
  }
}
