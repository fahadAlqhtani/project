public class Event implements Comparable<Event> {
private String title, date, time, location;
	private Contact contact;
	public Event() {
		contact=new Contact();
	}

	public int compareTo(Event otherEvent) {
		return this.title.compareTo(otherEvent.getTitle());
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public void tostring() {
		System.out.println("Event title: "+getTitle());
		System.out.println("Contact name: "+getContact().getFname()+" "+getContact().getLname());
		System.out.println("Event date and time (MM/DD/YYYY HH:MM):"+getDate()+" "+getTime());
		System.out.println("Event location: "+getLocation());
	}
}
