
public class Main {

	public static void main(String[] args) {
		LinkedList<Contact> test = new LinkedList<Contact>();
		
		Contact a = new Contact();
		a.setName("A");
		Contact b = new Contact();
		b.setName("B");
		Contact c = new Contact();
		c.setName("C");
		Contact d = new Contact();
		d.setName("D");
		
		test.insertBySorting(a);
		test.insertBySorting(b);
		test.insertBySorting(c);
		test.insertBySorting(d);
		
		test.print();
		System.out.println();
		test.deleteContact("T");
		
		test.print();


	}

}
