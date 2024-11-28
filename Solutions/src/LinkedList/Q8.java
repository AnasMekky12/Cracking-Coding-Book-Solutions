package LinkedList;

public class Q8 {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node3;
		Q8 q8 = new Q8();
		Node node = q8.loopDetection(node1);
		System.out.println(node.data);
	}

	public Node loopDetection(Node head) {
		Node fast_ptr = head;
		Node slow_ptr = head;
		while (fast_ptr != null && fast_ptr.next != null) {
			fast_ptr = fast_ptr.next.next;
			slow_ptr = slow_ptr.next;
			if (fast_ptr == slow_ptr) {
				break;
			}
		}

		if (fast_ptr == null || fast_ptr.next == null) {
			return null;
		}
		slow_ptr = head;
		while (slow_ptr != fast_ptr) {
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next;
		}
		return slow_ptr;
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
