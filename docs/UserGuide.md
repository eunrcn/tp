---
layout: default.md
title: "User Guide"
pageNav: 3
---

# Internhub User Guide

## Welcome !
Are you currently navigating the intricate maze of internship opportunities as an undergraduate? 
Your search ends here! InternHub is poised to transform the way you handle your internship contacts.
InternHub stands as a beacon of productivity, offering you a comprehensive platform to manage and organize all your internship applications effectively.

This User Guide (UG) acts as your trusted companion, providing a wealth of information to assist you in understanding and harnessing the full potential of our application. 
From installation to usage and navigation, each step is meticulously outlined to ensure you derive maximum benefits from InternHub in managing your internship contacts.

## Who can use InternHub ?
InternHub caters to undergraduates from all fields, providing them with a seamless and efficient approach to managing their internship contacts. 
Professors and career guidance officers, we invite you to share this invaluable resource with your students, empowering them to secure their dream internships.

InternHub is designed with **user-friendliness** in mind, catering to individuals with varying levels of computer experience. 
Whether you're a tech-savvy enthusiast or just dipping your toes into the world of desktop applications, rest assured that our interface is intuitive and easy to navigate.
We're committed to supporting you every step of the way on your internship management journey. 

Welcome aboard, and let's embark on this exciting adventure together!

