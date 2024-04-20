---
layout: default.md
title: "Ashley's Project Portfolio Page"
---

### Project: InternHub

InternHub is a desktop address book application used for teaching Software Engineering principles. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

* **New Feature**: Allow user to add new contact to InternHub
  * What it does: Allow user to add the internship information that they applied for
  * Justification: This feature allow users to conveniently store all relevant internship details in one centralized location alongside their other contacts. This helps them stay organized and easily access internship information when needed.
  * Credits: The feature builds upon the robust foundation of AB3, optimizing code to accommodate new parameters.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s2.github.io/tp-dashboard/?search=ashleygoh1&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2024-02-23&tabOpen=false)

* **Project management**:
  * Managed releases `v1.3` (1 releases) on GitHub

* **Enhancements to existing features**:
  * Update existing tests for existing features with coverage of 78.571% (Pull requests [\#9](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/9), [\#48](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/48)
  * Update UI for PersonCard to display essential information only (Pull request [\#71](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/71))
  * Add descriptive labels to UI PersonCard for clarity (Pull request [\#71](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/71))
  * Show a '-' in UI if note or interview date is empty (Pull request [\#83](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/83))
  * Update compareInterviewDates() function found in Person.java to fix app crash (Pull request [\#190](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/190))

* **Documentation**:
  * User Guide:
    * Added documentation for the features `add` and `edit` [\#16](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/16), [\#104](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/104)
    * Added documentation for the features `delete` [\#108](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/108)
    * Added documentation related to bugs [\#189](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/189)
    * Added a new section 'understanding each parameter' [\#189](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/189)
    * Updated images [\#200](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/200)

  * Developer Guide:
    * Update DG to include add command feature description [\#79](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/79)
    * Added more manual test cases, update implementation for add command and add planned enhancement [\#206](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/206)
    * Add `add`, `edit`, `filter` activity diagrams, `filter` sequence diagram [\#221](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/221)

* **Community**:
  * PRs reviewed (with non-trivial review comments): [\#78](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/78#discussion_r1540881872), [\#32](), [\#70](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/70#discussion_r1541268786)
  * Reported bugs and suggestions for other teams in the class (examples: [1](https://github.com/ashleygoh1/CS2103-T-PE-Dry-run/issues/1), [2](https://github.com/ashleygoh1/CS2103-T-PE-Dry-run/issues/2), [3](https://github.com/ashleygoh1/CS2103-T-PE-Dry-run/issues/3),
    [4](https://github.com/ashleygoh1/CS2103-T-PE-Dry-run/issues/4),
    [5](https://github.com/ashleygoh1/CS2103-T-PE-Dry-run/issues/5),
    [6](https://github.com/ashleygoh1/CS2103-T-PE-Dry-run/issues/6),
    [7](https://github.com/ashleygoh1/CS2103-T-PE-Dry-run/issues/7),
    [8](https://github.com/ashleygoh1/CS2103-T-PE-Dry-run/issues/8),
    [9](https://github.com/ashleygoh1/CS2103-T-PE-Dry-run/issues/9),
    [10](https://github.com/ashleygoh1/CS2103-T-PE-Dry-run/issues/10))

* **Challenges and Problem Solving**:
  * I was in charge of adding new fields to the person model. This required many changes throughout the project.
    At the start, I thought this was a simple process but as I ran the code, errors started appearing, with more than 20% of the test cases failing.
    Rather than editing everything at once, I broke down the error into smaller, manageable chunks. This allows me to test each change as I go to catch errors early and minimize the debugging effort.
    After 2 days, I managed to update the code accordingly,  pass all test cases and improve the code coverage from 75.26% to 78.571%.

  * I created a pull request (PR) at the same time as one team member. I merged my teammate's PR first and when I wanted to merge my PR, merge conflict was shown.
    I was panicking as I am used to fixing the conflict on the GitHub website. Yet for this PR, GitHub showed that the conflict was too complicated and required me to fix it on my laptop.
    I kept myself calm and updated about the issue with my teammates. Thankfully, one of my team members was able to resolve the merge conflict by pulling the latest changes from the main branch to her local repository, manually resolving the conflict using a code editor, before successfully merging the PR without further issues.

* **Tools**:
  * Set up codecov to the team repo
  * Set up UserGuide.md and DeveloperGuide.md
  * Set up team's GitHub repo
  
