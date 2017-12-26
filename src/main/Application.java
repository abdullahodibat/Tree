package main;

/**
 * Created by abdullahodibat on 25.12.17.
 */
public class Application {
    public static void main(String[] args) {

        BST bst = new BST();

        bst.insert(20);
        bst.insert(24);
        bst.insert(4);
        bst.insert(9);
        bst.insert(33);
        bst.insert(3);
        bst.insert(1);

        bst.inOrder();

        System.out.println(bst.maxDepth());
        System.out.println(bst.minDepth());

///////////////////Heap

        Heap heap = new Heap();
        heap.insert(4);
        heap.insert(7);
        heap.insert(9);
        heap.insert(2);
        for (int a : heap.arr) {
            // System.out.println(a);
        }
        heap.poll();
        heap.insert(5);

        for (int a : heap.arr) {
            System.out.println(a);
        }

//////////////// graph

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
}
