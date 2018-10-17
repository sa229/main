package seedu.address.logic.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.Assert;
import org.junit.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.PrivacyCommand.FieldsToChange;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.testutil.FieldsToChangeBuilder;
import seedu.address.testutil.PersonBuilder;
import seedu.address.testutil.TypicalPersons;

public class PrivacyCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private CommandHistory commandHistory = new CommandHistory();

    @Test
    public void execute_allFIeldsSpecifiedUnfilteredList_success() {
        Person editedPerson = TypicalPersons.ALICE;
        FieldsToChange fieldsToChange = new FieldsToChangeBuilder().withNotPrivate().build();
        PrivacyCommand privacyCommand = new PrivacyCommand(INDEX_FIRST_PERSON, fieldsToChange);

        String expectedMessage = String.format(PrivacyCommand.MESSAGE_EDIT_PRIVACY_SUCCESS, editedPerson);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.updatePerson(model.getFilteredPersonList().get(0), editedPerson);
        expectedModel.commitAddressBook();

        assertCommandSuccess(privacyCommand, model, commandHistory, expectedMessage, expectedModel);

    }

    @Test
    public void execute_someFieldsSpecifiedUnfilteredList_success() {
        Index indexLastPerson = Index.fromOneBased(model.getFilteredPersonList().size());

        FieldsToChange fieldsToChange = new FieldsToChangeBuilder().withPrivatePhone().withPrivateEmail().build();
        PrivacyCommand privacyCommand = new PrivacyCommand(indexLastPerson, fieldsToChange);

        try {
            CommandResult result = privacyCommand.execute(model, commandHistory);
            Assert.assertEquals(model.getFilteredPersonList().get(indexLastPerson.getZeroBased()).getPhone().isPrivate(),
                    true);
            Assert.assertEquals(model.getFilteredPersonList().get(indexLastPerson.getZeroBased()).getEmail().isPrivate(),
                    true);
            Assert.assertEquals(model.getFilteredPersonList().get(indexLastPerson.getZeroBased()).getAddress().isPrivate(),
                    false);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }
}
