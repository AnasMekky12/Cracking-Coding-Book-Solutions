package LinkedList;

public class Q2 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Q2 q2 = new Q2();

        int k = 2; 
        Node resultNode = q2.kthToLast(node1, k);

        if (resultNode != null) {
            System.out.println("The value of the " + k + "th last node is: " + resultNode.data);
        } else {
            System.out.println("The list is too short to find the " + k + "th last node.");
        }
    }

    public Node kthToLast(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null; 
            }
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2; 
    }

    public static class Node {
        public int data; 
        public Node next; 

        public Node(int data) {
            this.data = data; 
            this.next = null;
        }
    }
}
