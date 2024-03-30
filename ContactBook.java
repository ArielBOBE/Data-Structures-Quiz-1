import java.util.LinkedList;
import java.util.Scanner;

public class ContactBook {

	public static void main(String[] args) {
		// initializing LinkedList
		LinkedList<Persona3Reload> contacts = new LinkedList<Persona3Reload>();
		
		// initializing array of choice
		String[] choices = {"a", "d", "e", "p", "s", "q"};
		
		// initializing Scanner
		Scanner scanner = new Scanner(System.in);
		
		// loop variable
		boolean start = true;
		boolean contains = false;
		String choice;
		
		// temporary variables
		String name;
		String email;
		String phoneNum;
		String namePhone;
		int id = 0;
		
		// creating interface
		while(start) {
			System.out.println("****************************************************************");
			System.out.println("(A)dd");
			System.out.println("(D)elete");
			System.out.println("(E)mail Search");
			System.out.println("(P)rint List");
			System.out.println("(S)earch");
			System.out.println("(Q)uit");
			System.out.println("****************************************************************");
			System.out.print("Please Enter a Command: ");
			
			// input getting
			choice = scanner.nextLine().toLowerCase();
			System.out.println("****************************************************************");
			// add
			switch(choice) {
				case "a": // getting info on contact
					System.out.print("\nEnter a full name: ");
					name = scanner.nextLine();
					
					System.out.print("\nEnter "+name+"'s email: ");
					email = scanner.nextLine();
					
					System.out.print("\nEnter "+name+"'s phone number:");
					phoneNum = scanner.nextLine();
					
					id++;
					
					// adding contact to LL
					contacts.add(new Persona3Reload(name, email, phoneNum, id));
					break;
			
			// delete
				case "d":
					// getting name input
					System.out.print("\nEnter name to delete: ");
					name = scanner.nextLine();
					
					for (int i = 0; i < contacts.size(); i++) {
						if (contacts.get(i).getName().equals(name)) {
							contacts.remove(i);
						}
					}
					break;
					
			// email search
				case "e":
					// getting email input
					System.out.print("\nEnter email to search: ");
					email = scanner.nextLine();
					
					for (int i = 0; i < contacts.size(); i++) {
						if (contacts.get(i).getEmail().equals(email)) {
							contacts.get(i).printAll();
							break;
						}
						else if (i == contacts.size() - 1) {
							System.out.println("EMAIL NOT FOUND");
						}
					}
					break;
			
			
			// print list
				case "p":
					if (contacts.size() > 0) {
						for (int i = 0; i < contacts.size(); i++) {
						contacts.get(i).printAll();
						}
					}else {
						System.out.println("EMPTY CONTACTS");
					}
					break;
			
			// search
				case "s":
					// getting name/phoneNum input
					System.out.print("\nEnter full name/phone number (case sensitive): ");
					namePhone = scanner.nextLine();
					
					for (int i = 0; i < contacts.size(); i++) {
						if (namePhone.equals(contacts.get(i).getName())|| namePhone.equals(contacts.get(i).getPhone())) {
							contacts.get(i).printAll();
						}
						else if (i == contacts.size() - 1) {
							System.out.println("CONTACT NOT FOUND");
						}

					}
					break;
			
			// quit
				case "q":
					System.out.println("wogay");
					start = false;
					break;
				
			// if not a valid input
				default: System.out.println("Enter a valid input...");
			}
			
		}
		
	}

}

class Persona3Reload {
	
	// name
	private String fname = "";
	
	// email
	private String email;
	
	// phone number
	private String phoneNum;
	
	// ID
	private int id;
	
	public Persona3Reload(String fname, String email, String phoneNum, int id) {
		this.fname = fname;
		this.email = email;
		this.phoneNum = phoneNum;
		this.id = id;
	}
	
	// getting full name method
	public String getName() {
		return this.fname;
	}
	
	// getting email method
	public String getEmail() {
		return this.email;
	}
	
	// getting phone number method
	public String getPhone() {
		return this.phoneNum;
	}
	
	// getting ID
	public int getID() {
		return this.id;
	}
	
	// print all
	public void printAll() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("\nID:"+getID());
		System.out.println("Name: "+getName());
		System.out.println("Email: "+getEmail());
		System.out.println("Phone: "+getPhone());
	}
}
