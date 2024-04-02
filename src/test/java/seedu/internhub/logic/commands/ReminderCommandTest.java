package seedu.internhub.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.internhub.model.AddressBook;
import seedu.internhub.model.Model;
import seedu.internhub.model.ModelManager;
import seedu.internhub.model.UserPrefs;
import seedu.internhub.model.person.Person;
import seedu.internhub.testutil.PersonBuilder;

class ReminderCommandTest {

    private Model model;

    @BeforeEach
    public void setup() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm");
        String plus1Days = LocalDateTime.now().plusDays(1).format(formatter);
        String plus4Days = LocalDateTime.now().plusDays(4).format(formatter);
        String plus6Days = LocalDateTime.now().plusDays(6).format(formatter);
        String plus8Days = LocalDateTime.now().plusDays(8).format(formatter);
        Person alice = new PersonBuilder().withName("Alice")
                .withInterviewDate(plus1Days)
                .build();
        Person bob = new PersonBuilder().withName("Bob")
                .withInterviewDate(plus4Days)
                .build();
        Person charlie = new PersonBuilder().withName("Charlie")
                .withInterviewDate(plus6Days)
                .build();
        Person dave = new PersonBuilder().withName("Dave")
                .withInterviewDate(plus8Days)
                .build();

        AddressBook ab = new AddressBook();
        ab.addPerson(alice);
        ab.addPerson(bob);
        ab.addPerson(charlie);
        ab.addPerson(dave);

        model = new ModelManager(ab, new UserPrefs());
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
