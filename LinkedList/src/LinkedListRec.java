public class LinkedListRec {

	// Variables
	private Node head; // First node in Linked List

	// Create new empty Linked List
	public LinkedListRec() {
		head = null;
	}

	/*
	 * This method inserts a new element to the end of a Linked List. It takes
	 * one parameter: the element to be added.
	 */
	public void insert(int data) {
		Node temp = new Node(data); // The node to be added to the list
		Node curr = head; // Current node is first node in list

		if (head == null) {
			head = new Node(temp);
			System.out.println(data
					+ " has been successfully added to the list!");
		} 
		else {
			// Starting from the beginning of the list, traverse to the end
			while (curr.getNext() != null) {
				curr = curr.getNext();
			}
			curr.setNext(temp); // Last node's "next" reference set to new node
			System.out.println(data
					+ " has been successfully added to the list!");
		}
	}

	public int size(Node head) {
		Node temp = head;
		if (temp == null)
			return 0;
		else
			return 1 + size(head.next);
	}

	public int size() {
		return size(head);
	}

	public static void main(String[] args) {
		LinkedListRec list = new LinkedListRec();

		list.insert(32);
		list.insert(54);
		list.insert(43);
		list.insert(19);
		list.insert(30);
		list.insert(65);
		list.insert(27);
		System.out.println("Current size: " + list.size());
	}

}
