---
layout: default.md
title: "User Guide"
pageNav: 3
---

# Internhub User Guide

## Welcome to InternHub!

Are you currently navigating the intricate maze of internship opportunities as an undergraduate? 
Your search ends here! InternHub is poised to transform the way you handle your internship contacts.

InternHub stands as a beacon of productivity, offering you a comprehensive platform to manage and organize all your internship applications effectively.

## User Guide: Your Trusted Companion

This User Guide (UG) acts as your trusted companion, providing a wealth of information to assist you in understanding and harnessing the full potential of our application. 
From installation to usage and navigation, each step is meticulously outlined to ensure you derive maximum benefits from InternHub in managing your internship contacts.

## Who Can Benefit from InternHub?

InternHub caters to **undergraduates from all fields**, providing them with a seamless and efficient approach to managing their internship contacts.
**Professors and career guidance officers**, we invite you to share this invaluable resource with your students, empowering them to secure their dream internships.

InternHub is designed with **user-friendliness** in mind, catering to individuals with varying levels of computer experience.
Whether you're a tech-savvy enthusiast or just dipping your toes into the world of desktop applications, rest assured that our interface is intuitive and easy to navigate.
We're committed to supporting you every step of the way on your internship management journey.

Welcome aboard, and let's embark on this exciting adventure together!

## Get Started

