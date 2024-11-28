package LinkedList;


public class Q4 {

	public static void main(String[] args) {

		Node node1 = new Node(3);
		Node node2 = new Node(5);
		Node node3 = new Node(8);
		Node node4 = new Node(5);
		Node node5 = new Node(10);
		Node node6 = new Node(2);
		Node node7 = new Node(1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		Q4 q4 = new Q4();
		Node node = q4.partition(node1, 5);
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public Node partition(Node node, int x) {
		Node head = node;
		Node tail = node;

		while (node != null) {
			Node next = node.next;
			if (node.data < x) {
				node.next = head;
				head = node;

			} else {
				tail.next = node;
				tail = node;

			}
			node = next;
		}
		tail.next = null;
		return head;
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