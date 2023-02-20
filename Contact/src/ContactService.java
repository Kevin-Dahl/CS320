import java.util.ArrayList;

public class ContactService {
	
	public static String publicId;
	public String publicFirstName;
	public String publicLastName;
	public String publicPhone;
	public String publicAddress;
	
	//Array for storage of contact list
	static ArrayList<Contact> contactList = new ArrayList<Contact>(0);
	
	//Set to generate a unique string for each contact
	public static String generateUniqueId() {
		//Starting empty string
		String uniqueId;
		//Set the base starting ID
		if (contactList.isEmpty()) {
			publicId = "1000000001";
		}
		//Checks the latest value if the list isn't empty
		else {
			int arraySize = contactList.size();
			publicId = contactList.get(arraySize - 1).getId();
		}
		//Convert string to int to add value easier
		int tempInt = Integer.valueOf(publicId);
		// add 1 to make next value unique
		tempInt += 1;
		// convert back to string to store
		uniqueId = Integer.toString(tempInt);
		return uniqueId;
	}
	
	//Substantiates the creation of an object
	public static void addContact(String firstName, String lastName, String phoneNumber, String address) {
		String ID = generateUniqueId();
		Contact Contact1 = new Contact(ID, firstName, lastName, phoneNumber, address);
		contactList.add(Contact1);
	}
	//Manual addition of a contact for testing
	public static void addContact(Contact newContact) {
		String tempId = newContact.getId();
		for (int i = 0; i < contactList.size(); i++) {
			if (tempId.equals(contactList.get(i).getId())) {
				throw new IllegalArgumentException("Contact ID Must Be Unique");
			}
		}
		contactList.add(newContact);
	}
	
	//Methods with which to update a contact
	public static void updateFirstName(String uniqueId, String publicFirstName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
			contactList.get(i).setFirstName(publicFirstName);
			}
		}
	}
	public static void updateLastName(String uniqueId, String publicLastName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
			contactList.get(i).setLastName(publicLastName);
			}
		}
	}
	public static void updatePhoneNum(String uniqueId, String publicPhone) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
			contactList.get(i).setPhone(publicPhone);
			}
		}
	}
	public static void updateAddress(String uniqueId, String publicAddress) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
			contactList.get(i).setAddress(publicAddress);
			}
		}
	}
	//Deletion methods for a contact
	public static void deleteContact(String uniqueId) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
				int position = i;
				//deletes a contact at the marked position.
				contactList.remove(position);
			}
		}
	}
	//Quick search feature used in testing
	public static int searchContact(String uniqueId) {
		int result = 0;
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
				result = 1;
			}
			else {
				result = 2;
			}
		}
		return result;
	}
	//Index function
	public static int findIndex(String uniqueId) {
		int result = 0;
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
				result = i;
			}
		}
		return result;
	}
		
}