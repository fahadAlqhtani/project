
public class Contact implements Comparable<Contact> {
	private String fname,lname, phone, email, address, birthday, notes;
	

	public int compareTo(Contact otherContact) {
		String name1=fname+" "+lname;
		String name2=otherContact.getFname()+" "+otherContact.getLname();
		
		return name1.compareTo(name2);
	}

	// Setters & Getters:

	

	public String getPhone_number() {
		return phone;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setPhone_number(String phone_number) {
		this.phone = phone_number;
	}

	public String getEmail_address() {
		return email;
	}

	public void setEmail_address(String email_address) {
		this.email = email_address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	public void tostring() {
		System.out.println("Name: "+getFname()+" "+getLname());
		System.out.println("phone Number: "+getPhone_number());
		System.out.println("Email Adress : "+getEmail_address());
		System.out.println("Adress: "+getAddress());
		System.out.println("Birthday: "+getBirthday());
		System.out.println("Notes: "+getNotes());
		
	}

}
