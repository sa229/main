package seedu.address.testutil;

import seedu.address.logic.commands.PrivacyCommand.FieldsToChange;

/**
 * A utility class to help with building FieldsToChange objects.
 */
public class FieldsToChangeBuilder {

    private FieldsToChange fieldsToChange;

    public FieldsToChangeBuilder() {
        fieldsToChange = new FieldsToChange();
    }

    /**
     * something
     */
    public FieldsToChangeBuilder withPrivatePhone() {
        fieldsToChange.setPhonePrivacy("Y");
        return this;
    }

    /**
     * something
     */
    public FieldsToChangeBuilder withPrivateEmail() {
        fieldsToChange.setEmailPrivacy("Y");
        return this;
    }

    /**
     * something
     */
    public FieldsToChangeBuilder withPrivateAddress() {
        fieldsToChange.setAddressPrivacy("Y");
        return this;
    }

    /**
     * something
     */
    public FieldsToChangeBuilder withAllPrivate() {
        fieldsToChange.setPhonePrivacy("Y");
        fieldsToChange.setEmailPrivacy("Y");
        fieldsToChange.setAddressPrivacy("Y");
        return this;
    }

    /**
     * something
     */
    public FieldsToChangeBuilder withNotPrivate() {
        fieldsToChange.setPhonePrivacy("N");
        fieldsToChange.setEmailPrivacy("N");
        fieldsToChange.setAddressPrivacy("N");
        return this;
    }

    public FieldsToChange build() {
        return fieldsToChange;
    }

}
