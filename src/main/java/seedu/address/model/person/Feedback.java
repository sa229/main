package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's feedback in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidFeedback(String)}
 */
public class Feedback {

    public static final String MESSAGE_FEEDBACK_CONSTRAINTS =
            "Feedback can take any values, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String FEEDBACK_VALIDATION_REGEX = "[^\\s].*";

    public final String feedback;

    /**
     * Constructs a {@code Feedback}.
     *
     * @param feedback A valid feedback.
     */
    public Feedback(String feedback) {
        requireNonNull(feedback);
        checkArgument(isValidFeedback(feedback), MESSAGE_FEEDBACK_CONSTRAINTS);
        this.feedback = feedback;
    }

    /**
     * Returns true if a given string is a valid feedback.
     */
    public static boolean isValidFeedback(String test) {
        return test.matches(FEEDBACK_VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return feedback;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Feedback // instanceof handles nulls
                && feedback.equals(((Feedback) other).feedback)); // state check
    }

    @Override
    public int hashCode() {
        return feedback.hashCode();
    }

}