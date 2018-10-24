package seedu.address.logic.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class FeedbackCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private CommandHistory commandHistory = new CommandHistory();

    @Test
    public void equals() {
        FeedbackCommand feedbackFirstCommand = new FeedbackCommand(INDEX_FIRST_PERSON, "Good");
        FeedbackCommand feedbackSecondCommand = new FeedbackCommand(INDEX_SECOND_PERSON, "Bad");

        // same object -> returns true
        assertTrue(feedbackFirstCommand.equals(feedbackFirstCommand));

        // same values -> returns true
        FeedbackCommand feedbackFirstCommandCopy = new FeedbackCommand(INDEX_FIRST_PERSON, "Good");
        assertTrue(feedbackFirstCommand.equals(feedbackFirstCommandCopy));

        // different types -> returns false
        assertFalse(feedbackFirstCommand.equals(1));

        // null -> returns false
        assertFalse(feedbackFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(feedbackFirstCommand.equals(feedbackSecondCommand));
    }
    @Test
    public void execute_exception() {
        boolean thrown = false;
        Index indexLastPerson = Index.fromOneBased(model.getFilteredPersonList().size());
        FeedbackCommand feedbackCommand = new FeedbackCommand(indexLastPerson, "Good");

        try {
            feedbackCommand.execute(model, commandHistory);
        } catch (CommandException ce) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}
