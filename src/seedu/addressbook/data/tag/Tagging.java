package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Represents an association between a Person and a Tag in the address book.
 */
public class Tagging {
	private Person person;
	private Tag tag;
	private boolean isAddition;
	
	public Tagging(Person person, Tag tag, boolean isAddition) {
		this.person = person;
		this.tag = tag;
		this.isAddition = isAddition;
	}
	
	public Person getPerson() {
		return this.person;
	}
	
	public Tag getTags() {
		return this.tag;
	}
	
	public boolean getIsAddition() {
		return this.isAddition;
	}
}
