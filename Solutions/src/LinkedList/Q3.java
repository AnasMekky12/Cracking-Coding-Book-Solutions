package LinkedList;

public class Q3 {
    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println("القائمة قبل الحذف:");
        printList(node1);

        Node middleNode = findMiddleNode(node1);

        deleteNode(middleNode);

        System.out.println("القائمة بعد الحذف:");
        printList(node1);
    }

    public static Node findMiddleNode(Node head) {
        if (head == null) {
            return null; 
        }
        Node slow = head; 
        Node fast = head; 

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean deleteNode(Node n) {
        if (n == null || n.next == null) {
            return false; 
        }
        Node next = n.next;
        n.data = next.data; 
        n.next = next.next;
        return true; 
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
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
