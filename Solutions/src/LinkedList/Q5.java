package LinkedList;


public class Q5 {

	public static void main(String[] args) {
		Node list1_1 = new Node(7);
		Node list1_2 = new Node(1);
		Node list1_3 = new Node(6);
		list1_1.next = list1_2;
		list1_2.next = list1_3;		
		Node list2_1 = new Node(5);
		Node list2_2 = new Node(9);
		Node list2_3 = new Node(2);
		Node list2_4 = new Node(1);
		list2_1.next = list2_2;
		list2_2.next = list2_3;
		list2_3.next = list2_4;
		Q5 q5 = new Q5();
		Node node = q5.sumLists(list1_1, list2_1);
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public Node sumLists(Node list1, Node list2) {
		int result = 0;
		int carry = 0;
		Node output_head = null;
		Node output_ptr = null;
		while (list1 != null || list2 != null || carry !=0) {
		if (list1 != null) {
		result += list1.data;
		list1 = list1.next;
		}
		if (list2 != null) {
		result += list2.data;
		list2 = list2.next;
		}
		result+=carry;
		carry=result/10;

	Node new_node = new Node(result % 10);
	if(output_head == null) {
		output_head = new_node;
		output_ptr = output_head;
}
	else {
		output_ptr.next = new_node;
		output_ptr = new_node;
	}
	result = 0;
}
return output_head;


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
