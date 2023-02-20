import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {

	//create a contact with test values
	@Test
	public void testContactServiceClass() {
		ContactService.addContact("David", "Wilsonnn", "2082709362", 
				"101 Rosewood");
		assertTrue(ContactService.contactList.get(0).getId().equals("1000000002"));
		assertTrue(ContactService.contactList.get(0).getFirstName().equals("David"));
		assertTrue(ContactService.contactList.get(0).getLastName().equals("Wilsonnn"));
		assertTrue(ContactService.contactList.get(0).getPhoneNumber().equals("2082709362"));
		assertTrue(ContactService.contactList.get(0).getAddress().equals("101 Rosewood"));
	}
	// confirm deletion of a contact
	@Test
	public void testContactServiceDelete() {
		ContactService.addContact("David", "Wilsonnn", "2082709362", 
				"101 Rosewood");
		int size = ContactService.contactList.size();
		ContactService.deleteContact("1000000003");
		assertTrue(ContactService.searchContact("1000000003") == 2);
	}
	//confirm updating first name works and set up contact for testing
	@Test
	public void testContactServiceUpdateFirstName() {
		ContactService.addContact("Alex", "Baldwin", "2082709362", "81 Cedar Hills");
		int size = ContactService.contactList.size();
		System.out.println(ContactService.contactList.get(size - 1).getId());
		System.out.println(ContactService.contactList.get(size - 1).getFirstName());
		ContactService.updateFirstName("1000000003", "Jeff");
		System.out.println(ContactService.contactList.get(size - 1).getFirstName());
		assertTrue(ContactService.contactList.get(size - 1).getFirstName().equals("Jeff"));
	}
	// using previous to confirm the rest
	//confirm updating last name works
	@Test
	public void testContactServiceUpdateLastName() {
		int size = ContactService.contactList.size();
		ContactService.updateLastName("1000000003", "Madara");
		assertTrue(ContactService.contactList.get(size - 1).getLastName().equals("Madara"));
	}
	//confirm updating phone number works
	@Test
	public void testContactServiceUpdatePhone() {
		int target = 0;
		target = ContactService.findIndex("1000000003");
		ContactService.updatePhoneNum("1000000003", "2082336009");
		assertTrue(ContactService.contactList.get(target).getPhoneNumber().equals("2082336009"));
	}
	//confirm updating address works
	@Test
	public void testContactServiceUpdateAddress() {
		int target = 0;
		target = ContactService.findIndex("1000000003");
		ContactService.updateAddress("1000000003", "101 Rosewood");
		assertTrue(ContactService.contactList.get(target).getAddress().equals("101 Rosewood"));
	}
}
