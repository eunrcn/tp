package seedu.address.model.person;

import java.time.LocalDateTime;
import java.util.function.Predicate;

/**
 * Tests that a {@code Person}'s {@code Date} matches the date given.
 */
public class MatchingDatePredicate implements Predicate<Person> {

    private final int year;
    private final int month;
    private final int day;

    /**
     * takes in a String input from user and parses the individual date fields as Integers
     * @param date  input date as String
     */
    public MatchingDatePredicate(String date) {
        String[] entries = date.split("-");
        this.day = Integer.parseInt(entries[0]);
        this.month = Integer.parseInt(entries[1]);
        this.year = Integer.parseInt(entries[2]);
    }

    @Override
    public boolean test(Person person) {
        LocalDateTime other = person.getInterviewDate().value;
        return this.day == other.getDayOfMonth()
                && this.month == other.getMonthValue()
                && this.year == other.getYear();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof MatchingDatePredicate)) {
            return false;
        }

        MatchingDatePredicate otherMatchingDatePredicate = (MatchingDatePredicate) other;
        return this.day == otherMatchingDatePredicate.day
                && this.month == otherMatchingDatePredicate.month
                && this.year == otherMatchingDatePredicate.year;
    }

    @Override
    public String toString() {
        return "date " + this.day + "-" + this.month + "-" + this.year;
    }

}