For users who are **new to InternHub**, click [here](#introduction-to-the-user-guide) for a helpful starting point!

Experienced users can jump straight to exploring our [features](#features)!

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## Table of Contents {:style="font-size: 1.5em;"}
- [Introduction](#introduction-to-the-user-guide)
- [Quick Start](#quick-start)
- [Getting Familiar with UI](#getting-familiar-with-the-ui-of-internhub)
- [Features](#features)
    - [Help](#viewing-help-help)
    - [Basic Commands](#basic-commands)
        - [Adding a Contact](#adding-a-contact-add)
        - [Deleting a Contact](#deleting-a-contact-delete)
        - [Editing a Contact](#editing-a-contact-edit)
        - [Viewing a Contact](#viewing-a-contact-view)
    - [Advanced Commands](#advanced-commands)
        - [Listing all Contacts](#listing-all-contacts-list)
        - [Locating Contacts by Name](#locating-contacts-by-name-find)
        - [Updating a Note](#updating-a-note-note)
        - [Filter Contacts by Tags](#filter-by-tag-filter)
        - [Sending Reminders](#sending-reminders-reminder)
    - [Miscellaneous Commands](#miscellaneous-commands)
        - [Clearing all Entries](#clearing-all-entries-clear)
        - [Exiting the Program](#exiting-the-program-exit)
    - [Storage & Data](#storage-and-amp-data)
        - [Saving the Data](#saving-the-data)
        - [Editing the Data](#editing-the-data-file)
- [FAQ](#faq)
- [Known Issues](#known-issues)
- [Command Summary](#command-summary)
- [Glossary](#glossary)

<div style="page-break-after: always;"></div>


--------------------------------------------------------------------------------------------------------------------
## Introduction to the User Guide
Our team at InternHub have carefully designed this user guide to be your one-stop solution for everything related to InternHub!

### Icons used

<box type="info" >Additional useful information</box>
<box type="warning" >Provides warnings on some potential errors</box>
<box type="tip" >Nifty tricks to make your experience smoother</box>

--------------------------------------------------------------------------------------------------------------------

## Quick Start
1. **Check Java Version & Install Java**
    - Ensure that your system has Java 11 installed, as this application requires it.
    - To check if Java is installed, open your command prompt or terminal and type: `java -version`
        - If Java is installed, you will see the version number in the output.
        - If Java is not installed or your version does not match the required one, follow these steps:
            - Visit the Official [Oracle website](https://www.oracle.com/java/technologies/downloads/#java11) to download JDK 11 and follow the installation instructions.
            - For **mac** users, download JDK 11 from [here](https://www.azul.com/downloads/?version=java-11-lts&os=macos&architecture=arm-64-bit&package=jdk-fx#zulu).

2. **Download InternHub**
    - Download the latest `internhub.jar` from [here](https://github.com/AY2324S2-CS2103T-F14-1/tp/releases).

3. **Set Up Home Folder**
    - Copy the downloaded `internhub.jar` file to the folder you want to use as the home folder for InternHub.
        - This folder will serve as InternHub's central location, where all important files and saved data will be stored.

4. **Navigate to Home Folder**
    - Once you've set up the home folder, right-click on it and select "Copy" to copy its path.

5. **Open Terminal or Command Prompt**
    - Open a new terminal or command prompt window.

6. **Change Directory to Home Folder**
    - Type `cd ` and paste the home folder path you copied earlier. For example: `cd /Users/john/home folder`, then press Enter.

7. **Run InternHub**
    - In the same terminal or command prompt window, enter the command `java -jar internhub.jar` to run the application.
        - A GUI similar to the one below should appear shortly.
        - ![InternHub GUI](images/UserGuide/Ui_new.png)

8. **Execute Commands**
    - Type commands into the command box and press Enter to execute them. For example, typing `help` and pressing Enter will open the help window.
    - Sample commands to try:
        - `list`: [Lists](#listing-all-contacts-list) all company contacts.
        - `add c/Pixar ...`: [Adds](#adding-a-contact-add) a company contact named `Pixar` to InternHub.
        - `delete 3`: [Deletes](#deleting-a-contact-delete) the 3rd contact shown in the current list.
        - `clear`: [Clears](#clearing-all-entries-clear) all contacts.
        - `exit`: [Exits](#exiting-the-program-exit) the app.

9. **Explore Features**
    - For more details on each command, refer to the [Features](#features) section.

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## Getting familiar with the UI of InternHub

![Ui](images/UserGuide/GUI_annotation.png)

- **Command Box**
    - Enter your commands in this box.
- **Result Display**
    - View the output message after each command here.
- **List of Contacts**
    - This panel displays a list of all internship company contacts.
- **View Panel**
    - The contact details card of the selected internship company is displayed in this panel.

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## Features

<box type="info">

**Important Notes on Command Formatting:**<br>

* Parameters in `UPPER_CASE` are user-supplied.<br>
  For example, in `add c/COMPANY_NAME`, replace `COMPANY_NAME` with the actual company name like `add c/Food Panda`.

* Square brackets denote optional items.<br>
  For instance, `c/COMPANY_NAME [a/ADDRESS]` can be entered as `c/Food Panda a/CBD` or simply `c/Food Panda`.

* Parameters can be in any order.<br>
  For example, if a command specifies `add c/COMPANY_NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER add c/COMPANY_NAME` is also valid.

* Unnecessary parameters for commands without specified inputs (e.g., `help`, `list`, `exit`, and `clear`) are ignored.<br>
  For instance, `help 123` will be treated as `help`.

* When copying and pasting multi-line commands from a PDF, be cautious as space characters around line breaks might be omitted.
  </box>

## Understanding Each Parameter
| Parameter | Description         | Constraints                                                                                         | Example                          | Required |
|-----------|---------------------|-----------------------------------------------------------------------------------------------------|----------------------------------|----------|
| `c/`      | Company Name        | Only contain alphanumeric values                                                                    | `c/ABC Corporation`              | Yes      |
| `p/`      | Phone Number        | Only contain numbers and at least 3 digits                                                          | `p/98765432`                     | Yes      |
| `e/`      | Email Address       | Should be of the format local-part@domain, multiple consecutive special characters are not allowed. | `e/example@example.com`          | Yes      |
| `t/`      | Tags                | Valid values are NR, I, O, OA, R                                                                    | `t/NR`                           | Yes      |
| `jd/`     | Job Description     | -                                                                                                   | `jd/Software Developer Intern`   | Yes      |
| `id/`     | Internship Duration | -                                                                                                   | `id/3 months`                    | Yes      |
| `s/`      | Salary              | Only positive numbers                                                                               | `s/500`                          | Yes      |
| `a/`      | Physical Address    | -                                                                                                   | `a/123 Main St, City, Country`   | No       |
| `d/`      | Interview Date      | Of format dd-mm-yyyy HHmm & cannot be earlier than current day                                      | `d/14-04-2024 1500`              | No       |
| `n/`      | Notes               | -                                                                                                   | `n/Previous experience required` | No       |


### Company Name

For company names with special characters, it's advisable to omit them or replace them with spaces. 

Here are some examples:
- "7-Eleven" can be inputted as "7 Eleven" instead.
- "ABC PTE LTD." can be inputted as "ABC PTE LTD" or "ABC Private Limited."
- "ABC Co., Ltd" can be inputted as "ABC Co LTD" or "ABC Company Limited."

Please note that company names are case-sensitive.
<br> This means variations in capitalization, such as "Apple" and "apple," will be treated as separate entries. 

To maintain data consistency and accuracy, we encourage users to adhere to the correct capitalization when entering company names.
This helps prevent unintentional duplication and ensures each company is uniquely identified within the system.
<br> For example, if you've entered a company name as "Apple," ensure you consistently use the same capitalization in future entries related to that company.

### Phone Number

In InternHub, we aim to provide flexibility to users without imposing overly strict restrictions.
<br> Therefore, we allow duplicate phone numbers to be entered for different contacts.

### Email

For emails with special characters, multiple consecutive special characters are not allowed.
<br> Here's an example of a valid email: `abc+company@example.com`.
<br> An invalid email example would be `abc+_company@example.com`.

### Tags

Ensure to include the appropriate tag after `t/` to denote the status of the internship application:

- **NR (No Reply):** Indicates no response from the company regarding the internship application.
- **I (Interview):** Signifies an interview scheduled for the internship with the company.
- **O (Offered):** Indicates receipt of an internship offer from the company.
- **OA (Online Assessment):** Denotes requirement of an online assessment or test.
- **R (Rejected):** Indicates rejection of the internship application by the company.

When using tags to denote the status of internship applications, ensure you use **UPPERCASE** for the tags.
<br> Incorrect usage may result in misinterpretation of the application status.
<br> For example, the correct format is `t/I`.

<box type="info">

Each contact is uniquely identified by the combination of **Company Name** and **Job Description**
- You **can** have more than 1 internship application with the same company name but **different** job descriptions
  InternHub allows users to have more than one entry associated with the same company name, as long as each entry has a different job description. This flexibility accommodates scenarios where individuals may apply to different positions within the same company.
- You **cannot** have more than 1 contact with the same company name **and** same job description.
  <br> This restriction ensures data accuracy and prevents duplication of contacts with identical roles within the same company.
- Example of Allowed Internship Applications:
  <br> Internship application 1: Company Name - ABC Corp, Job Description - Software Engineer
  <br> Internship application 2: Company Name - ABC Corp, Job Description - Marketing Specialist

- Example of Not Allowed Input:
  <br> Internship application 1: Company Name - ABC Corp, Job Description - Software Engineer
  <br> Internship application 2: Company Name - ABC Corp, Job Description - Software Engineer

</box>


### Viewing help : `help`

To access our InternHub User Guide, simply type help into the command box and press Enter. 
This action will display a link to this document, allowing you to easily navigate and explore the comprehensive features of InternHub.

<box>

**Format:** `help`

</box>

<box type="tip"> 

You can also execute this command by using the `F1` key on your keyboard.

</box>

**Expected Outcome**

A separate help window will appear.

![help message](images/UserGuide/helpMessage.png)

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## Basic Commands

### Adding a contact: `add`

Add a new internship company contact into InternHub.

<box>

**Format:** `add c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL t/TAG jd/JOB_DESCRIPTION id/INTERN_DURATION s/SALARY [a/ADDRESS] [d/INTERVIEW_DATE] [n/NOTE]`

</box>

<box type="warning">

All fields are unable to handle multiple inputs.

Example of correct format: `add c/Happy Burger p/98765432 e/HappyBurger@example.com a/311, Clementi Ave 2, #02-25 t/I jd/Software Developer intern d/29-03-2024 1200 id/3 months s/1000 n/Company CEO is John Doe`
<br> This internship application will be added in InternHub successfully.

Example of incorrect format: `add c/Happy Burger p/98765432 e/HappyBurger@example.com a/311, Clementi Ave 2, #02-25 t/I jd/Software Developer intern d/29-03-2024 1200 id/3 months s/1000 n/Company CEO is John Doe`**`n/Company has 500 employee`**
<br> An error message _"Multiple values specified for the following single-valued field(s): n/"_ will be shown on the result display box. 

</box>


<div style="page-break-after: always;"></div>

**Example 1:**

- This example represents an application for a Creative Design Internship position at MediaCorp.
- The tag t/I indicates that **an interview has been scheduled** with the company.
- The notes section provides additional information about Mediacorp and suggests topics for discussion during the interview.

We have provided the command below with all parameters provided, including the optional parameters:

`
add c/MediaCorp p/12345678 e/jobs@mediacorp-digital.com a/321 Media Lane, Singapore 238163 t/I jd/Creative Design Intern d/11-06-2024 0900 id/3 months s/1000 n/Be prepared to discuss current trends in the media industry and how Mediacorp is adapting to digital transformation.
`

**Expected Outcome**

![add command example 1](images/UserGuide/addCommandExample1.png)

<div style="page-break-after: always;"></div>

**Example 2:**

- This example represents an application for a Junior Animator Internship position at Pixar.
- The tag t/O indicates that an **offer has been received** from the company.
- Optional parameters such as the address, interview date, and notes are omitted, demonstrating that their absence does not impact the completeness of this command.

We have provided the command below with only the necessary parameters provided, excluding the optional parameters:

`add c/Pixar p/98765432 e/Pixar@example.com t/O jd/Junior Animator intern id/3 months s/1000`

**Expected Outcome**

![add command example 2](images/UserGuide/addCommandExample2.png)

**More examples for you to try out:**
- `add c/Grab p/66550000 e/careers@grab.com a/6 Temasek Boulevard t/I jd/Software Developer Intern d/12-06-2024 0900 id/6 months s/1500 n/Grab offers various services like ride-sharing, food delivery and etc.`

- `add c/Happy Burger p/98765432 e/HappyBurger@example.com a/311, Clementi Ave 2, #02-25 t/NR jd/Software Developer intern id/3 months s/1000`

- `add c/DBS Bank p/12345678 e/areers@dbs-bank-online.com a/321 Media Lane, Singapore 238163 t/NR jd/Creative Design Intern id/3 months s/1000`

<div style="page-break-after: always;"></div>

### Deleting a contact : `delete`

Deletes an internship company contact by index from InternHub.

<box>

**Format:** `delete INDEX`

</box>

* Deletes the contact at the specified `INDEX`.
* The index refers to the index number shown in the displayed contact list.
* The index **must be a positive integer** 1, 2, 3, …​

**Example 1:**

`list` followed by `delete 2` deletes the 2nd contact.

**Expected outcome**

After we execute the delete command, the Grab entry is no longer in our list of contacts.

![delete_example_full](images/UserGuide/deleteExample.png)

### Editing a contact : `edit`

Edits an existing internship company contact detail in InternHub.

1. Begin by typing `edit`, followed by the `INDEX` of the application. The index refers to the index number shown in the displayed contact list.
2. Next, include only specific prefix for the fields of the contact you wish to edit in your records. 
   **At least one** of the optional fields must be provided and at most one of each field can be provided.
3. After pressing enter, existing values will be updated to the input values.

<box>

**Format:** `Edit INDEX [c/COMPANY_NAME] [p/PHONE_NUMBER] [e/EMAIL] [t/TAG] [jd/JOB_DESCRIPTION] [id/INTERN_DURATION] [s/SALARY] [a/ADDRESS] [d/INTERVIEW_DATE] [n/NOTE]`

</box>

<box type="warning">

When you edit any field with a new value, this will **OVERWRITE** the old value!

</box>

<div style="page-break-after: always;"></div>

<box type="tip">

If you want to delete any of the **Optional** fields, you can use edit like so:
- `edit 2 d/` will remove the **interview date** of company at index 2.
- `edit 2 a/` will remove the **address** of company at index 2.
- `edit 2 n/` will remove the **note** of company at index 2.

</box>

<box type="warning">

All fields are unable to handle multiple inputs.

Example of correct format: `edit 1 n/Company CEO is John Doe`
<br> We update the 1st internship application's note.

Example of incorrect format: `edit 1 n/Company CEO is John Doe`**` n/Company has 500 employee`**
<br> An error message _"Multiple values specified for the following single-valued field(s): n/"_ will be shown on the result display box.

</box>

**Example 1**
- We've received confirmation of an online assessment from a previously unresponsive company, DBS Bank.
- We want to do the following:
  - Change the status from "NR" to "OA"
  - Set the online assessment date for DBS Bank contact to be 20 June 2024 at 9 am.

With the edit command, we can achieve this with the following command: 

`edit 4 t/OA d/20-06-2024 0900`

**Example 2**
- Unfortunately, we've received a rejection email from Happy Burger.
- We want to do the following:
    - Change the status from "NR" to "R"

With the edit command, we can achieve this with the following command:

`edit 3 t/R`

The image below shows the respective outcomes after executing both edit commands: 

![edit_example](images/UserGuide/edit_example.png)

<box type="info">

Notice how when we set the online assessment date for DBS, the contact list dynamically rearranged to prioritize the latest interview at the top.
<br> This dynamic sorting is based on the first interview date.

</box>

<div style="page-break-after: always;"></div>

### Viewing a contact : `view`

Views the details of the internship company contact on the view panel in InternHub.

<box>

**Format:** `view INDEX`

</box>

* Views the contact at the specified `INDEX`. 
* The index refers to the index number shown in the displayed contact list. 
* The index **must be a positive integer** 1, 2, 3, …​

**Example:**

*  `view 1` Displays the company card of the 1st contact in the list on the view panel.

![view result 3](images/view/view1Result.png)

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## Advanced Commands

### Listing all contacts : `list`

This command shows a list of all internship application contacts in InternHub sorted in ascending order of interview dates.
Internship application contacts with interview dates will be listed first, followed by internship application contacts without interview dates.

<box>

**Format:** `list`

</box>

**Expected Outcome**

All internship application contacts will be shown on the left side of the window.

![list](images/UserGuide/list.png)

<div style="page-break-after: always;"></div>

### Locating contacts by name: `find`

Finds contacts whose company names contain any of the given keywords.

<box>

**Format:** `find KEYWORD [MORE_KEYWORDS]`

</box>

* All matching results of the find will be displayed in your view panel. 
* The search is case-insensitive. e.g `shoppa` will match `Shoppa`.
* The order of the keywords does not matter. e.g. `Food Panda` will match `Panda Food`.
* Only the name is searched.
* Only full words will be matched e.g. `Shopp` will not match `Shoppa`, `Food Panda` will not match `FoodPanda`.
* Contacts matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Happy Burger` will return `Happy Meal`, `Burger Queen`.

Examples:
* `find burger` returns `Happy Burger` and `Sad Burger`<br>.
  ![result for 'find burger'](images/find/findBurgerResult.png)


### Updating a Note : `note`

This command will allow you to update the notes of a company contact without overwriting them.

<box>

**Format:** `note INDEX`

</box>

Updating a note of an **existing company contact**
- Suppose you want to edit the note of company contact at index **2**
- Use the note command as follows: `note 2`
  ![enter note 2](images/note-feature/note_1.png)

- When you hit enter, it will retrieve the note content of the company contact at index 2 in the command box **as an edit command**:
  ![command executes](images/note-feature/note_2.png)

- Simply update the note content and hit enter again:
  ![command executes](images/note-feature/note_3.png)

- The next time you view the contact, the note section will be updated:
  ![command executes](images/note-feature/note_4.png)


<div style="page-break-after: always;"></div>

### Filter By Tag : `filter`

Filtering data allows you to narrow down your search results to focus on internship contacts based on their status. 
Use the `filter` command to filter by tag and find exactly the internships that have an interview.

<box>

**Format:** `filter VALID TAG`

</box>

<box type="info">

Valid Tag Inputs   
- NR: No Reply
- I: Interview
- O: Offered
- OA: Online Assessment
- R: Rejected

</box>

**Example:**

- `filter i` or `filter I`
- Filters the contact list to display only internship company contacts with an Interview status

![resultFilter](images/filter/filterIResult.png)

<div style="page-break-after: always;"></div>

### Sending reminders : `reminder`

Sending reminders is a pivotal practice to uphold organization and ensure timely completion of crucial tasks. 
Although our application presently lacks a built-in reminder feature, fear not! 

You can effortlessly retrieve reminders manually using this command. 
It conveniently displays the interviews scheduled within the upcoming N days, keeping you well-prepared and on track.

<box>

**Format:** `reminder INT`

</box>

**Examples:**
- `reminder 0` : Shows you the interviews you have today.
- `reminder 2` : Shows you the interviews you have in the next two days, including today.
- `reminder 20` : Shows you the interviews you have in the next twenty days, including today.

![reminder command](images/UserGuide/reminderCommand.png)

<box type="tip"> 
This is a quick and easy way to be reminded of the upcoming interviews in order to not miss them.
</box>

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## Miscellaneous Commands

### Clearing all entries : `clear`

Clears all entries stored in InternHub.

<box>

**Format:** `clear`

</box>

### Exiting the program : `exit`

Exits the program.

<box>

**Format:** `exit`

</box>

--------------------------------------------------------------------------------------------------------------------

## Storage & Data

### Saving the data

InternHub data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

InternHub data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning">

**Caution:**
If your changes to the data file makes its format invalid, InternHub will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the InternHub to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.

</box>

--------------------------------------------------------------------------------------------------------------------
## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the InternHub app on the other computer and replace the empty data file it creates with the file containing the data from your previous InternHub *home folder*.

**Q**: What is a home folder?<br>
**A**: A home folder is the main directory associated with a user account on a computer. It typically contains user-specific settings, documents, downloads, and their personal files. Here is an example using the user name "internGuy" on a Unix-like system: `/home/internGuy`. On a Windows sytem, `C:\users\internGuy`.

**Q**: Why is the app not running?<br>
**A**: Ensure that JDK `11` or above is installed.

**Q**: Does the user know how to open the command terminal/how to change directory (cd) into a folder?<br>
**A**: Users should refer to the documentation or help resources specific to their operating system for instructions on opening a command terminal and navigating to a directory using the `cd` command.

**Q**: How do I run internhub.jar?<br>
**A**: You can run internhub.jar by opening a command terminal, navigating to the directory containing the jar file using the `cd` command, and then typing `java -jar internhub.jar` and pressing Enter.

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## Known Issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

2. **When entering numbers greater than 2147483647 (maximum Integer value)** for commands e.g. reminder 100000000000, the input will be considered invalid as we assumed that most users will not encounter this issue in normal usage. A solution could be added in a future iteration. 

3. **Inconsistent UI tag colour**, currently InternHub permits users to input tags in lowercase, resulting in unfilled tag colors. For our future implementation, we intend to either display a warning to users when they use lowercase instead of uppercase for tags, or automatically convert the tag value to uppercase.

4. **Company name is case-sensitive**, this make it possible for user to input "Apple" and "apple" in our application. It is possible that both input refer to the same company and may lead to potential confusion. For our future implementation, we intend to make company name case-insensitive.

5. **Phone numbers allow duplicates**: We did not want to set high restrictions in our application, hence did not force users to ensure all phone numbers must be unique. From user feedback, duplicate phone numbers can lead to potential confusion, especially when managing large contact lists. A solution could be added in a future iteration.


--------------------------------------------------------------------------------------------------------------------

## Command Summary

| Action       | Format, Examples                                                                                                                                                                                                                                                        |
|--------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**      | `add c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL a/[ADDRESS] t/TAG jd/JOB_DESCRIPTION d/[INTERVIEW_DATE] id/INTERN_DURATION s/SALARY n/[NOTE]` <br> e.g., `add c/FoodPanda p/12345678 e/panda@food.com a/CBD t/I jd/Front End Intern d/15-04-2024 0900 id/6 months s/500 n/-` |
| **Clear**    | `clear`                                                                                                                                                                                                                                                                 |
| **Delete**   | `delete INDEX` e.g., `delete 3`                                                                                                                                                                                                                                         |
| **Edit**     | `Edit INDEX c/[COMPANY_NAME] p/[PHONE_NUMBER] e/[EMAIL] a/[ADDRESS] t/[TAG] jd/[JOB_DESCRIPTION] d/[INTERVIEW_DATE] id/[INTERN_DURATION] s/[SALARY] n/[NOTE]`<br> e.g.,`Edit 2 p/99987654`                                                                              |
| **Find**     | `find KEYWORD [MORE_KEYWORDS]`e.g., `find foodpanda`                                                                                                                                                                                                                    |
| **Note**     | `note INDEX`                                                                                                                                                                                                                                                            |
| **List**     | `list`                                                                                                                                                                                                                                                                  |
| **View**     | `view INDEX` e.g., `view 3`                                                                                                                                                                                                                                             |
| **Help**     | `help`                                                                                                                                                                                                                                                                  |
| **Filter**   | `filter VALID _TAG` e.g., `filter I`                                                                                                                                                                                                                                    |
| **Reminder** | `reminder INT`                                                                                                                                                                                                                                                          |

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## Glossary

| Term                              | Meaning                                                                                                                                                                 |
|-----------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Java Version                      | A programming language and computing platform used for the InternHub application. Version 11 or higher is required for proper functioning.                              |
| Terminal or Command Prompt        | Command-line interfaces used to interact with the operating system and run commands.                                                                                    |
| Result Display                    | Area where outputs and messages from InternHub are displayed.                                                                                                           |
| View Panel                        | Area displaying detailed information of the selected internship company contact.                                                                                        |
| Features                          | Functionalities provided by InternHub, including adding, editing, deleting, and filtering contacts                                                                      |
| Command                           | A directive given to the program to perform a specific task                                                                                                             |
| GUI (Graphical User Interface)    | A visual way of interacting with a computer through graphical elements like windows, icons, buttons & menus                                                             |
| Index                             | A numerical identifier used to specify the position of an item in a list, for this context the position of an internship company contact                                |
| JSON (JavaScript Object Notation) | A lightweight data interchange format that is easy to read & write, and for machines to parse. InternHub uses JSON to store and manage data                             |
| CLI (Command Line Interface)      | A way to interact with a computer by typing commands into a terminal or command box                                                                                     |
| Prefix                            | A string of characters placed at the beginning of a command to indicate its type. For example, InternHub uses `c/` for company name and `p/` for phone number and so on |
| Field                             | A specific piece of information within each internship company contact like company name, phone number & etc...                                                         |

