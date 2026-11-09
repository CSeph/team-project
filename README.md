# Trigger Warning
The readme should include information such as:
- information about the API(s) that your project uses 
- screenshots or animations demonstrating current functionality

## Team Information
### Team Members
- Sarina
- Joseph
- Wenxiao
- Catherine
- Emirhan
- Toby
---
## Project Description
### Domain
- Trigger Warning is an app that provides users with warnings of when a potential trigger may happen in a piece of media, for example a movie or a book. It allows users to input triggers they have encountered, read others' warnings, and upload a book or movie transcript and read/watch it with in-built skips for their chosen triggers.
---
## User Stories
### _Sarina_
- Main Focus: Personalized Trigger Profile ~ As a user, I want to set up my personal trigger account profile so that the content I watch and/or read reflects my audio/visual preferences.
  - As a user, I want to view the list of triggers that are currently available by category so that I can select which triggers I want to filter out.
  - As a user, I want to set severity thresholds for each of my selected trigger so that the app can suggest relevant content that meets my chosen level of sensitivity.
  - As a user, I want to select how the app should respond to each trigger warning so that when a trigger occurs it is handled appropriately. 
  - As a user, I want to be able to make changes to my trigger profile so that the media I watch/read aligns with my current mood and preferences.
### _Joseph_
- user stories here
### _Wenxiao_
- As a user, I want to submit a trigger warning for a selected piece of media so that I can help other users know when potentially difficult content occurs.
- As a user, I want to create a community trigger category when none of the existing categories accurately describe the content I want to report, so that I can submit a more accurate trigger warning.
### _Catherine_
- As a user, I want to see a single consolidated warning for each trigger event so that I can understand what happens without having to read multiple reports of the same event.
- As a user, I want to see a confidence score for each trigger warning so that I can judge how reliable the warning is.
- As a user, I want to submit feedback on the accuracy of a trigger warning so that I can help improve the reliability of warnings for other users.
### _Emirhan_
- user stories here
### _Toby_
- As a user, I want to choose from a spectrum of existing trigger warnings to create personalized content safety
- As a user, I want to conveniently access my preferences in triggers selection
- As a user, I want the warnings shown for a selected movie or book to reflect my saved trigger preferences.

---
## Use Cases
### Use Case 1: Viewing and Selecting Current Trigger Categories Available
**Primary actor:** User is viewing the trigger categories in their profile setting.

**Preconditions:**
- The user is logged into their account.
- User is looking through their profile settings. 
- Trigger categories are listed and viewable.

**Trigger:** The user is navigating through trigger categories section of profile.

**Success outcome:** The system is able to display the categorized triggers that the user can select/deselect from.

**Main success scenario:** 
1. The user is editing his/her/their trigger profile section.
2. The system retrieves the different categorized trigger and displays it.
3. The user is able to select and deselect triggers to their preference. 
4. The system saves the changes to the user's profile.

**Extensions:**
- **3a.** User has no changes they want to make or undo their changes.
  1. The system retains previous profile settings, disregarding unsaved changes.
  2. The use case ends with the existing profile remaining unchanged.
- **5a.** The system could not save any changes.
  1. The system informs the user that the change could not be saved. (Ex. This could be due to connection issue.)
  2. The user can try again.

### Use Case 2: Viewing and Setting Severity Thresholds for Each Selected Trigger
**Primary actor:** User wants to adjust certain trigger's severity thresholds in their profile setting.

**Preconditions:**
- The user is logged into their account.
- User is looking through their profile settings.
- User selects a trigger.

**Trigger:** The user is navigating and configuring a trigger's threshold section of profile.

**Success outcome:** The system is make changes to the user's preferred threshold for the selected trigger.

**Main success scenario:**
1. The user is editing his/her/their threshold for a trigger in profile section.
2. The user is able to drag/select a preferred threshold. 
3. The system displays and saves the changes to the user's profile.

**Extensions:**
- **1a.** No trigger is selected to be edited.
  1. The system prompts user to select a trigger to edit before configuring the new severity level threshold.
  2. The use case ends.

### Use Case 3: Viewing and Modifying Trigger Warning Response
**Primary actor:** User is viewing a selected trigger's warning response in profile setting.

