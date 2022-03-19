

public class Node {
	Integer val;
	Node next;

	Node(Integer x) {
		val = x;
		next = null;
	}

	Integer val() { 
		return val;
	}

	Boolean hasNext() {
		return next != null;
	}
}