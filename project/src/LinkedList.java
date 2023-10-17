
public class LinkedList<T> {
	private Node<T> head;
	private Node<T> current;

	public LinkedList() {
		head = current = null;
	}

	public boolean empty() {
		return head == null;

	}

	public boolean last() {
		return current.next == null;
	}

	public boolean full() {
		return false;
	}

	public void findFirst() {
		current = head;
	}

	public void findNext() {
		current = current.next;
	}

	public T retrieve() {
		return current.data;
	}

	public void update(T val) {
		current.data = val;
	}

	public boolean insertBySorting(T data) {
		Node<T> temp;
		if (empty()) {
			head = current = new Node<T>(data);
			temp = current;
			return true;
		}

		else {
			current = head;
			temp = current;

			while (temp.next != null && ((Comparable<T>) data).compareTo((T) ((Comparable<T>) temp.data)) > 0) {
				current = temp;
				temp = temp.next;
			}

			if (((Comparable<T>) data).compareTo((T) ((Comparable<T>) temp.data)) < 0) {

				if (head == temp) {

					Node<T> newNode = new Node<T>(data);
					newNode.next = temp;
					head = newNode;
					current = head;
					return true;
				}

				Node<T> newNode = new Node<T>(data);
				current.next = newNode;
				newNode.next = temp;
				current = newNode;
				return true;
			} else if (((Comparable<T>) data).compareTo((T) ((Comparable<T>) temp.data)) == 0)
				return false;
			else {

				Node<T> newNode = new Node<T>(data);
				temp.next = newNode;
				current = newNode;
				return true;
			}

		}
	}

	
	public void print() {
		current = head;
		while (current != null) {
			((Contact) current.data).tostring();;
			current = current.next;

		}
	}	


	public void remove() {
		if (current == head) {
			head = head.next;
		} else {
			Node<T> tmp = head;

			while (tmp.next != current)
				tmp = tmp.next;

			tmp.next = current.next;
		}

		if (current.next == null)
			current = head;
		else
			current = current.next;
	}
}