For users who are **new to InternHub**, click [here](#introduction-to-the-user-guide) for a helpful starting point !

Experienced users can jump straight to exploring our [features](#features) !

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## Table of Contents
- [Introduction](#introduction-to-the-user-guide)
- [Quick Start](#quick-start)
- [Getting Familiar with UI](#getting-familiar-with-the-ui-of-internhub)
- [Features](#features)
    - [Help](#viewing-help--help)
    - [Basic Commands](#basic-commands)
        - [Adding a Contact](#adding-a-contact-add)
        - [Deleting a Contact](#deleting-a-contact--delete)
        - [Editing a Contact](#editing-a-contact--edit)
        - [Viewing a Contact](#viewing-a-contact--view)
    - [Advanced Commands](#advanced-commands)
        - [Listing all Contacts](#listing-all-contacts--list)
        - [Locating Contacts by Name](#locating-contacts-by-name-find)
        - [Adding a Note](#adding-a-note--note)
        - [Filter Contacts by Tags](#filtering-the-data-by-tags--filter)
        - [Sending Reminders](#sending-reminders--reminder)
    - [Miscellaneous Commands](#miscellaneous-commands)
        - [Clearing all Entries](#clearing-all-entries--clear)
        - [Exiting the Program](#exiting-the-program--exit)
    - [Storage & Data](#storage--data)
        - [Saving the Data](#saving-the-data)
        - [Editing the Data](#editing-the-data-file)
- [FAQ](#faq)
- [Known Issues](#known-issues)
- [Command Summary](#command-summary)

--------------------------------------------------------------------------------------------------------------------
## Introduction to the User Guide
Our team at InternHub have carefully designed this user guide to be your one-stop solution for everything related to InternHub !

### Icons used

| Icons                               | Representation                                |
|-------------------------------------|-----------------------------------------------|
| <box type="info" seamless></box>    | Additional useful information                 |
| <box type="warning" seamless></box> | Provides warnings on some potential errors    |
| <box type="tip" seamless></box>     | Nifty tricks to make your experience smoother |

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Check Java Version & Install Java
    - For this application, your system is required to have Java 11 installed
    - To check if you have Java installed, open your command prompt or terminal and type : `java -version`
        - If Java is installed, you will see the version number in the output :
        - <img src="images/quickstart/java-installation.png" >
    - If Java is not installed or your version does not match as the output above :
        - Visit the Official [Oracle website](https://www.oracle.com/java/technologies/downloads/#java11) to download jdk-11 & follow the download instructions
        - For **mac** users, download the jdk-11 from [here](https://www.azul.com/downloads/?version=java-11-lts&os=macos&architecture=arm-64-bit&package=jdk-fx#zulu)

2. Download the latest `internhub.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your InternHub.
    - The home folder will serve as InternHub's central location
    - This folder is where InternHub will keep all its important files and saved data

4. Once you have set up the _home folder_, right-click on the _home folder_ and click copy to copy the path to this directory.

5. Open up a new terminal or command prompt window

6. Type `cd ` and paste the _home folder_ path, your command should look something like this : `cd /Users/john/home folder`, then hit enter.

7. Now in the same command prompt or terminal window, enter the `java -jar internhub.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/UserGuide/Ui_new.png)

8. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    * `list` : Lists all contacts.

    * `add c/Food Panda p/12345678 e/panda@food.com a/CBD t/F jd/Front End Intern d/15-04-2024 0900 id/6 months s/500
      ` : Adds a contact named `Food Panda` to the Address Book.

    * `delete 3` : Deletes the 3rd contact shown in the current list.

    * `clear` : Deletes all contacts.

    * `exit` : Exits the app.

9. Refer to the [Features](#features) for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Getting familiar with the UI of InternHub

![Ui](images/UserGuide/GUI_annotation.png)

- **Command Box**
    - This is where you enter the commands !
- **Result Display**
    - The output message after each command is displayed here
- **List of Contacts**
    - The panel displays list of all internship company contacts
- **View Panel**
    - The panel displays the internship company contact card

--------------------------------------------------------------------------------------------------------------------

## Features

<box type="info" seamless>

**Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add c/COMPANY_NAME`, `COMPANY_NAME` is a parameter which can be used as `add c/Food Panda`.

* Items in square brackets are optional.<br>
  e.g `c/COMPANY_NAME [a/ADDRESS]` can be used as `c/Food Panda a/CBD` or as `c/Food Panda`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `add c/COMPANY_NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER add c/COMPANY_NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
  </box>

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/UserGuide/helpMessage.png)

Format: `help`

--------------------------------------------------------------------------------------------------------------------

## Basic Commands

### Adding a contact: `add`

To add a internship contact to your address book, follow these simple steps:

1. Type `add` followed by the details of the contact you want to add.
2. Use `c/` for the company name, `p/` for the phone number, `e/` for the email, `a/` for the address, `t/` for tags, `jd/` for job description, `d/` for interview date, `id/` for intern duration, `s/` for salary and `n/` for note.

Format: `add c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL a/[ADDRESS] t/TAG jd/JOB_DESCRIPTION d/[INTERVIEW_DATE] id/INTERN_DURATION s/salary n/[NOTE]`

<box type="tip" seamless> heheh

</box>

Examples:
* `add c/FoodPanda p/12345678 e/panda@food.com a/CBD t/F jd/Front End Intern d/15-04-2024 0900 id/6 months s/500`
* `add c/Shoppa p/99912345 e/panda@food.com t/F jd/Software Developer Intern  id/6 months s/500`


### Deleting a contact : `delete`

Deletes the specified contact from the address book.

Format: `delete INDEX`

* Deletes the contact at the specified `INDEX`.
* The index refers to the index number shown in the displayed contact list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd contact in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st contact in the results of the `find` command.


### Editing a contact : `edit`

Edits an existing contact detail in the address book.

Format: `Edit INDEX c/[COMPANY_NAME] p/[PHONE_NUMBER] e/[EMAIL] a/[ADDRESS] t/[TAG] jd/[JOB_DESCRIPTION] d/[INTERVIEW_DATE] id/[INTERN_DURATION] s/[SALARY]`

* Edits the contact at the specified `INDEX`. The index refers to the index number shown in the displayed contact list. 
* The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* For `[INTERVIEW_DATE]`, if you want to remove a date, just enter `d/` and it will remove that field.

Examples:
*  `edit 1 p/91234567 e/foodpanda@example.com` 
* Edits the phone number and email address of the 1st contact to be `91234567` and `foodpanda@example.com` respectively.
*  `edit 2 c/shopee` Edits the company name of the 2nd contact to be `shopee`.

<box type="tip" seamless> If you received an interview invitation from a previously non-responsive company, you can add the interview date with this command: 
`edit 5 t/ I d/14-04-2024 1500`
This will change the tag from No-Reply to Interview and add an Interview time as shown below.

![edit command](images/UserGuide/beforeEditCommand.png)

After receiving an interview date:
![edit command](images/UserGuide/afterEditCommand.png)
</box>


### Viewing a contact : `view`

Views the details of the contact on the view panel in address book.

Format: `View INDEX`

* Views the contact at the specified `INDEX`. The index refers to the index number shown in the displayed contact list. The index **must be a positive integer** 1, 2, 3, …​

Example:
*  `view 3` Displays the company card of the 3rd contact in the list on the view panel.
* **INSERT PICTURE OF view 3 WITH LABEL !**

--------------------------------------------------------------------------------------------------------------------

## Advanced Commands

### Listing all contacts : `list`

Shows a list of all contacts in the address book sorted in ascending order of interview dates. If a company contact does not have any interview dates yet, it will be pushed to the end of the list.

Format: `list`


### Locating contacts by name: `find`

Finds contacts whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `shoppa` will match `Shoppa`
* The order of the keywords does not matter. e.g. `Food Panda` will match `Panda Food`
* Only the name is searched.
* Only full words will be matched e.g. `Shopp` will not match `Shoppa`
* Contacts matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Happy Burger` will return `Happy Meal`, `Burger Queen`

Examples:
* `find Happy` returns `happy` and `Happy Burger`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/UserGuide/findAlexDavidResult.png)


### Adding a Note : `note`

This command will allow you to add & edit notes to an internship company contact. There are 2 ways to execute this command based on your use<br>

Format: `note INDEX`

1. Adding a note when **creating a new company contact**
    - Simply include the note you want in the **add** command using the syntax `n/[NOTE]`
    - `add c/FoodPanda ...other attributes... n/This is a note`

2. Updating a note of an **existing company contact**
    - Suppose you want to edit the note of company contact at index **2**
    - Use the note command as follows : `note 2`
      ![enter note 2](images/note-feature/note_1.png)
    - When you hit enter, it will retrieve the note content of the company contact at index 2 in the command box **as an edit command** :
      ![command executes](images/note-feature/note_2.png)
    - Simply update the note content and hit enter again :
      ![command executes](images/note-feature/note_3.png)
    - The next time you view the contact, the note section will be updated :
      ![command executes](images/note-feature/note_4.png)


<box type="tip" seamless>

To clear a note, simply use `edit INDEX n/`

</box>


<box type="warning" seamless>

**Caution:**
If you use `edit INDEX n/your updates for the new note`, this **WILL OVERWRITE** the old note of the company contact at `INDEX`<br>
For these kinds of scenarios, make use of the `note INDEX` function !

</box>

### Filtering the data (by tags) : `filter`

Filtering data allows you to narrow down your search results to focus on specific criteria. Use the `filter t/` command to filter by tag and find exactly the internships that have an interview.


Format: `filter t/ I`

### Sending reminders : `reminder`

Sending reminders is a pivotal practice to uphold organization and ensure timely completion of crucial tasks. 
Although our application presently lacks a built-in reminder feature, fear not! 
You can effortlessly retrieve reminders manually using this command. 
It conveniently displays the interviews scheduled within the upcoming N days, 
keeping you well-prepared and on track.

Format: `reminder INT`

Examples:
- `reminder 0`
- Shows you the interviews you have today.
- `reminder 2`
- Shows you the interviews you have in the next two days, including today.

![reminder command](images/UserGuide/reminderCommand.png)

<box type="tip" seamless> 
This is a quick and easy way to be reminded of the upcoming interviews in order to not miss them.
</box>





--------------------------------------------------------------------------------------------------------------------

## Miscellaneous Commands

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

--------------------------------------------------------------------------------------------------------------------

## Storage & Data

### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

**Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the AddressBook to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.

</box>

--------------------------------------------------------------------------------------------------------------------
## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous InternHub home folder.

**Q**: What is a home folder?<br>
**A**: The home folder is the main directory associated with a user account on a computer. It typically contains user-specific settings, documents, downloads, and other personal files.

**Q**: Does the user know how to open the command terminal/how to change directory (cd) into a folder?<br>
**A**: Users should refer to the documentation or help resources specific to their operating system for instructions on opening a command terminal and navigating to a directory using the `cd` command.

**Q**: How do I run internhub.jar?<br>
**A**: You can run internhub.jar by opening a command terminal, navigating to the directory containing the jar file using the `cd` command, and then typing `java -jar internhub.jar` and pressing Enter.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action       | Format, Examples                                                                                                                                                                                                                                           |
|--------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**      | `add c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL a/[ADDRESS] t/TAG jd/JOB_DESCRIPTION d/[INTERVIEW_DATE] id/INTERN_DURATION s/salary` <br> e.g., `add c/FoodPanda p/12345678 e/panda@food.com a/CBD t/F jd/Front End Intern d/15-04-2024 0900 id/6 months s/500` |
| **Clear**    | `clear`                                                                                                                                                                                                                                                    |
| **Delete**   | `delete INDEX`<br> e.g., `delete 3`                                                                                                                                                                                                                        |
| **Edit**     | `Edit INDEX c/[COMPANY_NAME] p/[PHONE_NUMBER] e/[EMAIL] a/[ADDRESS] t/[TAG] jd/[JOB_DESCRIPTION] d/[INTERVIEW_DATE] id/[INTERN_DURATION] s/[salary]`<br> e.g.,`Edit 2 p/9998765`                                                                           |
| **Find**     | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find foodpanda`                                                                                                                                                                                                  |
| **Note**     | `note INDEX`                                                                                                                                                                                                                                               |
| **List**     | `list`                                                                                                                                                                                                                                                     |
| **View**     | `view INDEX`<br> e.g., `view 3`                                                                                                                                                                                                                            |
| **Help**     | `help`                                                                                                                                                                                                                                                     |
| **Find**     | `find STRING`<br> e.g., `find Grab`                                                                                                                                                                                                                        |
| **Filter**   | `filter t/ I`                                                                                                                                                                                                                                              |
| **Reminder** | `reminder`                                                                                                                                                                                                                                                 |
