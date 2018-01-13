package main;

import java.util.*;

/**
 * Created by abdullahodibat.
 */
public class Graph {
    public static void main (String[] args){

        Graph graph = new Graph();
        Graph.Node node = new Graph.Node(4);
        Graph.Node node2 = new Graph.Node(6);
        Graph.Node node3 = new Graph.Node(8);
        Graph.Node node4 = new Graph.Node(9);
        Graph.Node node5 = new Graph.Node(1);
        graph.addEdge(4, 6);
        graph.addEdge(6, 8);
        graph.addEdge(8, 9);
        graph.addEdge(9, 1);

        System.out.println(graph.hasPathDFS(8, 1));
        System.out.println(graph.hasPathBFS(8, 1));
        System.out.println(graph.hasPathDFSStack(8, 1));

    }
    static HashMap<Integer, Node> nodes = new HashMap<>();

    public static class Node {
        int id;
        Queue<Node> adjacents = new LinkedList<>();

        Node(int id) {
            this.id = id;
            nodes.put(id, this);
        }
    }

    /**
     * Get Node by id
     *
     * @param id
     * @return
     */
    public Node getNode(int id) {
        return nodes.get(id);
    }

    /**
     * add edge between two nodes
     *
     * @param source
     * @param destination
     */
    public void addEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacents.add(d);
    }

    /**
     * check if there is a path between two nodes using DFS(recursive)
     *
     * @param source
     * @param destincation
     * @return
     */
    public boolean hasPathDFS(int source, int destincation) {
        Node s = getNode(source);
        Node d = getNode(destincation);
        Set<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    /**
     * check if there is a path between two nodes using DFS(stack)
     *
     * @param source
     * @param destincation
     * @return
     */
    public boolean hasPathDFSStack(int source, int destincation) {
        Node s = getNode(source);
        Node d = getNode(destincation);
        Set<Integer> visited = new HashSet<>();
        return hasPathDFSStack(s, d, visited);
    }

    /**
     * check if there is a path between two nodes using BFS
     *
     * @param source
     * @param destincation
     * @return
     */
    public boolean hasPathBFS(int source, int destincation) {
        Node s = getNode(source);
        Node d = getNode(destincation);
        Set<Integer> visited = new HashSet<>();
        return hasPathBFS(s, d, visited);
    }


    /**
     * check if there is a path between two nodes using DFS(recursive)
     *
     * @param source
     * @param destincation
     * @return
     */
    public boolean hasPathDFS(Node source, Node destincation, Set<Integer> visited) {
        if (visited.contains(source.id)) return false;
        visited.add(source.id);
        if (source.id == destincation.id) return true;
        for (Node n : source.adjacents) {
            if (hasPathDFS(n, destincation, visited)) return true;
        }

        return false;

    }

    /**
     * check if there is a path between two nodes using BFS
     *
     * @param source
     * @param destincation
     * @return
     */
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

    /**
     * check if there is a path between two nodes using DFS(stack)
     *
     * @param source
     * @param destincation
     * @return
     */
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
