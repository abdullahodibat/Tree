package main;

/**
 * Created by abdullahodibat.
 */
public class CirculraLinkedList {

    public static void main(String[] args) {
        CirculraLinkedList cll = new CirculraLinkedList();
        cll.addNodeToStart("5");
        cll.addNodeToEnd("10");
        cll.addNodeToStart("4");
        cll.addNodeToStart("3");
        cll.addNodeToStart("2");
        cll.addNodeToStart("1");
        cll.deleteNodeFromStart();
        cll.deleteNodeFromEnd();
        cll.deleteNode("4");
        cll.print();
    }

    public Node head;
    public Node tail;
    public int size;

    private class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            next = null;
        }
    }

    public CirculraLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addNodeToStart(String data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
    }

    public void addNodeToEnd(String data) {
        if (size == 0) {
            addNodeToStart(data);
        } else {
            Node newNode = new Node(data);
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
            size++;
        }
    }

    public void deleteNodeFromStart() {
        if (size <= 0) {
            System.out.println("linked list is empty");
        } else if (size == 1) {
            head = null;
            tail = null;
            size = 0;
        } else {
            head = head.next;
            tail.next = head;
            size--;
        }
    }

    public void deleteNodeFromEnd() {
        if (size <= 0) {
            System.out.println("linked list is empty");
        }
        if (size == 1) {
            head = null;
            tail = null;
            size--;
        } else {
            Node previousNode = head;
            Node tmp = head.next;
            while (tmp != tail) {
                previousNode = previousNode.next;
                tmp = tmp.next;
            }
            tail = previousNode;
            previousNode.next = head;
        }
    }

    public void deleteNode(String data) {
        if (size <= 0) {
            System.out.println("linked list is empty");
        }
        if (head.data == data) {
            deleteNodeFromStart();
        } else {
            Node previousNode = head;
            Node tmp = head.next;
            while (tmp != head && tmp.data != data) {
                previousNode = previousNode.next;
                tmp = tmp.next;
            }
            if (tmp.data == data) {
                if (tmp != tail) {
                    previousNode.next = tmp.next;
                    size--;
                } else {
                    previousNode.next = tmp.next;
                    tail = previousNode;
                    size--;
                }
            }
        }
    }

    public String elementAt(int index) {
        if (index > size) {
            return null;
        }
        Node n = head;
        while (index - 1 != 0) {
            n = n.next;
            index--;
        }
        return n.data;
    }

    public void print() {
        Node tmp = head;
        if (size <= 0) {
            System.out.println("List is empty");
        } else {
            System.out.println(tmp.data + ",");
            tmp = tmp.next;
            while (tmp != head) {
                System.out.println(tmp.data + ",");
                tmp = tmp.next;
            }
        }
    }

    public int getSize() {
        return size;
    }

}
