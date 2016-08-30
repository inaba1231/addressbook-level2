package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    // public final String value;
    public final AddressPart[] addressParts = new AddressPart[4];
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        //this.value = address;
        String[] addressSplit = address.split(", ", 4);
        String[] parts = new String[4];
        for (int i = 0; i < parts.length; i++) {
        	if (i < addressSplit.length) parts[i] = addressSplit[i];
        	else parts[i] = null;
        }
        this.addressParts[0] = new Block(parts[0]);
        this.addressParts[1] = new Street(parts[1]);
        this.addressParts[2] = new Unit (parts[2]);
        this.addressParts[3] = new PostalCode(parts[3]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        String result = "";
        for (AddressPart p : this.addressParts) {
        	if(result.isEmpty()) result += p.getPart();
        	else result += ", " + p.getPart();
        }
        return result;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}