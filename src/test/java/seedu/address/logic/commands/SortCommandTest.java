package seedu.address.logic.commands;

import static org.junit.Assert.assertEquals;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;
import static seedu.address.testutil.TypicalPersons.CARL;


import org.junit.Test;

import seedu.address.model.AddressBook;
import seedu.address.testutil.AddressBookBuilder;

public class SortCommandTest {

    @Test
    public void execute_sortList() {
        AddressBook addressBook = new AddressBookBuilder().withPerson(BOB).withPerson(ALICE).build();
        AddressBook expectedAddressBook = new AddressBookBuilder().withPerson(ALICE).withPerson(BOB).build();
        addressBook.sort();
        assertEquals(addressBook, expectedAddressBook);
    }

    @Test
    public void execute_sortListWithFavourite() {

        // typical person Carl is set to be favourited
        AddressBook addressBook = new AddressBookBuilder().withPerson(BOB).withPerson(ALICE).withPerson(CARL).build();
        AddressBook expectedAddressBook = new AddressBookBuilder().withPerson(CARL).withPerson(ALICE)
                .withPerson(BOB).build();

        addressBook.sort();
        assertEquals(addressBook, expectedAddressBook);
    }
}