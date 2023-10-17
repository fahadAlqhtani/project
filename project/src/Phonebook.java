
public class Phonebook {
	private LinkedList<Contact> phonebook;//this varible reprsent contacts
	private LinkedList<Event> evn;//this varible reprsent events

	public Phonebook() {
		phonebook = new LinkedList<Contact>();
		evn = new LinkedList<Event>();
	}

	public boolean addcontact(Contact c) {
		if (phonebook.empty()) {
			phonebook.insertBySorting(c);
			return true;
		}
		phonebook.findFirst();
		while (!phonebook.last()) {
			if (phonebook.retrieve().getFname().equalsIgnoreCase(c.getFname())&& phonebook.retrieve().getLname().equalsIgnoreCase(c.getLname())|| phonebook.retrieve().getPhone_number().equalsIgnoreCase(c.getPhone_number()))
				return false;
			phonebook.findNext();
		}
		if (phonebook.retrieve().getFname().equalsIgnoreCase(c.getFname())&& phonebook.retrieve().getLname().equalsIgnoreCase(c.getLname())|| phonebook.retrieve().getPhone_number().equalsIgnoreCase(c.getPhone_number()))
			return false;

		phonebook.insertBySorting(c);
		return true;

	}// this method will add contact if not found in list (unique)

	public boolean deletcontact(String fname, String lname) {
		if (phonebook.empty())
			return false;
		phonebook.findFirst();
		while (!phonebook.last()) {
			if (phonebook.retrieve().getFname().equalsIgnoreCase(fname)&& phonebook.retrieve().getLname().equalsIgnoreCase(lname)) {
				phonebook.remove();
				deletEvent(phonebook.retrieve().getFname(), phonebook.retrieve().getLname());
				return true;
			}
			phonebook.findNext();
		}
		if (phonebook.retrieve().getFname().equalsIgnoreCase(fname)
				&& phonebook.retrieve().getLname().equalsIgnoreCase(lname)) {
			phonebook.remove();
			deletEvent(phonebook.retrieve().getFname(), phonebook.retrieve().getLname());
			return true;
		}
		return false;

	}//this method will delete contact by name and delete the event who have

	public LinkedList<Contact> searchContact(String n) {// n varible reprsent  address or email or .......
		LinkedList<Contact> temp = new LinkedList<Contact>();
		if (phonebook.empty())
			return null;
		phonebook.findFirst();
		while (!phonebook.last()) {
			if ( phonebook.retrieve().getBirthday().equalsIgnoreCase(n)|| phonebook.retrieve().getAddress().equalsIgnoreCase(n)|| phonebook.retrieve().getEmail_address().equalsIgnoreCase(n))
				temp.insertBySorting(phonebook.retrieve());
			phonebook.findNext();
		}
		return temp;

	}
	public Contact searchByNameORNumber(String n) {// n reprsent name or number
		if (phonebook.empty())
			return null;
		phonebook.findFirst();
		while (!phonebook.last()) {
			if ( (phonebook.retrieve().getFname()+" "+phonebook.retrieve().getLname()).equalsIgnoreCase(n)|| phonebook.retrieve().getPhone_number().equalsIgnoreCase(n))
				return phonebook.retrieve();
			phonebook.findNext();
		}if ( (phonebook.retrieve().getFname()+" "+phonebook.retrieve().getLname()).equalsIgnoreCase(n)|| phonebook.retrieve().getPhone_number().equalsIgnoreCase(n))
			return phonebook.retrieve();
		return null;
		
	}

	private void deletEvent(String fname, String lname) {
		if (evn.empty())
			return;
		evn.findFirst();
		while (!evn.last()) {
			if (evn.retrieve().getContact().getFname().equalsIgnoreCase(fname)&& evn.retrieve().getContact().getLname().equalsIgnoreCase(lname))
				evn.remove();
			evn.findNext();
		}
		if (evn.retrieve().getContact().getFname().equalsIgnoreCase(fname)&& evn.retrieve().getContact().getLname().equalsIgnoreCase(lname))
			evn.remove();

	}

