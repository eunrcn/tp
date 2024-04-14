---
layout: default.md
title: "User Guide"
pageNav: 3
---

# InternHub User Guide
_By F14-1, JAYME_

# 1. Welcome to InternHub!

**Attention all undergraduates!** <br>
Are you tirelessly navigating the labyrinth of internship opportunities? 
Ever found yourself frustrated by inadvertently applying to the same company twice? 
Losing track of all the different interview dates? 
Amidst all of your applications from various websites, it's easy to lose track. 
But fear not – we've got your back.

Introducing InternHub – your ultimate desktop solution for streamlining internship application tracking. 
Bid farewell to the chaos and embrace a seamless journey towards your dream internship. 

## 1.1 Who can benefit from InternHub?

InternHub caters to **undergraduates from all fields**, providing them with a seamless and efficient approach to managing their internship contacts.<br>

**For professors and career guidance officers** reading this, we invite you to share this invaluable resource with your students, empowering them to secure their dream internships.

InternHub is meticulously crafted with **user-friendliness** at its core, tailored to accommodate individuals of all computer proficiency levels. 
Whether you're a experienced or just starting to explore desktop applications, our interface ensures a seamless experience, intuitively guiding you through every step of your internship management journey. 
With InternHub's sleek Command Line Interface (CLI), navigation and management become effortless, empowering you to stay focused on your goals.

Unlock the power to focus on what truly matters – securing that coveted internship – with InternHub by your side.

## 1.2 Eager to skip ahead?

