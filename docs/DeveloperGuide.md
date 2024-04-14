---
layout: default.md
title: "Developer Guide"
pageNav: 3
---

# InternHub Developer Guide
_By F14-1, JAYME_

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

# 1. Acknowledgements

* This is a brownfield project based on the AddressBook-Level3 created by the [SE-EDU initiative](https://se-education.org/)
* AI tools used: 
  * ChatGPT by OpenAI used to answer design questions and minor documentation formats.

--------------------------------------------------------------------------------------------------------------------

# 2. Setting up, getting started

Refer to the guide [_Setting up and getting started_](SettingUp.md) for initial setup and basic instructions.

--------------------------------------------------------------------------------------------------------------------

# 3. Design

## 3.1 Architecture

<puml src="diagrams/ArchitectureDiagram.puml" width="280" />

The ***Architecture Diagram*** given above explains the high-level design of the App.

Given below is a quick overview of main components and how they interact with each other.

**Main components of the architecture**

**`Main`** (consisting of classes [`Main`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java)) is in charge of the app launch and shut down.
* At app launch, it initializes the other components in the correct sequence, and connects them up with each other.
* At shut down, it shuts down the other components and invokes cleanup methods where necessary.

The bulk of the app's work is done by the following four components:

* [**`UI`**](#ui-component): Manages the user interface of the app.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<puml src="diagrams/ArchitectureSequenceDiagram.puml" width="574" />

Each of the four main components (also shown in the diagram above),

* defines its *API* in an `interface` with the same name as the Component.
* implements its functionality using a concrete `{Component Name}Manager` class (which follows the corresponding API `interface` mentioned in the previous point.

For example, the `Logic` component defines its API in the `Logic.java` interface and implements its functionality using the `LogicManager.java` class which follows the `Logic` interface. Other components interact with a given component through its interface rather than the concrete class (reason: to prevent outside component's being coupled to the implementation of a component), as illustrated in the (partial) class diagram below.

<puml src="diagrams/ComponentManagers.puml" width="300" />

The sections below give more details of each component.

## 3.2 UI component

The **API** of this component is specified in [`Ui.java`](https://github.com/AY2324S2-CS2103T-F14-1/tp/blob/master/src/main/java/seedu/internhub/ui/Ui.java)

<puml src="diagrams/UiClassDiagram.puml" alt="Structure of the UI Component"/>

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `PersonListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class which captures the commonalities between classes that represent parts of the visible GUI.

The `UI` component uses the JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/AY2324S2-CS2103T-F14-1/tp/blob/master/src/main/java/seedu/internhub/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/AY2324S2-CS2103T-F14-1/tp/blob/master/src/main/resources/view/MainWindow.fxml)

The `UI` component,

* executes user commands using the `Logic` component.
* listens for changes to `Model` data so that the UI can be updated with the modified data.
* keeps a reference to the `Logic` component, because the `UI` relies on the `Logic` to execute commands.
* depends on some classes in the `Model` component, as it displays `Person` object residing in the `Model`.

## 3.3 Logic component

**API** : [`Logic.java`](https://github.com/AY2324S2-CS2103T-F14-1/tp/blob/master/src/main/java/seedu/internhub/logic/Logic.java)

Here's a (partial) class diagram of the `Logic` component:

<puml src="diagrams/LogicClassDiagram.puml" width="550"/>

The sequence diagram below illustrates the interactions within the `Logic` component, taking `execute("delete 1")` API call as an example.

<puml src="diagrams/DeleteSequenceDiagram.puml" alt="Interactions Inside the Logic Component for the `delete 1` Command" />

<box type="info" seamless>

**Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline continues till the end of diagram.
</box>

How the `Logic` component works:

1. When `Logic` is called upon to execute a command, it is passed to an `InternHubParser` object which in turn creates a parser that matches the command (e.g., `DeleteCommandParser`) and uses it to parse the command.
2. This results in a `Command` object (more precisely, an object of one of its subclasses e.g., `DeleteCommand`) which is executed by the `LogicManager`.
3. The command can communicate with the `Model` when it is executed (e.g. to delete a person).<br>
   Note that although this is shown as a single step in the diagram above (for simplicity), in the code it can take several interactions (between the command object and the `Model`) to achieve.
4. The result of the command execution is encapsulated as a `CommandResult` object which is returned back from `Logic`.

Here are the other classes in `Logic` (omitted from the class diagram above) that are used for parsing a user command:

<puml src="diagrams/ParserClasses.puml" width="600"/>

How the parsing works:
* When called upon to parse a user command, the `InternHubParser` class creates an `XYZCommandParser` (`XYZ` is a placeholder for the specific command name e.g., `AddCommandParser`) which uses the other classes shown above to parse the user command and create a `XYZCommand` object (e.g., `AddCommand`) which the `InternHubParser` returns back as a `Command` object.
* All `XYZCommandParser` classes (e.g., `AddCommandParser`, `DeleteCommandParser`, ...) inherit from the `Parser` interface so that they can be treated similarly where possible e.g, during testing.

## 3.4 Model component
**API** : [`Model.java`](https://github.com/AY2324S2-CS2103T-F14-1/tp/blob/master/src/main/java/seedu/internhub/model/Model.java)

<puml src="diagrams/ModelClassDiagram.puml" />


The `Model` component,

* stores the address book data i.e., all `Person` objects (which are contained in a `UniquePersonList` object).
* stores the currently 'selected' `Person` objects (e.g., results of a search query) as a separate _filtered_ list which is exposed to outsiders as an unmodifiable `ObservableList<Person>` that can be 'observed' e.g. the UI can be bound to this list so that the UI automatically updates when the data in the list change.
* stores a `UserPref` object that represents the user’s preferences. This is exposed to the outside as a `ReadOnlyUserPref` objects.
* does not depend on any of the other three components (as the `Model` represents data entities of the domain, they should make sense on their own without depending on other components)

## 3.5 Storage component

**API** : [`Storage.java`](https://github.com/AY2324S2-CS2103T-F14-1/tp/blob/master/src/main/java/seedu/internhub/storage/Storage.java)

<puml src="diagrams/StorageClassDiagram.puml" width="550" />

The `Storage` component,
* can save both address book data and user preference data in JSON format, and read them back into corresponding objects.
* inherits from both `AddressBookStorage` and `UserPrefStorage`, which means it can be treated as either one (if only the functionality of only one is needed).
* depends on some classes in the `Model` component (because the `Storage` component's job is to save/retrieve objects that belong to the `Model`)

## 3.6 Common classes

Classes used by multiple components are in the `seedu.internhub.commons` package. The three over-arching sub-packages are `core`, `exceptions`, and `util`.

`core`: This package defines classes for user configuration, GUI settings, and even a version number.

`exceptions`: This package defines exceptions thrown by InternHub when it encounters an error state.

`util`: This package defines utility classes for certain operations, like file I/O, argument validation, and image processing.

--------------------------------------------------------------------------------------------------------------------
# 4. Implementation

This section describes some noteworthy details on how certain features are implemented.

## 4.1 Add Command

### 4.1.1 Command Structure

<box>

**Format:** `add c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL [a/ADDRESS] t/TAG jd/JOB_DESCRIPTION [d/INTERVIEW_DATE] id/INTERN_DURATION s/SALARY [n/NOTE]`

</box>

<box type="info">

Parameters in `[]` are optional.

</box>

### 4.1.2 Implementation
This command adds an internship application into the InternHub using the company name, phone number, email, address, tag, job description, interview date, intern duration, salary and note.

The following steps show how the add internship application feature works:

1. Command Parsing
    - When a user inputs the `add` command followed by internship application details, the `AddCommandParser` is invoked to parse this input.
2. Getting inputs
   - Input is broken down into individual components based on predefined prefixes.
   - Check for missing or duplicates prefix.
   - Once all components are successfully parsed, a new Person object representing the internship application is created using the parsed values.
3. Execution
   - Upon parsing, the `AddCommand` is instantiated with the Person object.
   - The AddCommand#execute(Model model) is then called, passing the current application model.
    - Input is broken down into individual components based on predefined prefixes.
    - Check for missing or duplicates prefix.
    - Once all components are successfully parsed, a new Person object representing the internship application is created using the parsed values.
4. Command Result
    - The AddCommand constructs a new `CommandResult` with the following params:
        - feedbackToUser: `New internship application added: [newly added internship application details]`.
5. UI
    - The ViewPanel class displays the personToView with all its details and fields.


### 4.1.3 Design Considerations
Alternative 1 (current choice): Creates a new Person object in AddCommandParser.

- Pros: Simpler to test and understand.

- Cons: Command object should not know details about model i.e. Person.

Alternative 2: New Person object is created and added to InternHub in model.

- Pros: Command has no knowledge of Model and its attributes.

- Cons: More prone to error.

### 4.1.4 Diagrams

The diagram below shows the class diagram for AddCommand.

<puml src="diagrams/AddCommandClassDiagram.puml" width="550" />

The diagram below shows the sequence diagram for AddCommand. All Initialization commands above are similar in their interactions with the [logic component](#33-logic-component) and [model component](#34-model-component).

<puml src="diagrams/AddSequenceDiagram.puml" />


## 4.2 Edit Command

### 4.2.1 Command Structure

<box>

**Format:** `edit INDEX [c/COMPANY_NAME] [p/PHONE_NUMBER] [e/EMAIL] [t/TAG] [jd/JOB_DESCRIPTION] [id/INTERN_DURATION] [s/SALARY] [a/ADDRESS] [d/INTERVIEW_DATE] [n/NOTE]`

</box>

<box type="info">

- `INDEX` is a positive integer representing the index of the application in the applications list.
- Editing any field with a new value will **OVERWRITE** the old value.
- At least one parameter needs to be included.

</box>

### 4.2.2 Implementation

The `EditCommand` allows users to modify the details of an existing internship application, based on their table `index`.

1. Parsing:
    - The input arguments are parsed to extract the index and the new values for the internship application's details.
2. Validation:
    - The validity of the index and the absence of duplicate prefixes are verified.
3. Creation of Edit Descriptor:
    - An `EditPersonDescriptor` object is created to store the edited details.
4. Field Editing:
    - Each provided field is set in the `EditPersonDescriptor`.
5. Execution:
    - The `EditCommand` is executed, modifying the specified internship application's details.
6. Feedback:
    - A success message is generated to confirm the editing operation.

### 4.2.3 Design Considerations

- **Overwriting vs. Appending**: The command allows overwriting existing details with new ones. This simplifies the implementation and usage of the command.
- **Error Handling**: The command ensures that at least one field is edited and provides appropriate error messages for invalid inputs.

### 4.2.4 Diagrams

The diagram below shows the class diagram for EditCommand.

<puml src="diagrams/EditCommandClassDiagram.puml" width="550" />

The diagram below shows the sequence diagram for EditCommand. 

<puml src="diagrams/EditSequenceDiagram.puml" />

## 4.3 View Command

### 4.3.1 Command Structure
<box>

**Format:** `view INDEX`

</box>

<box type="info">

`INDEX` is a positive integer representing the index of the application in the applications list.

</box>

### 4.3.2 Implementation
The View Command allows users to view the internship application based on its index in the view panel

The following steps outline how the View Command feature operates :

1. Command Parsing
    - When a user inputs the `view` command followed by an `index`, the `ViewCommandParser` is invoked to parse this input
    - The index provided is extracted from the input string
2. Execution
    - Upon parsing, the `ViewCommand` is instantiated with the parsed index.
    - The `ViewCommand#execute(Model model)` is then called, passing the current application model
3. Index validation
    - Within the `execute` method, the validity of the index entered is checked. This involves ensuring the index falls within the current range of the internship application list
    - If index is invalid, a `CommandException` is thrown with an error message
4. Command Result
    - The `ViewCommand` constructs a new `CommandResult` with the following param :
        - **personToView** : `Current internship application`
5. UI 
    - The `ViewPanel` class displays the **personToView** with all its details and fields

### 4.3.3 Design Considerations

- Fetch `Person` object based on the index
- Utilize the `CommandResult` to pass the `Person` object to the UI component

### 4.3.4 Diagrams

The following sequence diagram shows what happens when `view 3` is the command input.

<puml src="diagrams/ViewSequenceDiagram.puml" />

The following activity diagram shows what the logic behind the command `view 3`.

<puml src="diagrams/ViewActivityDiagram.puml" />

## 4.4 Note Command

### 4.4.1 Command Structure
<box>

**Format:** `note INDEX`

</box>

<box type="info">

`INDEX` is a positive integer representing the index of the application in the applications list.

</box>

### 4.4.2 Implementation
The Note Command feature allows users to retrieve the note attribute of an internship application based on its index and reflects it in the Command Box as an edit command, enabling users to make changes to the note seamlessly.

The following steps outline how the Note Command feature operates:

1. Command Parsing
    - When a user inputs the `note` command followed by an `index`, the `NoteCommandParser` is invoked to parse this input.
    - The index provided is extracted from the input string.
2. Execution
    - Upon parsing, the `NoteCommand` is instantiated with the parsed index.
    - The `NoteCommand#execute(Model model)` is then called, passing the current application model.
3. Index validation
    - Within the `execute` method, the validity of the index entered is checked. This involves ensuring the index falls within the current range of the internship application list.
    - If index is invalid, a `CommandException` is thrown with an error message.
4. Note Retrieval
    - Assuming the index is valid, the `NoteCommand` retrieves the **filtered list of applications** (`List<Person>`) from the model.
    - The note content of the application corresponding to the provided index is then fetched.
5. Command Result
    - Upon retrieving the note content, the `NoteCommand` constructs a new `CommandResult` with the following params :
        - **feedbackToUser** : `edit [INDEX of application] n/{existing note}`
        - **personToView** : `Current internship application`
6. Reflecting the feedback on Command Box
    - In `CommandBox#handleCommandEntered()`, if the `feedbackToUser` of the CommandResult object starts with `edit ` (ie our note Command Result), we set the text of the command box to be the `feedbackToUser`


### 4.4.3 Design Considerations
**Alternative 1 : Use edit to make changes to note attribute**
- Pros:
    - Easier implementation
    - No need for new command to be created
- Cons:
    - Edit will **OVERWRITE** old data

**Alternative 2 (Current Implementation) : Create `note` command**
- Pros:
    - Allows for editing and updating existing note content
    - Will not overwrite old data
- Cons:
    - An additional command has to be implemented
    - Essentially an abstracted & glorified edit feature

### 4.4.4 Diagrams

The diagram below shows the class diagram for NoteCommand.

<puml src="diagrams/NoteCommandClassDiagram.puml" width="300" />

The diagram below shows the sequence diagram for NoteCommand.

<puml src="diagrams/NoteSequenceDiagram.puml" />

The following activity diagram shows how the user can interact with the Note Command

<puml src="diagrams/NoteActivityDiagram.puml" />


## 4.5 Filter Command

### 4.5.1 Command Structure

<box>

**Format:** `filter VALID_TAG`

</box>

<box type="info">

Valid Tag Inputs
- NR: No Reply
- I: Interview
- O: Offered
- OA: Online Assessment
- R: Rejected

</box>

### 4.5.2 Implementation

The Filter Command allows users to filter the current list of applications by a specified tag, such that only applications with said tag will be displayed in the applications list.

The following steps outline how the Filter Command feature operates:

1. Command Parsing
    - When a user inputs the `filter` command followed by a `tag`, the `FilterCommandParser` is invoked to parse this input
    - The tag provided is extracted from the input string
2. List filtering
    - Upon parsing, a `MatchingTagPredicate` is instantiated with the parsed tag String
    - The `FilteredPersonList` representing the list of applications is then updated with the new `MatchingTagPredicate` which checks if the `tag` field of each list entry matches the specified `tag`
3. Execute
    - A `FilterCommand` is instantiated with the number of entries in the updated `FilteredPersonList`.
    - The `FilterCommand#execute(Model model)` is then called, passing the current application model
4. Command Result
    - The `FilterCommand` constructs a new `CommandResult` with the following params :
        - **feedbackToUser** : `[size of filtered list] persons listed`

### 4.5.3 Design Considerations

### 4.5.4 Diagrams

<!-- The diagram below shows the class diagram for FilterCommand. -->

<!-- The diagram below shows the sequence diagram for FilterCommand. -->

<!-- The following activity diagram shows how the user can interact with the FilterCommand -->

## 4.6 Reminder Command

### 4.6.1 Command Structure

<box>

**Format:** `reminder INT`

</box>

### 4.6.2 Implementation

The `ReminderCommand` allows users to filter the list of internship applications to display only those with interviews scheduled within the next 'N' days, including today.

The following steps outline how the Reminder Command feature operates:

1. Command Parsing
    - When a user inputs the `reminder` command followed by a number of days, the `ReminderCommandParser` is invoked to parse this input.
    - The number of days provided is extracted from the input string.
2. Execution
    - Upon parsing, the `ReminderCommand` is instantiated with the parsed number of days.
    - The `ReminderCommand#execute(Model model)` is then called, passing the current application model.
3. Filter Applications
    - Within the `execute` method, the `ReminderCommand` filters the list of internship applications (`List<Person>`) from the model to include only those with upcoming interviews within the specified number of days.
4. Command Result
    - Upon filtering the applications, the `ReminderCommand` constructs a new `CommandResult` with the following parameters:
        - **feedbackToUser**: A message indicating the success of the command, including the number of days and the applications listed.
5. Displaying Feedback
    - The `CommandResult` is displayed to the user, showing the filtered list of applications with upcoming interviews within the specified number of days.

### 4.6.3 Design Considerations
**Alternative 1 (Current Implementation): Create `reminder` command**
- Pros:
    - Provides a dedicated command for filtering applications based on upcoming interviews
    - Offers flexibility in specifying the number of days
- Cons:
    - Requires additional command implementation
    - Might introduce complexity to the command interface

**Alternative 2: Integrated Feature**
- Pros:
    - Combine `reminder` command with existing `filter` command
    - Streamline command interface
- Cons:
    - May increase complexity in command parsing
    - Could potentially confuse users with dual functionality

**Chosen Approach: Alternative 1**
- The chosen approach introduces a dedicated `reminder` command to maintain clarity and flexibility in filtering applications based on upcoming interviews.
- While it requires additional implementation effort, it ensures a clear and distinct feature for users to manage their internship applications effectively.

### 4.6.4 Diagrams

The diagram below shows the class diagram for ReminderCommand.

<puml src="diagrams/ReminderCommandClassDiagram.puml" width="300" />

The diagram below shows the sequence diagram for ReminderCommand. 

<puml src="diagrams/ReminderCommandSequenceDiagram.puml" />

The following activity diagram shows how the user can interact with the ReminderCommand.

<puml src="diagrams/ReminderCommandActivityDiagram.puml" />


--------------------------------------------------------------------------------------------------------------------

# 5. Documentation, logging, testing, configuration, dev-ops

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)

--------------------------------------------------------------------------------------------------------------------

# 6. Appendix A: Requirements

## 6.1 Product scope

**Target user profile**:

* Undergraduate students
* has a need to keep track of contacts of companies and interview dates during their internship hunt
* prefer a one-stop, centralised dashboard to manage all contact details of companies
* is reasonably comfortable in using a more CLI based app
* wants to be better organized

**Value proposition**: Ultimate companion for Undergraduate students embarking on their internship journey!

## 6.2 User stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`


| Priority | As an …​             | I want to …​                                            | So that I can…​                                                                                   |
|----------|----------------------|---------------------------------------------------------|---------------------------------------------------------------------------------------------------|
| `* * *`  | internship applicant | add contact information of internship companies         | easily access their details when needed                                                           |
| `* * *`  | internship applicant | delete contact information of internship companies      | easily remove any old or irrelevant company contacts                                              |
| `* * *`  | internship applicant | edit contact information of internship companies        | easily update any details on the go                                                               |
| `* * *`  | internship applicant | see usage instructions                                  | refer to instructions when I forget how to use the AddressBook                                    |
| `* * *`  | internship applicant | find the contact information of a certain company       | easily search which company contact I want by name                                                |
| `* * *`  | internship applicant | keep track of the status of each internship application | categorize and easily follow up accordingly                                                       |
| `* * *`  | internship applicant | sort company contacts by dates                          | prioritize and plan for upcoming interviews                                                       |
| `* * `   | internship applicant | filter company contacts by date                         | quickly access contacts associated with a specific date                                           |
| `* * `   | internship applicant | filter company contacts by tag                          | easily find and manage contacts within specific categories                                        |
| `* * `   | internship applicant | add a time to a company contact                         | record when a specific task or interaction needs to be done                                       |
| `* `     | internship applicant | add notes to company contacts                           | include important details or information about specific interviews and what I can learn from them |


## 6.3 Use cases

(For all use cases below, the **System** is the `InternHub` and the **User** is the `InternHub User`, unless specified otherwise)

### 6.3.1 Use Case: Adding a new Internship Application

**Main Success Scenario (MSS):**

1. User inputs contact information of internship company.
2. System stores the application information.<br>
Use case ends

**Extensions:**

1a. System detects an error in the entered command syntax.
* 1a1. System requests for the correct command syntax.
* 1a2. User enters correct command syntax.
* Steps 1a1-1a2 are repeated until the command syntax entered is correct.
* Use case resumes from step 2.

1b. System detects an error in the fields being added (No fields at all / Invalid field prefixes / Duplicate prefixes).
* 1a1. System requests for proper input of fields and correct prefix.
* 1a2. User enters the fields to be edited.
* Steps 1a1-1a2 are repeated until the selection is correct.
* Use case resumes from step 2.

---

### 6.3.2 Use Case: Delete Internship Application

**Main Success Scenario (MSS):**

1. User inputs index of internship application to be deleted.
2. System deletes the relevant internship application.<br>
Use case ends

**Extensions:**

1a. System detects an error in index of application.
* 1a1. System requests for proper input of index (1 to current number of applications).
* 1a2. User enters the correct index.
* Steps 1a1-1a2 are repeated until the selection is correct.
* Use case resumes from step 2.

---

### 6.3.3 Use Case: Edit Internship Application Information

**Main Success Scenario (MSS):**

1. User enters the index of the internship application to be edited, along with the details of the field to be modified.
2. System updates the corresponding field of that application.
3. Feedback is provided.
4. Updated information is displayed in the UI.

**Extensions:**

1a. System detects an error in the index of the application.
* 1a1. System requests proper input of the index (1 to the current number of applications).
* 1a2. User enters the correct index.
* Steps 1a1-1a2 are repeated until the correct selection is made.
* Use case resumes from step 1.

1b. User enters edit without index or without specifying the field scenario.
* 1b1. System prompts the user to enter the index and the fields to be edited.
* 1b2. User enters the index and the fields to be edited.
* Use case resumes from step 2.

2. System detects an error in the fields to be edited (No fields at all / Invalid field prefixes / Duplicate prefixes).
* 2a1. System requests proper input of fields and correct prefixes.
* 2a2. User enters the fields to be edited.
* Steps 2a1-2a2 are repeated until the correct selection is made.
* Use case resumes from step 2.

---

### 6.3.4 Use Case: Filter Internship Applications by Tag

**Main Success Scenario (MSS):**

1. User chooses to filter applications by tag.
2. User inputs the tag.
3. System filters the applications associated with the selected tag.
4. System displays the filtered applications.<br>
Use case ends

**Extensions:**

* 2a. System detects an error in tag to be filtered.
    * 2a1. System requests for proper input of tag (One of existing tags : NR, O, OA, I, R).
    * 2a2. User enters the correct tag.
    * Steps 2a1-2a2 are repeated until the selection is correct.
    * Use case resumes from step 3.

---

### 6.3.5 Use Case: View information of an Internship Application

**Main Success Scenario (MSS):**

1. User chooses application to be viewed on view panel.
2. User enters the application index.
3. System views the relevant contact on the view panel.<br>
Use case ends

**Extensions:**

* 2a. System detects an error in index of application.
    * 2a1. System requests for proper input of index (1 to current number of applications).
    * 2a2. user enters the correct index.
    * Steps 2a1-2a2 are repeated until the selection is correct.
    * Use case resumes from step 3.

---

### 6.3.6 Use Case: Modifying existing Note content of an Internship Application

**Main Success Scenario (MSS):**

1. User chooses internship application to update the note content of.
2. System retrieves note content of the corresponding application.
3. User makes changes to the note content.
4. System stores the changes made.<br>
   Use case ends

**Extensions:**

* 1a. System detects an error in index of application.
    * 1a1. System requests for proper input of index (1 to current number of applications).
    * 1a2. Internship Applicant enters the correct index.
    * Steps 1a1-1a2 are repeated until the selection is correct.
    * Use case resumes from step 2.

---


### 6.3.7 Use Case: Be reminded of upcoming Interviews

**Main Success Scenario (MSS):**

1. User decides to filter internship applications by upcoming interviews within a specified number of days.
2. User inputs the number of days for upcoming interviews.
3. System filters the internship applications based on upcoming interviews within the specified number of days.
4. System displays the filtered internship applications.

**Extensions:**

* 2a. System detects an error in the input for the number of days.
    * 2a1. System prompts the user to provide a valid number of days (positive integer).
    * 2a2. User enters the correct number of days.
    * Steps 2a1-2a2 are repeated until the input is valid.
    * Use case resumes from step 3.

---

## 6.4 Non-Functional Requirements

**1. Availability:**
    - The application should be available for download on the project's GitHub release page in the form of a JAR file.

**2. Capacity:**
    - The application should be capable of storing up to 1000 internship applications.

**3. Performance:**
    - Response time to any user command should be within 3 seconds.
    - The application should be able to handle up to 300 internship applications before facing any performance bottleneck issues.

**4. Reliability:**
    - The application should provide guidance to the user if it is unable to execute any user actions for various reasons.

**5. Compatibility:**
    - The application should work as intended on any mainstream operating system.
    - It is guaranteed to work on Java version 11.

**6. Usability:**
    - A user with above-average typing speed for regular English text should be able to accomplish most tasks faster using commands than using the mouse.

**7. Robustness:**
    - The application should remain highly relevant to internship applications at any point in the future.

**8. Integrity:**
    - There should be user updates to the internship applications to ensure integrity.
    - Application updates should not compromise the integrity of the save file.

**9. Maintainability:**
    - The application should comply with the coding standards set forth by CS2103T.
    - It should adhere to best coding practices highlighted in CS2103T.
    - The design should allow any programmer with at least a year of experience to read, maintain, and contribute to the source code easily.

**10. Process:**
    - The project features should align with any changes to real-world internship application processes.

**11. Project Scope:**
    - The application requires manual addition of internship applications into the system.

**12. Privacy:**
    - The application should not store any information about users' internship applications in remote storage.

## 6.5 Glossary

**1. Main components**: Main, UI, Logic, Model, Storage, Commons.
**2. Architecture Diagram**: High-level design overview.
**3. UI component**: Manages app interface elements.
**4. Logic component**: Executes user commands.
**5. Model component**: Stores app data.
**6. Storage component**: Handles data storage.
**7. Common classes**: Shared utility classes.
**8. Mainstream OS**: Windows, Linux, Unix, MacOS.
**9. CLI**: Command Line Interface for user interaction.

--------------------------------------------------------------------------------------------------------------------

# 7. Appendix B: Planned Enhancements

Team size: 5

**1. Handling of invalid date to be with accordance of Gregorian Calendar**:
    - Ensure that the system handles invalid date inputs according to the rules of the Gregorian calendar, providing better error handling and user feedback.
    - Currently, when InternHub encounter `29-02-yyyy` where it is not a leap year, it will automatically changes it to the closest valid date, which is `28-02-yyyy`.
    - We intend to make the system throw an error message instead to warn user about this invalid date and it is possible that they might have schedules an interview with a company on an non existent date.
**2. Case sensitive for company name**:
    - Implement case sensitivity for company names to prevent potential duplication or confusion due to variations in casing.
**3. Prevent duplicate phone number**:
    - Add validation logic to prevent the addition of internship applications with duplicate phone numbers, reducing data redundancy and maintaining data integrity.
**4. Make company name less restrictive, allow special characters**:
    - Relax the restrictions on company names to allow for special characters, enabling users to input a wider range of company names without encountering validation errors.
**5. In UI, make the view card scrollable for all labels**:
    - Enhance the user interface by making the view card scrollable for all labels, ensuring that users can view all information associated with an internship application, even if it exceeds the visible area of the card.
**6. More flexible Filter Command**:
    - We aim to make our filter command to work with all other fields like `address`, `salary`, `jobDescription` and so on, to allow greater flexibility for the user.
    - To achieve this, our team is working on incorporating prefixes in the filter command, for example: `filter a/Clementi t/I s/1200` would filter the applications that fit the provided filter-restrictions.
**7. Countdown in UI reflecting the number of days until interview date**:
    - Implement a feature in the user interface to display a countdown for interviews, showing the number of days left. This provides users with quick access to important information.
**8. Find command based on fields other than name**:
    - Enhance the search functionality by implementing a find command that allows users to search for internship applications based on fields other than the applicant's name. This will provide users with more flexibility in locating specific applications based on various criteria such as company, date, or location.




--------------------------------------------------------------------------------------------------------------------

# 8. Appendix C: Instructions for manual testing

Given below are instructions to test the app manually.

**Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.


## 8.1 Launch and shutdown

1. Initial launch

   1. Download the jar file and copy into an empty folder.

   2. Double-click the jar file. <br>
       Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

2. Saving window preferences

   1. Resize the window to an optimum size. Move the window to a different location. Close the window.

   2. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

3. Using InternHub with Sample Internship Application List
    
   1. Close InternHub. 

   2. Delete the folder `data` which contain file `./addressbook.json` (if applicable).

   3. Launch InternHub. <br>
   Expected: A sample internship application list with 1 internship applications should be displayed.

## 8.2 Adding an internship application

1. Test case: `add c/Singapore Airline p/98765432 e/singaporeairline@example.com t/O jd/Animator intern id/3 months s/1000`<br>
   Expected: A new internship application is added to the list. Details of the added internship application shown in the **result display**.

2. Test case: `add`<br>
   Expected: No internship application is added. Error details shown in the **result display**.


## 8.3 Deleting an internship application

1. Deleting an internship application while all internship applications are being shown

   1. Prerequisites: At least one internship application displayed.

   2. Test case: `delete 1`<br>
      Expected: First application is deleted from the list. Details of the deleted internship application shown in the **result display**.

   3. Test case: `delete 0`<br>
      Expected: No application is deleted. Error details shown in the **result display**. 

   4. Other incorrect delete commands to try: `delete`, `delete x`, `...` (where x is larger than the list size)<br>
      Expected: No application is deleted. Error details shown in the **result display**.

2. Deleting an internship application in a filtered list of applications

    1. Prerequisites: Filter internship applications using `filter I` based on tags. Do note, you can use other valid tags instead of `I` as long as you have a populated result list of applications.

    2. Test case: `delete 1`<br>
       Expected: First application based on the **filtered list** is deleted. Details of deleted internship application shown in **result display**.

## 8.4 Editing an internship application

1. Editing an internship application while all internship applications are being shown

    1. Prerequisites: At least one internship application displayed.

    2. Test case: `edit 1 c/shoppa`<br>
       Expected: The company name of the first internship application is updated to shoppa. Details of the edited internship application shown in the **result display**.

    3. Test case: `edit 0`<br>
       Expected: No application is edited. Error details shown in the **result display**.

    4. Other incorrect delete commands to try: `edit`, `edit x`, `...` (where x is larger than the list size)<br>
       Expected: No application is edited. Error details shown in the **result display**.

2. Deleting an internship application in a filtered list of applications

    1. Prerequisites: Filter internship applications using `filter I` based on tags. Do note, you can use other valid tags instead of `I` as long as you have a populated result list of applications.

    2. Test case: `delete 1`<br>
       Expected: First application based on the **filtered list** is deleted. Details of deleted application shown in **result display**.


## 8.5 Viewing an internship application

1. Viewing an internship application with an empty application list

   1. Prerequisites: Clear all applications using `clear` command. Will empty the applications.

   2. Test case: `view 2`<br>
      Expected: Error message should be shown in the **result display** as there are no applications to view.

2. Viewing an internship application in a populated list

    1. Prerequisites: Ensure **at least 1 internship application** is in the applications list of InternHub.

    2. Test case: `view 1` <br>
       Expected: The application details at index 1 will be aptly displayed on the view panel on the right.

       
## 8.6 List all internship applications
1. Test case: `list`<br>
Expected: List all internship application in InternHub.


## 8.7 Finding internship application(s)

1. Prerequisites: Starting from an empty list,<br>
    * `add c/Singapore Airline p/98765432 e/singaporeairline@example.com t/O jd/Animator intern id/3 months s/1000`

    * `add c/Malaysia Airline p/98765431 e/malaysiaairline@example.com t/NR jd/Data Science intern id/3 months s/1000`

    * `add c/shoppa p/98765430 e/shoppa@example.com t/OA jd/Junior Animator intern id/3 months s/1000`

2. Test case: `find`<br>
   Expected: No internship application is displayed on the view panel on the right. Error message should be shown in the **result display**.

3. Test case: `find airline`<br>
   Expected: The application details of Singapore Airline and Malaysia Airline will be aptly displayed on the view panel on the right (the company name contain the word **airline**).


## 8.8 Modifying note content of an internship application

1. Append to existing note content of internship application

    1. Prerequisites: Attach a test note to the internship application either when you create it or by using `edit`.

    2. Test case: `note 2` where 2 is the index of that application<br>
       Expected: In the command box, you will notice the following: `edit 2 n/[existing note content]`, then you can make changes and enter to modify the note.

## 8.9 Filtering internship applications
1. filter to get internship application(s) with status 'NR' (No Reply) in an empty list

    1. Prerequisites: Clear all applications using `clear` command. Will empty the applications.

    2. Test case: `filter NR`<br>
       Expected: Error message should be shown in the **result display** as there are no applications.

2. filter to get internship application(s) that has status 'NR' (No Reply) in a populated list

    1. Prerequisites: Starting from an empty list,<br>
       * `add c/Singapore Airline p/98765432 e/singaporeairline@example.com t/O jd/Animator intern id/3 months s/1000`

       * `add c/Malaysia Airline p/98765431 e/malaysiaairline@example.com t/NR jd/Data Science intern id/3 months s/1000`

       * `add c/shoppa p/98765430 e/shoppa@example.com t/OA jd/Junior Animator intern id/3 months s/1000`

    2. Test case: `filter NR` (Assuming there are at least 2 applications)<br>
       Expected: Only Malaysia Airline will be displayed on the left side of the list panel.


## 8.10 Getting Reminders for Internship Applications
1. Getting reminders for internship applications which are due or have interviews scheduled in 7 days

   1. Prerequisites: At least one internship application displayed. 
   2. Test case: `reminder 7` <br>
       Expected: Only internship applications which have interviews scheduled in 7 days will be shown. They should be displayed in order of earliest interview date.


## 8.11 Saving data

1. Dealing with missing/corrupted data files

   i. Test case: Deleting name field (the `key` attribute) from a contact in the InternHub data file.<br>
      Expected: After the app is reboot, the now corrupt data file `addressbook.json` will be detected and the corrupted data is considered invalid and will not appear in the app.
   
   ii. Test case: Delete InternHub data file.<br>
      Expected: If the data file `addressbook.json` is nowhere to be found, the app will simply recreate the an empty data file.
   
   iii. Test case: Modify the json format in which InternHub data file is stored.<br>
      Expected: If data file `addressbook.json` is still in the correct format, the app will run as per normal. However, if the data file becomes unreadable by the program, then the invalid data will be ignored when the app is run.

--------------------------------------------------------------------------------------------------------------------

# 9. Appendix D: Effort

## 9.1 Difficulty Level
Overall, our team felt the difficulty level is moderate.

## 9.2 Challenges Faced
- Working on an existing **brownfield** project's codebase takes a while to get accustomed to.
- Coordinating team efforts and managing conflicts while using git to monitor version control.
- The restrictions of an AddressBook had to be considered when implementing new features or enhancing existing features.
- InternHub handles more commands, features and fields for each contact compared to AB3, contributing to the challenge of management.

## 9.3 Effort Required
- Moderate effort required.
- Working as a team allows to regulate and split the workload to ensure effort is optimal.
- Some aspects of the project required greater efforts: 
  - Documentation
  - Test cases
  - UI implementation

## 9.4 Achievements of Project
- Able to meet initially planned features with almost full functionality with minor bugs.
- Effectively delivers a solution for the target audience.
