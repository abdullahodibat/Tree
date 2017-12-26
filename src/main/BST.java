package main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by abdullahodibat on 25.12.17.
 */
public class BST {
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

    public void BFS() {
        BFS(root);
    }

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

    public int maxDepth() {
        return maxDepth(root);
    }

    public int minDepth() {
        return minDepth(root);
    }

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

    public void DFS() {
        if (root != null) DFS(root);
    }

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

    public void inOrder() {
        if (root != null) inOrder(root);
    }

    private void inOrder(Node node) {
        if (node.left != null) inOrder(node.left);
        System.out.println(node.data + ",");
        if (node.right != null) inOrder(node.right);
    }

    public void preOrder() {
        if (root != null) preOrder(root);
    }

    private void preOrder(Node node) {
        System.out.println(node.data + ",");
        if (node.left != null) inOrder(node.left);
        if (node.right != null) inOrder(node.right);
    }

    public void postOrder() {
        if (root != null) postOrder(root);
    }

    private void postOrder(Node node) {
        if (node.right != null) inOrder(node.right);
        if (node.left != null) inOrder(node.left);
        System.out.println(node.data + ",");
    }

    int minValue(Node node) {
        int minv = node.data;
        while (node.left != null) {
            minv = node.left.data;
            node = node.left;
        }
        return minv;
    }

    public void delete(int value) {
        root = delete(value, root);
    }

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
