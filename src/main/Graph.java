package main;

import java.util.*;

/**
 * Created by abdullahodibat on 26.12.17.
 */
public class Graph {
    static HashMap<Integer, Node> nodes = new HashMap<>();

    public static class Node {
        int id;
        Queue<Node> adjacents = new LinkedList<>();

        Node(int id) {
            this.id = id;
            nodes.put(id, this);
        }
    }

    public Node getNode(int id) {
        return nodes.get(id);
    }

    public void addEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacents.add(d);
    }

    public boolean hasPathDFS(int source, int destincation) {
        Node s = getNode(source);
        Node d = getNode(destincation);
        Set<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    public boolean hasPathDFSStack(int source, int destincation) {
        Node s = getNode(source);
        Node d = getNode(destincation);
        Set<Integer> visited = new HashSet<>();
        return hasPathDFSStack(s, d, visited);
    }

    public boolean hasPathBFS(int source, int destincation) {
        Node s = getNode(source);
        Node d = getNode(destincation);
        Set<Integer> visited = new HashSet<>();
        return hasPathBFS(s, d, visited);
    }


    public boolean hasPathDFS(Node source, Node destincation, Set<Integer> visited) {
        if (visited.contains(source.id)) return false;
        visited.add(source.id);
        if (source.id == destincation.id) return true;
        for (Node n : source.adjacents) {
            if (hasPathDFS(n, destincation, visited)) return true;
        }

        return false;

    }


    public boolean hasPathBFS(Node source, Node destincation, Set<Integer> visited) {
        Queue<Node> nodes = new LinkedList<>();
        if (!visited.contains(source.id)) {
            nodes.add(source);
            while (!nodes.isEmpty()) {
                Node node = nodes.remove();
                if (node.id == destincation.id) return true;
                visited.add(node.id);
                for (Node n : node.adjacents) {
                    nodes.add(n);
                }
            }

        }
        return false;
    }


    public boolean hasPathDFSStack(Node source, Node destincation, Set<Integer> visited) {
        Stack<Node> nodes = new Stack<>();
        if (!visited.contains(source.id)) {
            nodes.push(source);
            while (!nodes.isEmpty()) {
                Node node = nodes.pop();
                if (node.id == destincation.id) return true;
                visited.add(node.id);
                for (Node n : node.adjacents) {
                    nodes.push(n);
                }
            }

        }
        return false;
    }

}
