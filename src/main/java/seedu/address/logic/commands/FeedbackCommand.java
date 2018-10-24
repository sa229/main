package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FEEDBACK;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;


/**
 * Edits the details of an existing person in the address book.
 */
public class FeedbackCommand extends Command {

    public static final String COMMAND_WORD = "fb";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Updates the feedback for the person identified "
            + "by the index number used in the displayed person list. "
            + "Existing feedback will be overwritten by the input feedback.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_FEEDBACK + "FEEDBACK]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + "r/5";

    public static final String MESSAGE_FEEDBACK_PERSON_SUCCESS = "Feedback updated for Person: %1$s";

    private final Index index;

    /**
     * @param index of the person in the filtered person list to edit
     */
    public FeedbackCommand(Index index) {
        requireNonNull(index);

        this.index = index;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        throw new CommandException("Exception");
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FeedbackCommand // instanceof handles nulls
                && index.equals(((FeedbackCommand) other).index)); // state check
    }
}
