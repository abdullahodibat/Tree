package main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by abdullahodibat.
 * Binary Search Tree
 */
public class BST {

    public static void main (String[] args){
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
    }

    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public BST() {
        root = null;
    }

    /**
     * insert new item into binary tree
     *
     * @param value
     */
    public void insert(int value) {
        if (root == null)
            root = new Node(value);
        else insert(value, root);
    }

    private void insert(int value, Node node) {
        if (value <= node.data) {
            if (node.left == null) {
                Node newNode = new Node(value);
                node.left = newNode;
            } else {
                insert(value, node.left);
            }
        } else {
            if (node.right == null) {
                Node newNode = new Node(value);
                node.right = newNode;
            } else {
                insert(value, node.right);
            }
        }
    }

    /**
     * check if the tree contains a value
     *
     * @param value
     * @return boolean
     */
    public boolean contains(int value) {
        if (root == null) return false;
        else return contains(value, root);
    }

    private boolean contains(int value, Node node) {
        if (node.data == value) return true;
        else if (value < node.data) {
            if (node.left == null) return false;
            else return contains(value, node.left);
        } else {
            if (node.right == null) return false;
            else return contains(value, node.right);
        }
    }

    /**
     * Breadth First Travers
     */
    public void BFS() {
        BFS(root);
    }

    /**
     * Breadth First Traverse
     *
     * @param node starting node
     */
    public void BFS(Node node) {
        Queue<Node> q = new LinkedList<>();
        if (node == null)
            return;
        q.add(node);
        while (!q.isEmpty()) {
            Node n = q.remove();
            System.out.print(" " + n.data);
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
        }
    }

    /**
     * Return maxDepth of a tree
     *
     * @return
     */
    public int maxDepth() {
        return maxDepth(root);
    }

    /**
     * Return minimum dpth of the tree
     *
     * @return
     */
    public int minDepth() {
        return minDepth(root);
    }

    /**
     * Return minimum dpth of the tree
     *
     * @param node
     * @return
     */
    int minDepth(Node node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 1;

        if (node.left == null)
            return minDepth(node.right) + 1;

        if (node.right == null)
            return minDepth(node.left) + 1;

        return Math.min(minDepth(node.left),
                minDepth(node.right)) + 1;
    }

    /**
     * Return maxDepth of a tree
     *
     * @param node
     * @return
     */
    int maxDepth(Node node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 1;

        if (node.left == null)
            return maxDepth(node.right) + 1;

        if (node.right == null)
            return maxDepth(node.left) + 1;

        return Math.max(maxDepth(node.left),
                maxDepth(node.right)) + 1;
    }

    /**
     * Depth First Travers
     */
    public void DFS() {
        if (root != null) DFS(root);
    }

    /**
     * Depth First Travers (using stack)
     *
     * @param root
     */
    private void DFS(Node root) {
        Stack<Node> s = new Stack<>();
        Node node = root;
        while (node != null) {
            s.push(node);
            node = node.left;
        }

        while (s.isEmpty() == false) {
            Node x = s.pop();
            System.out.print(" " + x.data);

            if (x.right != null) {
                Node innerNode = x.right;
                while (innerNode != null) {
                    s.push(innerNode);
                    innerNode = innerNode.left;
                }
            }
        }
    }

    /**
     * In-Order Depth First Travers(recursive)
     */
    public void inOrder() {
        if (root != null) inOrder(root);
    }

    /**
     * In-Order Depth First Travers(recursive)
     *
     * @param node starting node
     */
    private void inOrder(Node node) {
        if (node.left != null) inOrder(node.left);
        System.out.println(node.data + ",");
        if (node.right != null) inOrder(node.right);
    }

    /**
     * Pre-Order Depth First Travers(recursive)
     */
    public void preOrder() {
        if (root != null) preOrder(root);
    }

    /**
     * Pre-order DFS(recursive)
     *
     * @param node starting node
     */
    private void preOrder(Node node) {
        System.out.println(node.data + ",");
        if (node.left != null) inOrder(node.left);
        if (node.right != null) inOrder(node.right);
    }

    /**
     * Pots-Order Traverse(recursive)
     */
    public void postOrder() {
        if (root != null) postOrder(root);
    }

    /**
     * Post-Order Travers(recursive)
     *
     * @param node starting node
     */
    private void postOrder(Node node) {
        if (node.right != null) inOrder(node.right);
        if (node.left != null) inOrder(node.left);
        System.out.println(node.data + ",");
    }

    /**
     * Minimum value in a tree
     *
     * @param node
     * @return
     */
    int minValue(Node node) {
        int minv = node.data;
        while (node.left != null) {
            minv = node.left.data;
            node = node.left;
        }
        return minv;
    }

    /**
     * delete node from tree
     *
     * @param value
     */
    public void delete(int value) {
        root = delete(value, root);
    }

    /**
     * Delete node from tree
     *
     * @param value value to be deleted
     * @param node  starting node
     * @return
     */
    private Node delete(int value, Node node) {
        if (node == null) return node;
        else {
            if (value < node.data)
                node.left = delete(value, node.left);
            else if (value > node.data)
                node.right = delete(value, node.right);
            else {
                if (node.left == null)
                    return node.right;
                else if (node.right == null)
                    return node.left;
                else {
                    node.data = minValue(node.right);
                    node.right = delete(value, node.right);
                }
            }
        }
        return node;
    }
}
