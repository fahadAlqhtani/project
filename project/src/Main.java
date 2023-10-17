import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Welcome to the Linked Tree Phonebook!");
		int select=-1;
		Phonebook ph=new Phonebook();
		do {
			System.out.println("Please choose an option:\r\n"
					+ "1. Add a contact\r\n"
					+ "2. Search for a contact\r\n"
					+ "3. Delete a contact\r\n"
					+ "4. Schedule an event\r\n"
					+ "5. Print event details\r\n"
					+ "6. Print contacts by first name\r\n"
					+ "7. Print all events alphabetically\r\n"
					+ "8. Exit\r\n"
					+ "Enter your choice: ");
			select=s.nextInt();
			if(select==1) {
				Contact c=new Contact();
				System.out.println("Enter the contact name :");
					c.setFname(s.next());c.setLname(s.next());
					System.out.println("Enter the contact phone number: ");
					c.setPhone_number(s.next());
					System.out.println("Enter the contact email address: ");
					c.setEmail_address(s.next());
					System.out.println("Enter the contact address: ");
					c.setAddress(s.next());
					System.out.println("Enter the contact birthday: ");
					c.setBirthday(s.next());
					System.out.println("Enter the notes: ");
					String str=s.next();
					c.setNotes(str);
					
					boolean add=ph.addcontact(c);
					if(add) {
						System.out.println("Contact added successfully!");
					}
					else {
						System.out.println("can not add contact is existing!!!");
					}
				
			}else if(select==2) {
				Contact c;
				System.out.println("Enter search criteria:\r\n"
						+ "1. Name\r\n"
						+ "2. Phone Number\r\n"
						+ "3. Email Address\r\n"
						+ "4. Address\r\n"
						+ "5. Birthday\r\n"
						+ "Enter your choice: ");
				select=s.nextInt();
				System.out.println("");
				if(select==1) {
					System.out.println("Enter the name: ");
					String name1=s.next(),name2=s.next();
					String name=name1+" "+name2;
					c=ph.searchByNameORNumber(name);
					if(c==null) {
						System.out.println("the contact not founded");
					}
					else {
						System.out.println("the contact is founded");
						c.tostring();
					}
				}else if(select==2) {
					System.out.println("enter the phone number :");
					c=ph.searchByNameORNumber(s.next());
					if(c==null) {
						System.out.println("the contact not founded");
					}
					else {
						System.out.println("the contact is founded");
						c.tostring();
						}
					}
					else if(select==3) {
						System.out.println("enter the email address :");
						LinkedList<Contact> cc=ph.searchContact(s.next());
						if(cc==null) {
							System.out.println("the contact not founded");
						}else {
							System.out.println("the contact is founded");
							cc.print();
						}
						}else if(select==4) {
							System.out.print("enter the  address :");
							LinkedList<Contact> cc=ph.searchContact(s.next());
							if(cc==null) {
								System.out.print("the contact not founded");
							}else {
								System.out.println("the contact is founded");
								cc.print();
							}
							}else if(select==5) {
								System.out.println("enter the  birthday :");
								LinkedList<Contact> cc=ph.searchContact(s.next());
								if(cc==null) {
									System.out.println("the contact not founded");
								}else {
									System.out.println("the contact  founded");
									cc.print();
								}
					}else {
						System.out.println("wrong number");
					}
					
					select=0;
				}
				
			else if(select==3) {
				System.out.println("enter the name :");
				String name1=s.next();
				String name2=s.next();
				boolean delet=ph.deletcontact(name1, name2);
				if(delet) {
					System.out.println("the cotact is deleted");
					}else {
					System.out.println("the contact not found");	
					}
				
			}else if(select==4) {
				Event e=new Event();
				System.out.println("enter the title event: ");
				e.setTitle(s.next());
				System.out.println("enter the contact name :");
				e.getContact().setFname(s.next());e.getContact().setLname(s.next());
				System.out.println("Enter event date and time (MM/DD/YYYY HH:MM):");
				e.setDate(s.next());e.setTime(s.next());
				System.out.println("Enter event location:");
				e.setLocation(s.next());
				boolean add=ph.addEvent(e);
				if(add) {
					System.out.println("Event scheduled successfully!");
					
				}else System.out.println("faild");
				
			}else if(select==5) {
				Event ev;
				System.out.println("Enter search criteria:\r\n"
						+ "1. contact name\r\n"
						+ "2. Event tittle");
				select=s.nextInt();
				if(select==1) {
					System.out.println("enter the cotact name :");
					String name1=s.next();
					String name2=s.next();
					String name=name1+" "+name2;
					ev=ph.searchEvent(name);
					if(ev==null)System.out.println("not founded");
					else ev.tostring();
					
				}else if(select==2) {
					System.out.println("enter the title of event");
					ev=ph.searchEvent(s.next());
					if(ev==null)System.out.println("not founded");
					else ev.tostring();
				}
				
			}else if(select==6) {
				System.out.println("enter the first name of contact");
				ph.printByFirstName(s.next());
			}else if(select==7) {
				ph.printEvent();
				
			}else if(select!=8) {
				
				System.out.println("incorrect number !");
			}
			
			
		}while(select!=8);
		System.out.println("goodbay");

	}

}
