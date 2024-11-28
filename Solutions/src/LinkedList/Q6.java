package LinkedList;

import java.util.Stack;
public class Q6 {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(0);
		Node node5 = new Node(3);
		Node node6 = new Node(2);
		Node node7 = new Node(1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		Q6 q6 = new Q6();
		System.out.println(q6.isPalindrome(node1));
	}

	public boolean isPalindrome(Node head) { 
		if (head == null) {
			return false;
		}
			Node slow_ptr = head;
			Node fast_ptr = head;
			Stack <Integer> stack= new Stack <>();
			
			while (fast_ptr !=null && fast_ptr.next != null) {
			stack.push (slow_ptr.data);
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
			}
			
			if (fast_ptr.next ==null) {
			slow_ptr = slow_ptr.next;
			}
			while (slow_ptr != null) {
			if (stack.peek() != slow_ptr.data) {
			return false;
			}
			slow_ptr = slow_ptr.next;
			stack. pop ();
			}
			return true;
		
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


