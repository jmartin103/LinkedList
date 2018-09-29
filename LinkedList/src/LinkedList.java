public class LinkedList {

	// Variables
	private Node head; // First node in Linked List
	private int listCount; // Number of elements in Linked List

	// Create new empty Linked List
	public LinkedList() {
		int data = 0;
		head = new Node(data);
		listCount = 0;
	}

	// Test to see whether input is integer or not
	public boolean isInteger(Object str) {
		int data; // Integer output

		// Try to convert object to integer
		try {
			data = (int) str;
			return true; // Input is an integer
		}

		// Input is not an integer
		catch (Exception e) {
			System.out.println(str + " is not an integer!");
			return false;
		}
	}

	/*
	 * This method inserts a new element to the end of a Linked List. It takes
	 * one parameter: the element to be added.
	 */
	public void insert(Object data) {
		if (isInteger(data)) {
			Node temp = new Node(data); // The node to be added to the list
			Node curr = head; // Current node is first node in list

			// Starting from the beginning of the list, traverse to the end
			while (curr.getNext() != null) {
				curr = curr.getNext();
			}
			curr.setNext(temp); // Last node's "next" reference set to new node
			listCount++; // Increment the number of elements in the list
			System.out.println(data + " has been successfully added to the list!");
		}
	}

	/*
	 * This method inserts a new element at a specific index in the Linked List.
	 * The two parameters are the data to be added to the list, and the index of
	 * the new data to be added.
	 */
	public void insert(Object data, int index) {
		if (isInteger(data)) {
			Node temp = new Node(data); // The node to be added to the list
			Node curr = head; // Current node is first node in list

			/*
			 * Starting from the beginning of the list, crawl to either the
			 * requested index, or to the end of the list, whichever comes
			 * first.
			 */
			for (int i = 1; i < index && curr.getNext() != null; i++)
				curr = curr.getNext();
			temp.setNext(curr.getNext()); // Set new node's next reference to
											// current node's next reference
			curr.setNext(temp); // Set current node's next reference to the new
								// node
								// added to the list
			listCount++; // Increment the number of elements in the list
			System.out.println(data + " has been successfully added to the list!");
		}
	}

	/*
	 * This method returns the element at a specified index. This index is taken
	 * as the parameter.
	 */
	@SuppressWarnings("null")
	public int get(int index) {
		if (index <= 0) // Index must be 1 or higher
			return (Integer) null;
		Node curr = head.getNext();
		for (int i = 1; i < index; i++) {
			if (curr.getNext() == null)
				throw new ArrayIndexOutOfBoundsException();
			curr = curr.getNext();
		}
		return (int) curr.getData();
	}

	// Test to see whether the list contains a specific integer. Parameter is
	// integer to be found.
	public boolean contains(int data) {
		Node curr = head;
		while (curr != null) {
			if (head == null)
				return false;
			else if (curr.getData() == data) {
				System.out.println(data + " was found in the list");
				return true;
			}
			else
				curr = curr.getNext();
		}
		System.out.println(data + " was not found in the list");
		return false;
	}

	// Removes the first element (or head) in the linked list.
	public int removeFirst() {
		int tmp = (int) head.getData(); // Node that contains the integer to be
										// removed
		head = head.getNext();
		listCount--; // Decrement the number of elements in the list
		System.out.println("First element " + head.getData() + " has been removed");
		return tmp;
	}

	// Removes an element at a specified position, which is taken as the
	// parameter in this method.
	public boolean removeAtPosition(int index) {
		if (index < 1 || index > size())
			return false;
		Node curr = head;
		for (int i = 1; i < index; i++) {
			if (curr.getNext() == null)
				return false;
			curr = curr.getNext();
		}
		curr.setNext(curr.getNext().getNext());
		listCount--;
		System.out.println("Element at position " + index + " has been removed");
		return true;
	}

	// Remove a specified integer in the list. Parameter is the integer to be
	// removed.
	public boolean removeData(int data) {
		Node curr = head;
		while (curr.getNext() != null) {
			if (curr.getNext().getData() == data) {
				curr.setNext(curr.getNext().getNext());
				listCount--;
				System.out.println(data + " successfully removed from list!");
				return true;
			}
			curr = curr.getNext();
		}
		return false;
	}

	// Returns number of elements in the list. Should be pretty
	// self-explanatory.
	public int size() {
		return listCount;
	}

	// Returns true if list is empty. This should also be self-explanatory.
	public boolean isEmpty() {
		return listCount == 0;
	}

	// Traverse through the linked list, and display all elements in the list
	public String traverse() {
		Node curr = head.getNext();
		String output = "";
		while (curr != null) {
			output += "[" + curr.getData() + "]";
			curr = curr.getNext();
		}
		return output;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList(); // Our LinkedList to be initialized

		list.insert(10); // Insert element 10 at end of list
		System.out.println("List: " + list.traverse());
		System.out.println("Current size: " + list.size()); // Print current size
		System.out.println(list.isEmpty());
		list.removeFirst(); // Remove first node in list
		System.out.println("List: " + list.traverse());
		System.out.println("Current size: " + list.size());
		System.out.println(list.isEmpty());
		list.insert(25); // Insert element 25 at end of list
		System.out.println("List: " + list.traverse());
		list.insert(30); // Insert element 30 at end of list
		System.out.println("List: " + list.traverse());
		list.insert(35); // Insert element 35 at end of list
		System.out.println("List: " + list.traverse());
		System.out.println(list.contains(35));
		System.out.println(list.contains(16));
		list.insert(5.0); // Try to insert 5.0 in list
		list.insert(27, 3); // Insert the element 27 at position 3
		System.out.println("List: " + list.traverse());
		list.insert("Bob"); // Try to insert "Bob" in list
		System.out.println("The element at position 2 is " + list.get(2));
		System.out.println("The element at position 4 is " + list.get(4));
		System.out.println("Current size: " + list.size());
		list.removeFirst();
		System.out.println("List: " + list.traverse());
		System.out.println("Current size: " + list.size());
		list.removeAtPosition(2); // Remove element at position 2
		System.out.println("List: " + list.traverse());
		System.out.println("Current size: " + list.size());
		list.removeData(35); // Remove the integer 35
		System.out.println("List: " + list.traverse());
		System.out.println("Current size: " + list.size());
	}

}
