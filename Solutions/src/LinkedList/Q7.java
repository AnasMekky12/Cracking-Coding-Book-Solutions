package LinkedList;


public class Q7 {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node8.next = node8;
		node9.next = node9;
		node10.next = node10;
		Q7 q7 = new Q7();
		Node intersector = q7.intersection(node1, node5);
		System.out.println("The intersecting node: " + intersector.data);
	}

	public Node intersection(Node head1, Node head2) {
		Node ptr1 = head1;
		Node ptr2 = head2;
		while (ptr1 != ptr2) {
			if (ptr1 == null) {
				ptr1 = head2;
			}
			if (ptr2 == null) {
				ptr2 = head1;
			}
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		return ptr1;

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
