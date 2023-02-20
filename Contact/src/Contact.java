public class Contact {
	// needed variables for the class
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	
	
	//create the object and ensure no issues are found
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		//check first name
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First name must not be empty and must be no longer than 10 characters");
		}
		//check last name
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last name must not be empty and must be no longer than 10 characters");
		}
		//check phone number
		if (phoneNumber == null || phoneNumber.length() != 10) {
			throw new IllegalArgumentException("Phone number must not be empty and must be 10 characters long");
		}
		//check address
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address must not be empty and must be no longer than 30 characters");
		}
		//construct object as long as no issue is found
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	// getter methods
	public String getId() {
		return contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	// Publicly addressable setter methods
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First name must not be empty and must be no longer than 10 characters");
		}
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last name must not be empty and must be no longer than 10 characters");
		}
		this.lastName = lastName;
	}
	public void setPhone(String newPhoneNumber) {
		if (newPhoneNumber == null || newPhoneNumber.length() != 10) {
			throw new IllegalArgumentException("Phone number must not be empty and must be 10 characters long");
		}
		this.phoneNumber = newPhoneNumber;
	}
	public void setAddress(String newAddress) {
		if (newAddress == null || newAddress.length() > 30) {
			throw new IllegalArgumentException("Address must not be empty and must be no longer than 30 characters");
		}
		this.address = newAddress;
	}
}
