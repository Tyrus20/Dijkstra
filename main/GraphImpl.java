package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class GraphImpl implements Graph {
    Map<String, Vector<Edge>> edges;
    Map<String, Node> nodes;
    Vector<String> keys = new Vector<>();
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
        if(!nodes.containsKey(src) || !nodes.containsKey(dest) || weight < 0) {return false;}

        if(edges.containsKey(src)) {
            Vector<Edge> v = edges.get(src);
            for (Edge edge : v) {
                if (edge.getName().equals(dest)) {
                    return false;
                }
            }
            v.add(new EdgeImpl(dest, weight));
        }
        else {
            Vector<Edge> v = new Vector<>();
            v.add(new EdgeImpl(dest, weight));
            edges.put(src, v);
        }
        return true;
    }

    @Override
    public boolean deleteNode(String name) {
        if(nodes.remove(name) != null) {
            keys.remove(name);
            edges.remove(name);
            for (String key : keys) {
                deleteEdge(key, name);
            }
            return true;
        }
        else {return false;}
    }

    @Override
    public boolean deleteEdge(String src, String dest) {
        if(!edges.containsKey(src)) {return false;}
        Vector<Edge> v = edges.get(src);
        Edge e;
        boolean bool = false;
        for(int i = 0; i < v.size(); i++) {
            e = v.get(i);
            if(e.getName().equals(dest)) {
                v.remove(e);
                bool = true;
            }
        }
        return bool;
    }

    @Override
    public int numNodes() {return nodes.size();}

    @Override
    public int numEdges() {
        Vector<Edge> v;
        int num_edges = 0;
        for(int i = 0; i < edges.size(); i++) {
            v = edges.get(keys.get(i));
            if(v != null) {
                num_edges += v.size();
            }
        }
        return num_edges;
    }

    @Override
    public Map<String, Double> dijkstra(String start) {
        for(int i = 0; i < nodes.size(); i++) {
            djk.put(keys.elementAt(i), Double.POSITIVE_INFINITY);
        }

        Vector<String> visited = new Vector<>();
        Vector<String> unvisited = new Vector<>();

        for(int i = 0; i < nodes.size(); i++) {unvisited.add(keys.elementAt(i));}

        djk.put(start, 0.0);
        while(unvisited.size() > 0) {
            String shortest = null;
            double shortest_path = Double.POSITIVE_INFINITY;
            for (String s : unvisited) {
                if (djk.get(s) <= shortest_path) {
                    shortest = s;
                    shortest_path = djk.get(s);
                }
            }
            if(edges.get(shortest) == null) {break;}
            else {
                for (int j = 0; j < edges.get(shortest).size(); j++) {
                    if (edges.get(shortest).elementAt(j).getDist() + djk.get(shortest) < djk.get(edges.get(shortest).elementAt(j).getName())) {
                        djk.put(edges.get(shortest).elementAt(j).getName(), edges.get(shortest).elementAt(j).getDist() + djk.get(shortest));
                    }
                }
            }
            visited.add(shortest);
            unvisited.remove(shortest);
        }
        int n = djk.size();
        for(int i = 0; i < n; i++) {
            if(djk.get(keys.elementAt(i)).isInfinite()) {
                djk.remove(keys.elementAt(i));
            }
        }
        return djk;
    }
}