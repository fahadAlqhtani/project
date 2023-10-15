
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

	public LinkedList<Contact> searchContactByName(String contactName) {
		LinkedList<Contact> temp = new LinkedList<Contact>();
		current = head;
		while (current != null) {
			if (((Contact) current.data).getName().equalsIgnoreCase(contactName))
				temp.insertBySorting(((Contact) current.data));
			current = current.next;
		}

		return temp;
	}

	public LinkedList<Contact> searchContactByEmail(String contactEmail) {
		LinkedList<Contact> temp = new LinkedList<Contact>();
		current = head;
		while (current != null) {
			if (((Contact) current.data).getEmail_address().equalsIgnoreCase(contactEmail))
				temp.insertBySorting(((Contact) current.data));
			current = current.next;
		}

		return temp;
	}

	public LinkedList<Contact> searchContactByAddress(String contactAddress) {
		LinkedList<Contact> temp = new LinkedList<Contact>();
		current = head;
		while (current != null) {
			if (((Contact) current.data).getEmail_address().equalsIgnoreCase(contactAddress))
				temp.insertBySorting(((Contact) current.data));
			current = current.next;
		}

		return temp;
	}

	public LinkedList<Contact> searchContactByBirthday(String contactBirthDay) {
		LinkedList<Contact> temp = new LinkedList<Contact>();
		current = head;
		while (current != null) {
			if (((Contact) current.data).getEmail_address().equalsIgnoreCase(contactBirthDay))
				temp.insertBySorting(((Contact) current.data));
			current = current.next;
		}

		return temp;
	}

	public void deleteContact(String contactName) {
		Node<T> temp;
		if (empty())
			return;

		current = head;
		temp = current;

		if (((Contact) temp.data).getName().equalsIgnoreCase(contactName)) {
			head = head.next;
			current = head;
			temp = current;
			return;
		}

		while (temp.next != null && (!((Contact) temp.data).getName().equalsIgnoreCase(contactName))) {
			current = temp;
			temp = temp.next;
		}
		
		if(((Contact)temp.data).getName().equalsIgnoreCase(contactName)) {
			current.next = temp.next;
			temp = current;
		}
		

	}

	public void print() {
		current = head;
		while (current != null) {
			System.out.println(((Contact) current.data).getName());
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
