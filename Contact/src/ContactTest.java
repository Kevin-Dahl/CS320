import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {
	
	@Test
	public void testFirstName() {
		//test empty name
		Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", null, "lastName", "1234567890", "address");
		});
		
		String nullExpectedMessage = "First name must not be empty and must be no longer than 10 characters";
		String nullActualMessage = nullException.getMessage();
		
		assertTrue(nullActualMessage.equals(nullExpectedMessage));
		
		//test out of bounds error
		Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "elevenChars", "lastName", "1234567890", "address");
		});
		
		String lengthExpectedMessage = "First name must not be empty and must be no longer than 10 characters";
		String lengthActualMessage = lengthException.getMessage();
		
		assertTrue(lengthActualMessage.equals(lengthExpectedMessage));
	}
	
	@Test
	public void testLastName() {
		//test empty last name
		Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", null, "1234567890", "address");
		});
		
		String nullExpectedMessage = "Last name must not be empty and must be no longer than 10 characters";
		String nullActualMessage = nullException.getMessage();
		
		assertTrue(nullActualMessage.equals(nullExpectedMessage));
		
		//test out of bounds error on last name
		Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", "elevenChars", "1234567890", "address");
		});
		
		String lengthExpectedMessage = "Last name must not be empty and must be no longer than 10 characters";
		String lengthActualMessage = lengthException.getMessage();
		
		assertTrue(lengthActualMessage.equals(lengthExpectedMessage));
	}
	
	@Test
	public void testPhoneNumber() {
		//test empty phone number
		Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", "lastName", null, "address");
		});
		
		String nullExpectedMessage = "Phone number must not be empty and must be 10 characters long";
		String nullActualMessage = nullException.getMessage();
		
		assertTrue(nullActualMessage.equals(nullExpectedMessage));
		
		//test out of bounds error on phone number
		Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", "lastName", "elevenChars", "address");
		});
		
		String lengthExpectedMessage = "Phone number must not be empty and must be 10 characters long";
		String lengthActualMessage = lengthException.getMessage();
		
		assertTrue(lengthActualMessage.equals(lengthExpectedMessage));
	}
	
	@Test
	public void testAddress() {
		// test that null address throws an exception
		Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", "lastName", "1234567890", null);
		});
		
		String nullExpectedMessage = "Address must not be empty and must be no longer than 30 characters";
		String nullActualMessage = nullException.getMessage();
		
		assertTrue(nullActualMessage.equals(nullExpectedMessage));
		
		//test out of bounds error on address 
		Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", "lastName", "1234567890", "tooooooooooooo many characterssssssssssssss");
		});
		
		String lengthExpectedMessage = "Address must not be empty and must be no longer than 30 characters";
		String lengthActualMessage = lengthException.getMessage();
		
		assertTrue(lengthActualMessage.equals(lengthExpectedMessage));
	}
	
	@Test
	public void testGoodContact() {
		//ensure that a correct contact is saved
		Contact testContact = new Contact("1234", "David", "Wilsonnn", "2082709362", "101 Rosewood");
				
		assertTrue(testContact.getId().equals("1234"));
		assertTrue(testContact.getFirstName().equals("David"));
		assertTrue(testContact.getLastName().equals("Wilsonnn"));
		assertTrue(testContact.getPhoneNumber().equals("2082709362"));
		assertTrue(testContact.getAddress().equals("101 Rosewood"));
	}

}