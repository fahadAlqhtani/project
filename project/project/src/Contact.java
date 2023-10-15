
public class Contact implements Comparable<Contact> {
	private String name, phone, email, address, birthday, notes;

	public int compareTo(Contact otherContact) {
		return this.name.compareTo(otherContact.getName());
	}

	// Setters & Getters:

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone;
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

}
