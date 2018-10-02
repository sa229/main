package seedu.address.model.person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.address.testutil.Assert;

public class FeedbackTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> new Feedback(null));
    }

    @Test
    public void constructor_invalidFeedback_throwsIllegalArgumentException() {
        String invalidFeedback = "";
        Assert.assertThrows(IllegalArgumentException.class, () -> new Feedback(invalidFeedback));
    }

    @Test
    public void isValidFeedback() {
        // null feedback
        Assert.assertThrows(NullPointerException.class, () -> Feedback.isValidFeedback(null));

        // invalid feedbacks
        assertFalse(Feedback.isValidFeedback("")); // empty string
        assertFalse(Feedback.isValidFeedback(" ")); // spaces only

        // valid feedbacks
        assertTrue(Feedback.isValidFeedback("This is a very hardworking employee"));
        assertTrue(Feedback.isValidFeedback("-")); // one character
        assertTrue(Feedback.isValidFeedback("You have potential to do very well. Unfortunately, your lacklustre" +
                "attitude will be the cause of your downfall")); // long feedback
    }
}
