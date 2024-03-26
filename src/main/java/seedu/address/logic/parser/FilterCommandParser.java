package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.FilterCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.MatchingDatePredicate;
import seedu.address.model.person.MatchingTagPredicate;

/**
 * Parses input arguments and creates a new FilterCommand object
 */
public class FilterCommandParser implements Parser<FilterCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FilterCommand
     * and returns a FilterCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FilterCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        String field = trimmedArgs.substring(0, trimmedArgs.indexOf(" "));
        String key = trimmedArgs.substring(trimmedArgs.indexOf(" ") + 1).trim();;
        if (field.isEmpty() || key.isEmpty() || key.equals(field)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCommand.MESSAGE_USAGE));
        }
        switch(field) {
        case "t/":
            return new FilterCommand(new MatchingTagPredicate(key));
        case "d/":
            return new FilterCommand(new MatchingDatePredicate(key));
        default:
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCommand.MESSAGE_USAGE));
        }
    }
}
