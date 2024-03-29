package seedu.internhub.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.internhub.model.Model;
import seedu.internhub.model.ModelManager;
import seedu.internhub.model.UserPrefs;
import seedu.internhub.model.person.Person;
import seedu.internhub.testutil.PersonBuilder;
import seedu.internhub.testutil.TypicalPersons;

class ReminderCommandTest {

    private Model model;

    @BeforeEach
    public void setup() {
        LocalDateTime currentDateTime = LocalDateTime.of(2024, 3, 29, 12, 0);
        // test cases might fail unpredictably due to reliance on the system clock for setting up LocalDateTime objects.
        // By setting a fixed date and time in the setup method of the test class, we ensure consistent behavior across
        // different runs regardless of the time of execution. This change improves the reliability of the test suite.

        model = new ModelManager(TypicalPersons.getTypicalAddressBook(), new UserPrefs());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm");
        Person alice = new PersonBuilder().withName("Alice")
                .withInterviewDate(currentDateTime.plusDays(1).format(formatter))
                .build();
        Person bob = new PersonBuilder().withName("Bob")
                .withInterviewDate(currentDateTime.plusDays(4).format(formatter))
                .build();
        Person charlie = new PersonBuilder().withName("Charlie")
                .withInterviewDate(currentDateTime.plusDays(6).format(formatter))
                .build();
        Person dave = new PersonBuilder().withName("Dave")
                .withInterviewDate(currentDateTime.plusDays(8).format(formatter))
                .build();

        model.addPerson(alice);
        model.addPerson(bob);
        model.addPerson(charlie);
        model.addPerson(dave);
    }

    @Test
    public void execute_afterReminder_showsCorrectMessage() {
        int numberOfDays = 5;
        CommandResult commandResult = new ReminderCommand(numberOfDays).execute(model);

        String actualMessage = commandResult.getFeedbackToUser();

        String expectedMessage = String.format(ReminderCommand.MESSAGE_SUCCESS, numberOfDays);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void countListSizeAfter1Day() {
        int numberOfDays = 1;
        new ReminderCommand(numberOfDays).execute(model);

        List<Person> filteredList = model.getFilteredPersonList();
        assertEquals(1, filteredList.size());
    }

    @Test
    public void countListSizeAfter4Day() {
        int numberOfDays = 4;
        new ReminderCommand(numberOfDays).execute(model);

        List<Person> filteredList = model.getFilteredPersonList();
        assertEquals(2, filteredList.size());
    }

    @Test
    public void countListSizeAfter6Day() {
        int numberOfDays = 6;
        new ReminderCommand(numberOfDays).execute(model);

        List<Person> filteredList = model.getFilteredPersonList();
        assertEquals(3, filteredList.size());
    }

    @Test
    public void countListSizeAfter8Day() {
        int numberOfDays = 8;
        new ReminderCommand(numberOfDays).execute(model);

        List<Person> filteredList = model.getFilteredPersonList();
        assertEquals(4, filteredList.size());
    }
}