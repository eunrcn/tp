package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.MatchingDatePredicate;
import seedu.address.model.person.MatchingTagPredicate;

/**
 * Filters the list of companies to only show entries with the specified tag
 * Tag searching is case-sensitive
 */
public class FilterCommand extends Command {

    public static final String COMMAND_WORD = "filter";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Filters the current list of companies to only display "
            + "those with the specified tag (case-sensitive) as a list with index numbers. \n"
            + "Parameter: t/ TAG \n"
            + "Example: " + COMMAND_WORD + " t/ I";

    private final MatchingTagPredicate tagPredicate;
    private final MatchingDatePredicate datePredicate;

    /**
     * constructor that creates a new FilterCommand for filtering the contacts list by tag
     * @param predicate  predicate for filtering by specified tag
     */
    public FilterCommand(MatchingTagPredicate predicate) {
        this.tagPredicate = predicate;
        this.datePredicate = null;
    }

    /**
     * constructor that creates a new FilterCommand for filtering the contacts list by date
     * @param predicate  predicate for filtering by specified date
     */
    public FilterCommand(MatchingDatePredicate predicate) {
        this.datePredicate = predicate;
        this.tagPredicate = null;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        if (tagPredicate == null) {
            model.updateFilteredPersonList(datePredicate);
        } else {
            model.updateFilteredPersonList(tagPredicate);
        }
        return new CommandResult(
                String.format(
                        Messages.MESSAGE_PERSONS_LISTED_OVERVIEW,
                        model.getFilteredPersonList().size()));

    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FilterCommand)) {
            return false;
        }

        FilterCommand otherFilterCommand = (FilterCommand) other;
        return this.tagPredicate.equals(otherFilterCommand.tagPredicate)
                && this.datePredicate.equals(otherFilterCommand.datePredicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", this.tagPredicate == null ? datePredicate : tagPredicate)
                .toString();
    }
}
