package seedu.address.logic.commands;

import static org.junit.Assert.assertTrue;
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
    public void execute_exception() {
        boolean thrown = false;
        //Index indexLastPerson = Index.fromOneBased(model.getFilteredPersonList().size());
        FeedbackCommand feedbackCommand = new FeedbackCommand();

        try {
            feedbackCommand.execute(model, commandHistory);
        } catch (CommandException ce) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}
