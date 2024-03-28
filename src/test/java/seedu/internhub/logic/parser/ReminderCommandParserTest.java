package seedu.internhub.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.internhub.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.internhub.logic.commands.ReminderCommand;
import seedu.internhub.logic.parser.exceptions.ParseException;

public class ReminderCommandParserTest {

    private final ReminderCommandParser parser = new ReminderCommandParser();

    @Test
    public void parse_validArgs_returnsReminderCommand() throws ParseException {
        assertEquals(new ReminderCommand(3), parser.parse("3"));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertThrows(ParseException.class, () -> parser.parse("-3"));
    }

    @Test
    public void parse_invalidArgs_throwsParseExceptionWithCorrectMessage() {
        try {
            parser.parse("-3");
        } catch (ParseException pe) {
            assertEquals(ReminderCommandParser.INVALID_NUMBER_OF_DAYS, pe.getMessage());
        }
    }

    @Test
    public void parse_invalidFormat_throwsParseException() {
        assertThrows(ParseException.class, () -> parser.parse("a"));
    }

    @Test
    public void parse_invalidFormat_throwsParseExceptionWithCorrectMessage() {
        try {
            parser.parse("a");
        } catch (ParseException pe) {
            assertEquals(ReminderCommandParser.INVALID_NUMBER_OF_DAYS, pe.getMessage());
        }
    }

    @Test
    public void parse_emptyArgs_throwsParseException() {
        assertThrows(ParseException.class, () -> parser.parse(""));
    }

    @Test
    public void parse_emptyArgs_throwsParseExceptionWithCorrectMessage() {
        try {
            parser.parse("");
        } catch (ParseException pe) {
            assertEquals(ReminderCommandParser.INVALID_NUMBER_OF_DAYS, pe.getMessage());
        }
    }
}