**Preconditions:**
- The user is logged into their account.
- User is looking through their profile settings.
- User selected a trigger.

**Trigger:** The user selects how to the system should respond to the trigger.

**Success outcome:** The system is able to save the preferred warning response to the trigger.

**Main success scenario:**
1. The user is editing his/her/their trigger profile section.
2. The system retrieves pre-saved warning response of the selected trigger and displays it.
3. The user can make changes, selecting to how the system should respond to the trigger.
4. The system saves the changes to the user's profile.

**Extensions:**
- **1a.** No trigger is selected to be edited.
  1. The system prompts user to select a trigger to edit before configuring the new severity level threshold.
  2. The use case ends.
- **3a.** The user does not choose a warning response to the trigger.
  1. The system prompts the user to choose a warning response from a list.
  2. The user re-selects or cancel changes.
  
### Use Case 4: User Creates/Signs Up for an Account 
**Primary actor:** User creating a personalized trigger profile for the first time.

**Preconditions:**
- The user is logged in for the first time given they do not have an existing account already created.
- The profile settings from trigger categories, thresholds, and response options are configured.

**Trigger:** The user clicks on register/create a Trigger profile account.

**Success outcome:** The user's personalized profile is created and saved (i.e. username, password, selected triggers, preferred trigger warning response and thresholds)

**Main success scenario:** 
1. The user able to create a unique username and password. 
2. The system presents the available trigger warnings, responses, and threshold adjustments. 
3. The user can select and filter out triggers to their preference, assigning thresholds to each selected trigger.
4. The system retains/saves the user's preferences. 
5. The system displays the user's profile settings.

**Extensions:**
- **3a.** User does not select any adjustments to their trigger warning preferences.
  1. The system informs user to fill out each section of the trigger profile.
- **5a.** User decides not to make an account and deletes unsaved profile.
  1. The system does not save the profile. It deletes the profile content.
  2. The use case ends.

### Use Case 5: View and Review Consolidated Trigger Warnings

**Primary actor:** User viewing the selected media

**Preconditions:**
- The user has searched for and selected a piece of media.
- The selected media's page is loading.
- Trigger reports associated with the selected media are available in the system.

**Trigger:** The selected media's page begins loading.

**Success outcome:** The system returns and displays the latest consolidated trigger warnings, including their descriptions, timestamps, confidence scores, and contributing reports.

**Main success scenario:**
1. The system retrieves the available trigger reports and previously stored consolidated warnings for the selected media.
2. The system checks whether the stored consolidated warnings are up to date with the available reports.
3. If the stored warnings are outdated, the system consolidates the reports and recalculates the confidence scores.
4. The system saves the updated consolidated warnings and confidence scores.
5. The system returns the latest consolidated warnings and confidence scores.
6. The system displays the warnings in a timeline.
7. The user selects a warning to inspect it.
8. The system displays the individual reports contributing to the selected warning.

**Extensions:**
- **1a.** No trigger reports are available for the selected media.
  1. The system returns an empty collection of warnings.
  2. The system informs the user that no trigger warnings are currently available.
  3. The use case ends.

### Use Case 6: Submit Trigger Warning Feedback

**Primary actor:** User providing feedback

**Preconditions:**
- The user is viewing a consolidated trigger warning.
- The selected warning exists in the system.

**Trigger:** The user chooses to provide feedback on a consolidated trigger warning.

**Success outcome:** The user's feedback is recorded and associated with the selected consolidated trigger warning.

**Main success scenario:**
1. The user chooses to provide feedback on a trigger warning.
2. The system presents the available feedback options.
3. The user indicates whether the warning is accurate.
4. If the user indicates that the warning is inaccurate, the user may select a reason for their feedback.
5. The user submits their feedback.
6. The system records the feedback.
7. The system confirms that the feedback was submitted.

**Extensions:**
- **5a.** The system cannot record the feedback.
  1. The system informs the user that the feedback could not be submitted and that they may try again.
  2. The use case ends without recording the feedback.

### Use Case 7: Browse and Save Trigger Preferences

**Primary actor:** User selecting trigger preferences

**Preconditions:**
- The user is logged into their account.
  Trigger: The user chooses to browse and configure their trigger preferences.

**Success outcome:** The user’s selected trigger categories are saved to their profile.

