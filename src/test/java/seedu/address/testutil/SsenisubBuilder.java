package seedu.address.testutil;

import seedu.address.model.Ssenisub;
import seedu.address.model.person.Person;

/**
 * A utility class to help with building Ssenisub objects.
 * Example usage: <br>
 *     {@code Ssenisub ab = new SsenisubBuilder().withPerson("John", "Doe").build();}
 */
public class SsenisubBuilder {

    private Ssenisub Ssenisub;

    public SsenisubBuilder() {
        Ssenisub = new Ssenisub();
    }

    public SsenisubBuilder(Ssenisub Ssenisub) {
        this.Ssenisub = Ssenisub;
    }

    /**
     * Adds a new {@code Person} to the {@code Ssenisub} that we are building.
     */
    public SsenisubBuilder withPerson(Person person) {
        Ssenisub.addPerson(person);
        return this;
    }

    public Ssenisub build() {
        return Ssenisub;
    }
}
