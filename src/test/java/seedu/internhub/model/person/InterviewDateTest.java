package seedu.internhub.model.person;

import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.internhub.testutil.Assert.assertThrows;

class InterviewDateTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        InterviewDate interviewDate = new InterviewDate(null);
        assertNull(interviewDate.value);
    }
    @Test
    public void constructor_validInput_success() {
        String validInput = LocalDateTime.now().format(InterviewDate.DATE_FORMAT);
        InterviewDate interviewDate = new InterviewDate(validInput);
        assertNotNull(interviewDate.value);
    }
    @Test
    public void isValidDate_success() {
        String validInput = LocalDateTime.now().format(InterviewDate.DATE_FORMAT);
        assertTrue(InterviewDate.isValidDate(validInput));
    }
    @Test
    public void isValidDate_fail() {
        // Older date
        assertFalse(InterviewDate.isValidDate("12-12-1990 1900"));
        // Invalid format
        DateTimeFormatter invalidFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String invalidInput = LocalDateTime.now().format(invalidFormat);
        assertFalse(InterviewDate.isValidDate(invalidInput));
    }
    @Test
    public void isWithinNDays_null() {
        InterviewDate nullDate = new InterviewDate(null);
        assertFalse(nullDate.isWithinNDays(5));
    }
    @Test
    public void equals() {
        String validInput = LocalDateTime.now().format(InterviewDate.DATE_FORMAT);
        String validInput2 = LocalDateTime.now().plusDays(5).format(InterviewDate.DATE_FORMAT);
        InterviewDate interviewDate = new InterviewDate(validInput);

        // same values -> returns true
        assertTrue(interviewDate.equals(new InterviewDate(validInput)));

        // same object -> returns true
        assertTrue(interviewDate.equals(interviewDate));

        // null -> returns false
        assertFalse(interviewDate.equals(null));

        // different types -> returns false
        assertFalse(interviewDate.equals(5.0f));

        // different values -> returns false
        assertFalse(interviewDate.equals(new InterviewDate(validInput2)));
    }
    @Test
    public void hashcode_sameObject_success() {
        String validInput = LocalDateTime.now().format(InterviewDate.DATE_FORMAT);
        InterviewDate interviewDate = new InterviewDate(validInput);
        assertEquals(interviewDate.hashCode(), interviewDate.hashCode());
    }

}