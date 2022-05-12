package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphImpl implements Graph {
  Map<String, List<Edge>> edges;
  Map<String, Node> nodes;
  List<String> keys = new ArrayList<>();
  Map<String, Double> djk;

  public GraphImpl() {
    nodes = new HashMap<>();
    edges = new HashMap<>();
    djk = new HashMap<>();
  }

  @Override
  public boolean addNode(String name) {
    Node nd = new NodeImpl(name);
    keys.add(name);
    return nodes.put(name, nd) == null;
  }

  @Override
  public boolean addEdge(String src, String dest, double weight) {
    if (!nodes.containsKey(src) || !nodes.containsKey(dest) || weight < 0) {
      return false;
    }
    if (edges.containsKey(src)) {
      List<Edge> v = edges.get(src);
      for (Edge edge : v) {
        if (edge.getName().equals(dest)) {
          return false;
        }
      }
      v.add(new EdgeImpl(dest, weight));
    } else {
      List<Edge> v = new ArrayList<>();
      v.add(new EdgeImpl(dest, weight));
      edges.put(src, v);
    }
    if (edges.containsKey(dest)) {
      List<Edge> v = edges.get(dest);
      for (Edge edge : v) {
        if (edge.getName().equals(src)) {
          return false;
        }
      }
      v.add(new EdgeImpl(src, weight));
    } else {
      List<Edge> v = new ArrayList<>();
      v.add(new EdgeImpl(src, weight));
      edges.put(dest, v);
    }
    return true;
  }

  @Override
  public boolean deleteNode(String name) {
    if (nodes.remove(name) != null) {
      keys.remove(name);
      edges.remove(name);
      for (String key : keys) {
        deleteEdge(key, name);
      }
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean deleteEdge(String src, String dest) {
    if (!edges.containsKey(src)) {
      return false;
    }
    List<Edge> v = edges.get(src);
    Edge e;
    boolean bool = false;
    for (int i = 0; i < v.size(); i++) {
      e = v.get(i);
      if (e.getName().equals(dest)) {
        v.remove(e);
        bool = true;
      }
    }
    return bool;
  }

  @Override
  public int numNodes() {
    return nodes.size();
  }

  @Override
  public int numEdges() {
    List<Edge> v;
    int num_edges = 0;
    for (int i = 0; i < nodes.size(); i++) {
      v = edges.get(keys.get(i));
      if (v != null) {
        num_edges += v.size();
      }
    }
    num_edges /= 2;
    return num_edges;
  }

  @Override
  public Map<String, Double> dijkstra(String start) {
    for (int i = 0; i < nodes.size(); i++) {
      djk.put(keys.get(i), Double.POSITIVE_INFINITY);
    }

    List<String> visited = new ArrayList<>();
    List<String> unvisited = new ArrayList<>();

    for (int i = 0; i < nodes.size(); i++) {
      unvisited.add(keys.get(i));
    }

    djk.put(start, 0.0);
    while (unvisited.size() > 0) {
      String shortest = null;
      double shortest_path = Double.POSITIVE_INFINITY;
      //finds the next node to visit
      for (String s : unvisited) {
        if (djk.get(s) <= shortest_path) {
          shortest = s;
          shortest_path = djk.get(s);
        }
      }
      if (edges.get(shortest) == null) {
        break;
      } else {
        for (int j = 0; j < edges.get(shortest).size(); j++) {
          if (edges.get(shortest).get(j).getDist() + djk.get(shortest)
              < djk.get(edges.get(shortest).get(j).getName())) {
            djk.put(
                edges.get(shortest).get(j).getName(),
                edges.get(shortest).get(j).getDist() + djk.get(shortest));
          }
        }
      }
      visited.add(shortest);
      unvisited.remove(shortest);
    }
    int n = djk.size();
    for (int i = 0; i < n; i++) {
      if (djk.get(keys.get(i)).isInfinite()) {
        djk.remove(keys.get(i));
      }
    }
    return djk;
  }
}
