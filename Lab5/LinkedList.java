import java.lang.System;

public class LinkedList {
	Node head;

	LinkedList() {
		head = null;
	}

	LinkedList(int[] original) {
		this();
		for(int x : original) {
			add(x);
		}
	}

	Node head() {
		return head;
	}

	LinkedList add(Integer x) {
		if(head == null) {
			head = new Node(x);
			return this;
		}
		Node curr = head;
		while(curr.hasNext()) {
			curr = curr.next;
		}
		curr.next = new Node(x);
		return this;
	}

	LinkedList remove() {
		if(head.hasNext()) {
			head = head.next;
		}
		else head = null;
		return this;
	}

	LinkedList merge(LinkedList other) {
		Node curr = head;
		while(curr.hasNext()) {
			curr = curr.next;
		}
		curr.next = other.head();
		return this;
	}

	LinkedList clear() {
		head = null;
		return this;
	}

	Boolean contains(Integer x) {
		if(head.val() == x) {return true;}
		Node curr = head;
		while(curr.hasNext()) {
			curr = curr.next;
			if(head.val() == x) {return true;}
		}
		return false;
	}

	void display() {
		Node curr = head;
		if(curr == null) { System.out.println(); return; }
		System.out.print(curr.val() + "\t");
		while(curr.hasNext()) {
			curr = curr.next;
			System.out.print(curr.val() + "\t");
		}
		System.out.println();
	}
}