**Main success scenario:**
1. The user opens the trigger preferences section.
2. The system displays available trigger categories and descriptions, marking any previously saved selections.
3. The user browses or searches the categories.
4. The user selects or deselects categories.
5. The user chooses to save their preferences.
6. The system saves the selections.
7. The system confirms that the preferences were saved.

**Extensions:**
- 2a. The system cannot retrieve the categories or saved preferences.
  1. The system informs the user that the information could not be loaded.
  2. The user may retry or cancel.
- 3a. A search finds no matching categories.
  1. The system displays an empty result.
  2. The user may change their search.
- 5a. The user cancels without saving.
  1. The system discards unsaved changes.
  2. The use case ends with the previously saved preferences unchanged.
- 6a. The system cannot save the selections.
  1. The system informs the user that saving failed.
  2. The system retains the pending selections so the user can retry.

### Use Case 8: View Saved Trigger Preferences

**Primary actor:** User reviewing their trigger preferences

**Preconditions:**
- The user is logged into their account.
  Trigger: The user chooses to view their saved trigger preferences.

**Success outcome:** The user can review their currently saved trigger selections and associated settings.

**Main success scenario:**
1. The user opens their saved trigger preferences.
2. The system retrieves the user’s saved selections and associated settings.
3. The system displays the selected trigger categories and their settings.
4. The user reviews their preferences.

**Extensions:**
- 2a. The user has no saved preferences.
  1. The system informs the user that no preferences have been saved.
  2. The system offers the option to configure trigger preferences.
- 2b. The system cannot retrieve the saved preferences.
  1. The system informs the user that the preferences could not be loaded.
  2. The user may retry or cancel.
- 4a. The user chooses to change their trigger selections.
  1. The system starts the Browse and Save Trigger Preferences use case.

### Use Case 9: View Media Warnings Based on Saved Preferences

**Primary actor: User viewing personalized media warnings**

**Preconditions:**
- The user is logged into their account.
- The user has saved trigger preferences.
- The user has selected a movie or book.
  Trigger: The user chooses to view personalized trigger warnings for the selected media.

**Success outcome:** The system displays the available warnings that match the user’s saved trigger preferences.

**Main success scenario:**
1. The user requests personalized warnings for the selected media.
2. The system retrieves the user’s saved trigger preferences.
3. The system retrieves the selected media’s consolidated warnings.
4. The system matches the warnings against the selected trigger categories and any applicable severity thresholds.
5. The system displays matching warnings with their available locations, descriptions, and confidence scores.
6. The user selects a warning to inspect.
7. The system displays the selected warning’s details.

**Extensions:**
- 2a. The system cannot retrieve the user’s preferences.
  1. The system informs the user that their preferences could not be loaded.
  2. The user may retry or cancel.
- 3a. No warnings are available for the selected media.
  1. The system informs the user that no trigger warnings are currently available.
  2. The use case ends.
- 3b. The system cannot retrieve the media’s warnings.
  1. The system informs the user that the warnings could not be loaded.
  2. The user may retry or cancel.
- 4a. None of the available warnings match the saved preferences.
  1. The system informs the user that no available warnings match their preferences, without implying that the media is free of triggering content.
  2. The use case ends.

---
## Minimal Viable Product (MVP)
| Team Member | MVP Use Case |
|-------------|--------------|
| Sarina | Viewing and Selecting Current Trigger Categories Available |
| Sarina | Viewing and Setting Severity Thresholds for Each Selected Trigger |
| Sarina | Viewing and Modifying Trigger Warning Response |
| Sarina | User Creates an Account |
| Joseph | Use Case 2 |
| Wenxiao | Use Case 3 |
| Catherine | View and Review Consolidated Trigger Warnings |
| Catherine | Submit Trigger Warning Feedback |
| Emirhan | Use Case 5 |
| Toby | Use Case 6 |
---
## Entities
### Entity 1
### Entity 2
(Add additional entities as needed.)
---
## API Usage
**API Name:**
**Documentation:** [Link]
**How it is used in the program:**
---
## Design Diagrams
### UML Class Diagram
### Sequence Diagrams
---
## How to Run
[Instructions for running the program.]
---
## Notes
[Any additional project information.]

