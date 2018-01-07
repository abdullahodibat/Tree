package main;


/**
 * Created by abdullahodibat.
 */
public class Trie {
    public Trie() {
        root = new Node();
    }

    static final int AlphabetSize = 26;

    private static class Node {

        Node[] children = new Node[AlphabetSize];
        boolean isWordEnded;

        public Node() {
            isWordEnded = false;
            for (int i = 0; i < AlphabetSize; i++) {
                children[i] = null;
            }
        }
    }

    static Node root;

    void insert(String word) {
        int index;

        Node node = root;

        for (int location = 0; location < word.length(); location++) {
            index = word.charAt(location) - 'a';
            if (node.children[index] == null)
                node.children[index] = new Node();

            node = node.children[index];
        }
        node.isWordEnded = true;
    }

    boolean isPrefix(String prefix) {
        int index;
        Node node = root;

        for (int location = 0; location < prefix.length(); location++) {
            index = prefix.charAt(location) - 'a';

            if (node.children[index] == null)
                return false;

            node = node.children[index];
        }

        return true;
    }

    public int prefixCount(String prefix) {
        int index;
        Node node = root;

        for (int location = 0; location < prefix.length(); location++) {
            index = prefix.charAt(location) - 'a';

            if (node.children[index] == null)
                return 0;

            node = node.children[index];
        }

        return wordCount(node);
    }

    public int wordCount(Node node) {
        int result = 0;

        if (node.isWordEnded)
            result++;

        for (int i = 0; i < AlphabetSize; i++)
            if (node.children[i] != null)
                result += wordCount(node.children[i]);

        return result;
    }

    boolean search(String word) {
        int index;
        Node node = root;

        for (int location = 0; location < word.length(); location++) {
            index = word.charAt(location) - 'a';

            if (node.children[index] == null)
                return false;

            node = node.children[index];
        }

        return (node.isWordEnded);
    }
}