For users who are **new to InternHub**, click [here](#2-getting-started) for a helpful starting point!

Experienced users can jump straight to exploring our [features](#4-features)!

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------
<page-nav-print />

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

# 2. Getting Started

## 2.1 Check Java Version & Install Java

1. For this application, your system is required to have Java 11 or above installed.
2. To check if you have Java installed, open your command prompt or terminal and type: `java -version`.
3. If Java is installed, you will see the version number in the output: <br>
<img src="images/quickstart/java-installation.png" >
4. If Java is not installed or if your version is not Java 11 or above, visit the Official [Oracle website](https://www.oracle.com/java/technologies/downloads/#java11) to download jdk-11 & follow the download instructions.

## 2.2 Downloading InternHub
1. Download the latest `internhub.jar` [here](https://github.com/AY2324S2-CS2103T-F14-1/tp/releases/latest). 
  This jar file contains our entire application, isn't it cool?
2. After clicking on `internhub.jar`, it will go to your Downloads folder.
3. Then, you can copy and paste the file to a folder you want to use as the _home folder_ for your InternHub.

<box type="info" > 

The _home folder_ will serve as InternHub's central location, it is where InternHub will keep all its important files and saved data.

</box>

<box type="tip" > 

You can create a _home folder_ named "internhub" and store the jar file inside it, making it easy to find in the future.

</box>

## 2.3 Running InternHub

1. Once you have created the _home folder_, right-click on the _home folder_ and click `copy/copy as path` to copy the path to this folder.
2. Open up a new terminal or command prompt window.
3. Type `cd` and paste the copied text, your command should look something like this: `cd /Users/jayme/home_folder`, then hit enter.
4. Now in the same command prompt or terminal window, enter the `java -jar internhub.jar` command to run the application.
5. A beautiful pink-blue-orange interface similar to the one below should appear in a few seconds.
![Ui](images/UserGuide/Ui_new.png)

<box type="info" > 

The beautiful colours on our InternHub interface is best viewed in full screen and it contains 1 sample data, FoodPanda.

</box>

<box type="tip" > 

[Only for Mac users]
If you encounter any issues copying the path to the directory, you can drag the folder out to your desktop. 
Then, right-click the folder and select "New Terminal at Folder" to skip steps 1-3.

</box>

## 2.4 And you are all set!
1. Now that you have InternHub running, you can now type commands in the command box and press Enter to execute it. <br> 
e.g. typing **`help`** and pressing Enter will open the help window.
2. Please refer to the [Features](#4-features) for a full detailed list of each command.

--------------------------------------------------------------------------------------------------------------------
# 3. Product Overview

Our team has carefully designed this user guide to be your one-stop solution for everything related to InternHub! 
Our aim is to help you get started with InternHub as quickly as possible. 
The guide features all the available commands, their syntax, as well as specific examples for illustration.

Here in this section, we will be explaining the icons used and providing clear guidance on UI navigation. 
Furthermore, we are providing guidelines for command formatting and contact details in InternHub, along with an understanding of each parameter.

## 3.1 Icons used

<box type="info" >Additional useful information</box>
<box type="warning" >Provides warnings on some potential errors</box>
<box type="tip" >Nifty tricks to make your experience smoother</box>

## 3.2 Understanding InternHub's User Interface

![Ui](images/UserGuide/GUI_annotation_v3.png)

<div style="page-break-after: always;"></div>

**Command Box**
- Enter your commands in this box.

**Result Display**
- View the output message after each command here. 
- For longer commands like `Add`, the text found in the result display box may get cut off. Simply use our pink scroll bar to view the entire output.

**List of Applications**
- This panel displays a list of all internship applications.

**View Panel**
- The contact details card of the selected internship application is displayed in this panel.

## 3.3 Command and Formatting Guidelines

1. **Parameters in `UPPER_CASE` are user-supplied.**<br>
  For example, in `add c/COMPANY_NAME`, replace `COMPANY_NAME` with the actual company name like `add c/Food Panda`.

2. **Square brackets denote optional items.** <br>
  For instance, `c/COMPANY_NAME [a/ADDRESS]` can be entered as `c/Food Panda a/CBD` or simply `c/Food Panda`.

3. **Parameters can be in any order.** <br>
  For example, if a command specifies `add c/COMPANY_NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER add c/COMPANY_NAME` is also valid.

4. **Unnecessary parameters for commands without specified inputs (e.g., `help`, `list`, `exit`, and `clear`) are ignored.** <br>
  For instance, `help 123` will be treated as `help`.

5. **Practice caution when copying command lines from the User Guide**. <br>
  When copying and pasting multi-line commands from a PDF, be cautious as space characters around line breaks might be omitted.

## 3.4 Understanding Each Parameter

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

<div style="page-break-after: always;"></div>

### 3.4.1 Company Name

For company names with **special characters**, it's advisable to omit them or replace them with spaces.

Here are some examples:
- "7-Eleven" can be inputted as "7 Eleven" instead.
- "ABC PTE LTD." can be inputted as "ABC PTE LTD" or "ABC Private Limited".
- "ABC Co., Ltd" can be inputted as "ABC Co Ltd" or "ABC Company Limited".

**Please note that company names are case-sensitive.**
<br> This means variations in capitalization, such as "Apple" and "apple," will be treated as separate entries.

<box type="tip">
To maintain data consistency and accuracy, we encourage users to adhere to the correct capitalization when entering company names.
This helps prevent unintentional duplication and ensures each company is uniquely identified within the system.
<br> For example, if you've entered a company name as "Apple," ensure you consistently use the same capitalization in future entries related to that company.
</box>


### 3.4.2 Phone Number

In InternHub, we aim to provide flexibility to users without imposing overly strict restrictions.
<br> Therefore, we **allow duplicate phone numbers** to be entered for different contacts.

### 3.4.3 Email

For emails with special characters, **multiple consecutive special characters are not allowed**.
<br> Here's an example of a valid email: `abc+company@example.com`.
<br> An invalid email example would be `abc+_company@example.com`.

### 3.4.4 Tags

Ensure to include the appropriate tag after `t/` to denote the status of the internship application:

- **NR (No Reply):** Indicates no response from the company regarding the internship application.
- **I (Interview):** Signifies an interview scheduled for the internship with the company.
- **O (Offered):** Indicates receipt of an internship offer from the company.
- **OA (Online Assessment):** Denotes requirement of an online assessment or test.
- **R (Rejected):** Indicates rejection of the internship application by the company.

When using tags to denote the status of internship applications, you can use both lowercase and UPPERCASE.
<br> For example, either `t/i` or `t/I` will work.

### 3.4.5 Internship Duration

We have intentionally omitted setting a minimum internship duration as there isn't a universally fixed minimum duration for internships.

### 3.4.6 Internship Date

1. **Invalid Date** <br>
  When InternHub encounters an invalid date like "29-02-2031," which doesn't exist because 2031 isn't a leap year, it automatically changes it to the closest valid date, which is "28-02-2031." 
  This happens because the InternHub follows the rules of the Gregorian calendar, which determines how dates are calculated and adjusted.

2. **Overlapping of interview dates and time** <br>
  In InternHub, it's possible to schedule interviews with multiple companies for the same date and time. 
  This flexibility acknowledges that you may have multiple interviews lined up simultaneously, requiring you to choose between them based on your preferences and priorities.

3. **Using JSON file to change the date** <br>
  While we've ensured that when adding or editing an internship application, the interview date cannot precede the current day, we also recognize the importance of allowing deliberate adjustments to past dates. 
  As a result, experienced users have the flexibility to edit interview dates in the JSON file, empowering them to rectify errors and make necessary modifications.

4. **Error messages** 
<br> When entering the command 'edit 3 d/14-07-2024 3", InternHub will display two error messages:
<br> _Interview Date & Time needs to follow this pattern : dd-mm-yyyy HHmm_
<br> _Interview Date & Time cannot be before today's date!_

<box type="tip" >

Please only read the error message that is relevant to your situation. In this case, it is the first line.

</box>

## 3.5 Understanding Contact Identification in InternHub

Each contact is uniquely identified by the combination of **Company Name** and **Job Description**
- You **can** have more than 1 internship application with the same company name but **different** job descriptions
  InternHub allows users to have more than one entry associated with the same company name, as long as each entry has a different job description. This flexibility accommodates scenarios where individuals may apply to different positions within the same company.
- You **cannot** have more than 1 contact with the same company name **and** same job description.
  <br> This restriction ensures data accuracy and prevents duplication of contacts with identical roles within the same company.

<box type="tip" >

1. Example of **Allowed** Internship Applications:
  <br> Internship application 1: Company Name - ABC Corp, Job Description - Software Engineer
  <br> Internship application 2: Company Name - ABC Corp, Job Description - Marketing Specialist

2. Example of **Not Allowed** Internship Applications:
  <br> Internship application 1: Company Name - ABC Corp, Job Description - Software Engineer
  <br> Internship application 2: Company Name - ABC Corp, Job Description - Software Engineer

  </box>

--------------------------------------------------------------------------------------------------------------------
# 4. Features

## 4.1 Basic Commands

### 4.1.1 Adding an internship application: `add`

Add a new internship application into InternHub.

<box>

**Format:** `add c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL t/TAG jd/JOB_DESCRIPTION id/INTERN_DURATION s/SALARY [a/ADDRESS] [d/INTERVIEW_DATE] [n/NOTE]`

</box>

<box type="warning">

All fields are unable to handle multiple inputs.

Example of correct format: `add c/Happy Burger p/98765432 e/HappyBurger@example.com a/311, Clementi Ave 2, #02-25 t/I jd/Software Developer intern d/29-05-2024 1200 id/3 months s/1000 n/Company CEO is John Doe`
<br> This internship application will be added in InternHub successfully.

Example of incorrect format: `add c/Happy Burger p/98765432 e/HappyBurger@example.com a/311, Clementi Ave 2, #02-25 t/I jd/Software Developer intern d/29-05-2024 1200 id/3 months s/1000 n/Company CEO is John Doe `**`n/Company has 500 employee`**
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

- `add c/Happy Burger p/98765432 e/HappyBurger@example.com a/311, Clementi Ave 2 t/NR jd/Software Developer 
intern id/3 months s/1000`

- `add c/DBS Bank p/12345678 e/areers@dbs-bank-online.com a/321 Media Lane, Singapore t/NR jd/Creative Design 
Intern id/3 months s/1000`

<div style="page-break-after: always;"></div>

### 4.1.2 Deleting an internship application : `delete`

Deletes an internship application by index from InternHub.

<box>

**Format:** `delete INDEX`

</box>

* Deletes the contact at the specified `INDEX`.
* The index refers to the index number shown in the displayed internship applications list.
* The index **must be a positive integer** 1, 2, 3, …​

**Example 1:**

`list` followed by `delete 2` deletes the 2nd contact.

**Expected outcome**

After we execute the delete command, the Grab entry is no longer in our list of internship applications.

![delete_example_full](images/UserGuide/deleteExample.png)

### 4.1.3  Editing an internship application : `edit`

Edits an existing internship application detail in InternHub.

1. Begin by typing `edit`, followed by the `INDEX` of the application. The index refers to the index number shown in the displayed internship application list.
2. Next, include only specific prefix for the fields of the internship application you wish to edit in your records. 
   **At least one** of the optional fields must be provided and at most one of each field can be provided.
3. After pressing enter, existing values will be updated to the input values.

<box>

**Format:** `edit INDEX [c/COMPANY_NAME] [p/PHONE_NUMBER] [e/EMAIL] [t/TAG] [jd/JOB_DESCRIPTION] [id/INTERN_DURATION] [s/SALARY] [a/ADDRESS] [d/INTERVIEW_DATE] [n/NOTE]`

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

Example of incorrect format: `edit 1 n/Company CEO is John Doe n/Company has 500 employee`
<br> An error message _"Multiple values specified for the following single-valued field(s): n/"_ will be shown on the result display box.

</box>

**Example 1**
- We've received confirmation of an online assessment from a previously unresponsive company, Happy Burger.
- We want to do the following:
  - Change the status from "NR" to "OA"
  - Set the online assessment date for Happy Burger to be 20 June 2024 at 9 am.

With the edit command, we can achieve this with the following command: 

`edit 3 t/OA d/20-06-2024 0900`

**Example 2**
- Unfortunately, we've received a rejection email from DBS Bank.
- We want to do the following:
    - Change the status from "NR" to "R"

With the edit command, we can achieve this with the following command:

`edit 3 t/R`

The image below shows the respective outcomes after executing both edit commands: 

![edit_example](images/UserGuide/edit_example.png)

<box type="info">

Notice how when we set the online assessment date for Happy Burger, the contact list dynamically rearranged to prioritize the latest interview at the top.<br>
 
This dynamic sorting is based on the first interview date.

</box>

### 4.1.4 Viewing an internship application : `view`

Views the details of the internship application on the view panel in InternHub.

<box>

**Format:** `view INDEX`

</box>

* Views the details of internship application at the specified `INDEX`. 
* The index refers to the index number shown in the displayed internship application list. 
* The index **must be a positive integer** 1, 2, 3, …​

**Example:**

*  `view 1` Displays the company card of the 1st contact in the list on the view panel.

![view1Result](images/UserGuide/view1Result.png)


<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## 4.2  Advanced Commands

### 4.2.1 Listing all internship applications : `list`

This command shows a list of all internship applications in InternHub **sorted in ascending order of interview dates.**
Internship application contacts with interview dates will be listed first, followed by internship application contacts without interview dates.

<box>

**Format:** `list`

</box>

**Expected Outcome**

All internship applications will be shown on the left side of the window.

![list](images/UserGuide/list.png){ width=60% }

<div style="page-break-after: always;"></div>

### 4.2.2 Locating internship applications by name: `find`

Finding internship applications whose company names contain any of the given keywords.

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
* `find burger` returns `Happy Burger` and `Sad Burger`.<br>
  ![result for 'find burger'](images/find/findBurgerResult2.png)

<div style="page-break-after: always;"></div>

### 4.2.3 Updating a Note : `note`

This command will allow you to update the notes of an internship application without overwriting them.

<box>

**Format:** `note INDEX`

</box>

Updating a note of an **existing internship application**.
- Suppose you want to edit the note of an internship application at index **2**.
- Use the note command as follows: `note 2`.
  ![enter note 2](images/note-feature/note_1.png)

- When you hit enter, it will retrieve the note content of the application at index 2 in the command box **as an edit command**:
  ![command executes](images/note-feature/note_2.png)

- Simply update the note content and hit enter again:
  ![command executes](images/note-feature/note_3.png)

- The next time you view the contact, the note section will be updated:
  ![command executes](images/note-feature/note_4.png){ width=60% }


<div style="page-break-after: always;"></div>

### 4.2.4 Filter By Tag : `filter`

Filtering data allows you to narrow down your search results to focus on internship applications based on their status. 
Use the `filter` command to filter by tag and find exactly the internships that have an interview.

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

**Example:**

- `filter i` or `filter I`.
- Filters the internship application list to display only internships with an Interview status.

![resultFilter](images/filter/filterIResult.png){ width=60% }

<div style="page-break-after: always;"></div>

### 4.2.5 Getting reminders : `reminder`

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
- `reminder 100` : Shows you the interviews you have in the next hundredth days, including today.

![reminder command](images/UserGuide/reminderCommand.png){ width=60% }

<box type="tip"> 
This is a quick and easy way to be reminded of the upcoming interviews in order to not miss them.
</box>

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## 4.3 Miscellaneous Commands

### 4.3.1 Getting help : `help`

To access our InternHub User Guide at anytime, simply type help into the command box and press Enter.
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

### 4.3.2 Clearing all entries : `clear`

Clears all entries stored in InternHub.

<box>

**Format:** `clear`

</box>

### 4.3.3 Exiting the program : `exit`

Exits the program.

<box>

**Format:** `exit`

</box>

--------------------------------------------------------------------------------------------------------------------

## 4.4 Storage & Data

### 4.4.1 Saving the data

InternHub data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### 4.4.2 Editing the data file

InternHub data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. 

Advanced users are welcome to update data directly by editing that data file.

<box type="warning">

**CAUTION:**

- If your changes to the data file makes its format **invalid**, InternHub will **discard all data** and start with an empty data file at the next run.  
- Hence, it is recommended to take a **backup** of the `addressbook.json` file before editing it. 
- Furthermore, certain edits can cause the InternHub to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file **only if** you are confident that you can update it correctly.

</box>

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------
# 5. FAQ

**Q**: **How do I transfer my data to another Computer ?**<br>
**A**: Install the InternHub app on the other computer and replace the empty data file it creates with the file containing the data from your previous InternHub *home folder*.

**Q**: **What is a home folder ?**<br>
**A**: A home folder is the main directory associated with a user account on a computer. It typically contains user-specific settings, documents, downloads, and their personal files. Here is an example using the user name "internGuy" on a Unix-like system: `/home/internGuy`. On a Windows sytem, `C:\users\internGuy`.

**Q**: **Why is the app not running ?**<br>
**A**: Ensure that JDK `11` or above is installed.

**Q**: **How do I open the command terminal/how to change directory (cd) into a folder ?**<br>
**A**: Users should refer to the documentation or help resources specific to their operating system for instructions on opening a command terminal and navigating to a directory using the `cd` command.

**Q**: **How do I run internhub.jar ?**<br>
**A**: You can run internhub.jar by opening a command terminal, navigating to the directory containing the jar file using the `cd` command, and then typing `java -jar internhub.jar` and pressing Enter.

**Q**: **I accidentally made some changes in the addressbook.json and InternHub is now blank, what do I do ?**<br>
**A**: The reason for this occurrence is likely due to invalid fields assigned to the internship applications. If you are able to identify the invalid field, by all means make your changes and upon the next run, InternHub should work as normal. However, if you are not sure, you can follow these steps to salvage your data :<br>
1. Take a backup of `addressbook.json`.
2. Run `clear` in InternHub and manually add the applications referencing the details from the `addressbook.json`

--------------------------------------------------------------------------------------------------------------------

# 6. Known Issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

2. **When entering numbers larger than 2147483647 (maximum Integer value)** e.g. reminder 100000000000, the input will be considered invalid as we assumed that most users will not encounter this issue in normal usage. A solution could be added in a future iteration. 

3. **Company name is case-sensitive**, this make it possible for user to input "Apple" and "apple" in our application. It is possible that both input refer to the same company and may lead to potential confusion. For our future implementation, we intend to make company name case-insensitive.

4. **Phone numbers allow duplicates**: We did not want to set high restrictions in our application, hence did not force users to ensure all phone numbers must be unique. From user feedback, duplicate phone numbers can lead to potential confusion, especially when managing large contact lists. A solution could be added in a future iteration.

<div style="page-break-after: always;"></div>

5. **Leap Year Date Handling**: A defect has been identified in the Java Format library where certain invalid date inputs, such as "29 Feb 2023" which is not a leap year, are incorrectly accepted and silently converted to a valid date by the system. This behavior can result in incorrect date information being processed by the application. Hence, users are advised to manually verify the correctness of date inputs, especially around leap years, to ensure accuracy. The workaround in the future will be imposing a stricter validation check offered by the Java library `java.time.format.ResolverStyle` to correct this behaviour.

--------------------------------------------------------------------------------------------------------------------

# 7. Command Summary

| Action       | Format, Examples                                                                                                                                                                                                                                                        |
|--------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**      | `add c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL a/[ADDRESS] t/TAG jd/JOB_DESCRIPTION d/[INTERVIEW_DATE] id/INTERN_DURATION s/SALARY n/[NOTE]` <br> e.g., `add c/FoodPanda p/12345678 e/panda@food.com a/CBD t/I jd/Front End Intern d/15-04-2024 0900 id/6 months s/500 n/-` |
| **Delete**   | `delete INDEX` e.g., `delete 3`                                                                                                                                                                                                                                         |
| **Edit**     | `Edit INDEX c/[COMPANY_NAME] p/[PHONE_NUMBER] e/[EMAIL] a/[ADDRESS] t/[TAG] jd/[JOB_DESCRIPTION] d/[INTERVIEW_DATE] id/[INTERN_DURATION] s/[SALARY] n/[NOTE]`<br> e.g.,`Edit 2 p/99987654`                                                                              |
| **View**     | `view INDEX` e.g., `view 3`                                                                                                                                                                                                                                             |
| **List**     | `list`                                                                                                                                                                                                                                                                  |
| **Find**     | `find KEYWORD [MORE_KEYWORDS]`e.g., `find foodpanda`                                                                                                                                                                                                                    |
| **Note**     | `note INDEX`                                                                                                                                                                                                                                                            |
| **Filter**   | `filter VALID_TAG` e.g., `filter I`                                                                                                                                                                                                                                     |
| **Reminder** | `reminder INT`                                                                                                                                                                                                                                                          |
| **Help**     | `help`                                                                                                                                                                                                                                                                  |
| **Clear**    | `clear`                                                                                                                                                                                                                                                                 |
| **Exit**     | `exit`                                                                                                                                                                                                                                                                  |

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

# 8. Glossary

| Term                              | Meaning                                                                                                                                                                  |
|-----------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Java Version                      | A programming language and computing platform used for the InternHub application. Version 11 or higher is required for proper functioning.                               |
| Terminal or Command Prompt        | Command-line interfaces used to interact with the operating system and run commands.                                                                                     |
| JAR                               | Java Archive (JAR) is a package file format that packages all components of a Java program into a single executable compressed file for distribution. To run a JAR file, you typically need to have a Java Environment installed on your system.                                                                |
| Result Display                    | Area where outputs and messages from InternHub are displayed.                                                                                                            |
| View Panel                        | Area displaying detailed information of the selected internship company contact.                                                                                         |
| Features                          | Functionalities provided by InternHub, including adding, editing, deleting, and filtering contacts.                                                                      |
| Command                           | A directive given to the program to perform a specific task.                                                                                                             |
| GUI (Graphical User Interface)    | A visual way of interacting with a computer through graphical elements like windows, icons, buttons & menus.                                                             |
| Index                             | A numerical identifier used to specify the position of an item in a list, for this context the position of an internship company contact.                                |
| JSON (JavaScript Object Notation) | A lightweight data interchange format that is easy to read & write, and for machines to parse. InternHub uses JSON to store and manage data.                             |
| CLI (Command Line Interface)      | A way to interact with a computer by typing commands into a terminal or command box.                                                                                     |
| Prefix                            | A string of characters placed at the beginning of a command to indicate its type. For example, InternHub uses `c/` for company name and `p/` for phone number and so on. |
| Field                             | A specific piece of information within each internship company contact like company name, phone number & etc...                                                          |

