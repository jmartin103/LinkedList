
public class Node {

	public Object data;
	public Node next;
	
	public Node() {
		data = 0;
		next = null;
	}
	
	public Node(Object data) {
		this.data = data;
		this.next = null;
	}
	
	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public Node getNext() {
		return next;
	}
	
	public int getData() {
		return (int) data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public void setData(int data) {
		this.data = data;
	}
}
