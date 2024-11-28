package LinkedList;

import java.util.HashSet;

public class Q1 {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(2);
		Node node4 = new Node(3);
		Node node5 = new Node(3);
		Node node6 = new Node(3);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		Q1 ql = new Q1();

		ql.AnasDups(node1);

		while (node1 != null) {
			System.out.print(node1.data + " ");
			node1 = node1.next;
		}
	}

	public void AnasDups(Node node) {
		HashSet<Integer> hs = new HashSet<>();
		Node previous = null;

		while (node != null) {
			if (!hs.contains(node.data)) {
				hs.add(node.data);
				previous = node;
			} else {

				previous.next = node.next;
			}
			node = node.next;
		}
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