	public boolean addEvent(Event ev) {
		if (phonebook.empty())
			return false;
		boolean condtion1 = false;

		phonebook.findFirst();
		while (!phonebook.last()) {
			if (phonebook.retrieve().getFname().equalsIgnoreCase(ev.getContact().getFname())
					&& phonebook.retrieve().getLname().equalsIgnoreCase(ev.getContact().getLname())) {
				condtion1 = true;
				break;
			}
			phonebook.findNext();
		}
		if (phonebook.retrieve().getFname().equalsIgnoreCase(ev.getContact().getFname())&& phonebook.retrieve().getLname().equalsIgnoreCase(ev.getContact().getLname())) {
			condtion1 = true;

		}

		if (condtion1) {
			if (evn.empty()) {
				evn.insertBySorting(ev);
			}
			boolean condtion2 = true;
			evn.findFirst();
			while (!evn.last()) {
				if (evn.retrieve().getContact().getFname().equalsIgnoreCase(ev.getContact().getFname())&& evn.retrieve().getContact().getLname().equalsIgnoreCase(ev.getContact().getLname())&& evn.retrieve().getDate().equalsIgnoreCase(ev.getDate())&& evn.retrieve().getTime().equalsIgnoreCase(ev.getTime())) {
					condtion2 = false;
					break;
				}
				evn.findNext();
			}
			if (evn.retrieve().getContact().getFname().equalsIgnoreCase(ev.getContact().getFname())	&& evn.retrieve().getContact().getLname().equalsIgnoreCase(ev.getContact().getLname())&& evn.retrieve().getDate().equalsIgnoreCase(ev.getDate())&& evn.retrieve().getTime().equalsIgnoreCase(ev.getTime())) {
				condtion2 = false;
			}
			if (condtion2) {
				evn.insertBySorting(ev);
				return true;
			} else
				return false;

		} else {
			return false;
		}
	}

	public Event searchEvent(String n) {

		
		if (evn.empty())
			return null;
		evn.findFirst();
		while (!evn.last()) {// n reprsent title or name
			if ((evn.retrieve().getContact().getFname()+" "+evn.retrieve().getContact().getLname()).equalsIgnoreCase(n) || evn.retrieve().getTitle().equalsIgnoreCase(n))
				return evn.retrieve();
			evn.findNext();
		}
		if ((evn.retrieve().getContact().getFname()+" "+evn.retrieve().getContact().getLname()).equalsIgnoreCase(n) || evn.retrieve().getTitle().equalsIgnoreCase(n))
			return evn.retrieve();
		return null;
	}
	
	public void printEvent() {
		if(evn.empty()) {
			System.out.println("there are no events");
			return;
		}
		evn.findFirst();
		while(!evn.last()) {
			evn.retrieve().tostring();
			evn.findNext();
		}
		evn.retrieve().tostring();
	}// this method as requirement  O(n)
	public void printcontact() {
		if(phonebook.empty()) {
			System.out.println("there are no contacts");
			return;
		}
		phonebook.findFirst();
		while(!phonebook.last()) {
			phonebook.retrieve().tostring();
			phonebook.findNext();
		}
		phonebook.retrieve().tostring();
	}
	public void printByFirstName(String fname) {
		if(phonebook.empty()) {
			System.out.println("this name is not found");
			return;
		}
		phonebook.findFirst();
		while(!phonebook.last()) {
			if(fname.equalsIgnoreCase(phonebook.retrieve().getFname())) {
				System.out.println("Contacts found!");
				phonebook.retrieve().tostring();
				System.out.println("");
			}
			phonebook.findNext();
		}if(fname.equalsIgnoreCase(phonebook.retrieve().getFname())) {
			System.out.println("Contacts found!");
			phonebook.retrieve().tostring();
			return;
		}
		System.out.println("this name is not founded");
		
	}

}