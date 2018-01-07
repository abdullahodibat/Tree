package main;

/**
 * Created by abdullahodibat on 25.12.17.
 */
public class Application {
    public static void main(String[] args) {

        /**
         * Binary Search Tree
         */
        BST bst = new BST();

        bst.insert(20);
        bst.insert(24);
        bst.insert(4);
        bst.insert(9);
        bst.insert(33);
        bst.insert(3);
        bst.insert(1);

        bst.inOrder();
        bst.preOrder();
        bst.postOrder();
        bst.BFS();
        bst.DFS();

        /**
         * Min-Heap
         */

        Heap heap = new Heap();
        heap.insert(4);
        heap.insert(7);
        heap.insert(9);
        heap.insert(2);

        heap.poll();
        heap.insert(5);

        for (int i = 0; i < heap.size; i++) {
            System.out.println(heap.arr[i]);
        }

        /**
         * Graph
         */

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

        /**
         * Trie
         */

        Trie trie = new Trie();
        trie.insert("berlin");
        trie.insert("berl");
        trie.insert("germany");
        System.out.println(trie.search("berlin"));
        System.out.println(trie.search("berl"));
        System.out.println(trie.search("munich"));
        System.out.println(trie.isPrefix("ber"));
        System.out.println(trie.wordCount(Trie.root));
        System.out.println(trie.prefixCount("ber"));
        System.out.println(trie.prefixCount("xdr"));
    }
}
