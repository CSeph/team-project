# Trigger Warning
The readme should include information such as:
- information about the API(s) that your project uses 
- screenshots or animations demonstrating current functionality

## Team Information
### Team Members
- Sarina
- Seph
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
### _Seph_
- As a user, I want to narrow down my search results (e.g., by genre or release year) so that I can quickly find the exact movie I am looking for.
- As a user, I want to be informed when no movies match my search so that I know to try a different title.
- As a user, I want to see an overview of my profile, including my trigger preferences, thresholds, reviews, and saved movies, so that I can review my settings and activity in one place.
- As a user, I want to hide search results that contain triggers above my chosen thresholds so that I only see movies I am comfortable watching.
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

------
## Use Cases
Use cases are grouped by team member, following the numbering in the app sketch legend:
1) Sarina 2) Seph 3) Toby 4) Catherine 5) Emirhan 6) Wenxiao

## 1) Sarina — My Account & Edit Profile Settings

### Use Case 1: User Creates/Signs Up for an Account 
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

### Use Case 2: Log In to an Account
_(Draft based on the "My Account" page in the app sketch — Sarina to confirm.)_

**Primary actor:** User with an existing account

**Preconditions:**
- The user already has an account.
- The user is not logged in.

**Trigger:** The user enters their username and password on the "My Account" page and selects Sign In.

**Success outcome:** The user is logged into their account and the home page is displayed.

**Main success scenario:**
1. The user opens the "My Account" page.
2. The user enters their username and password.
3. The user selects Sign In.
4. The system verifies the username and password.
5. The system logs the user in and displays the home page.

**Extensions:**
- **1a.** The user does not have an account.
  1. The user chooses to register.
  2. The system starts the User Creates/Signs Up for an Account use case (Use Case 1).
- **3a.** The username or password field is empty.
  1. The system prompts the user to fill in both fields.
  2. The user completes the fields and selects Sign In again.
- **4a.** The username or password is incorrect.
  1. The system informs the user that the login information is incorrect.
  2. The user may try again.

### Use Case 3: Viewing and Selecting Current Trigger Categories Available
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

### Use Case 4: Viewing and Setting Severity Thresholds for Each Selected Trigger
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

### Use Case 5: Viewing and Modifying Trigger Warning Response
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

## 2) Seph — Home Page Search & Profile Overview

### Use Case 6: Search for a Movie

**Primary actor:** User searching for a specific movie

**Preconditions:**
- The user is on the home page.
- The movie database is available to the system.

**Trigger:** The user enters a movie title into the search bar and submits the search.

**Success outcome:** The system displays the movies matching the user's search, and the user can open the page of the movie they select.

**Main success scenario:**
1. The user enters a movie title into the search bar.
2. The user submits the search.
3. The system validates the search input.
4. The system retrieves the movies matching the title from the movie database.
5. The system displays the matching movies with their titles, posters, and release years.
6. The user selects a movie from the results.
7. The system starts the View Movie Details use case (Use Case 8) for the selected movie.

**Extensions:**
- **3a.** The search input is empty.
  1. The system prompts the user to enter a movie title.
  2. The user enters a title and resubmits the search.
- **4a.** The system cannot retrieve the results (e.g., due to a connection issue).
  1. The system informs the user that the search could not be completed.
  2. The user may retry or cancel.
- **4b.** No movies match the search.
  1. The system informs the user that no movies were found.
  2. The user may search with a different title.
  3. The use case ends.
- **5a.** The user chooses to filter the results.
  1. The system presents the available filter options (e.g., genre, release year).
  2. The user selects one or more filters.
  3. The system displays only the results that match the selected filters.
  4. If no results match, the system informs the user, who may change or clear the filters.

### Use Case 7: View Profile Overview

**Primary actor:** User viewing their profile

**Preconditions:**
- The user is logged into their account.

**Trigger:** The user selects the profile icon on the home page.

**Success outcome:** The system displays the user's profile overview, including their account information, saved trigger preferences and thresholds, submitted reviews, and saved movies.

**Main success scenario:**
1. The user selects the profile icon on the home page.
2. The system retrieves the user's account information, saved trigger preferences, thresholds, submitted reviews, and saved movies.
3. The system displays the profile overview.
4. The user reviews their profile information.

**Extensions:**
- **1a.** The user is not logged in.
  1. The system starts the Log In to an Account use case (Use Case 2).
  2. After the user logs in, the use case resumes at step 2.
- **2a.** The user has no saved trigger preferences, reviews, or saved movies.
  1. The system displays the corresponding section as empty with a short message.
  2. For trigger preferences, the system offers the option to configure them.
- **2b.** The system cannot retrieve the profile information.
  1. The system informs the user that the profile could not be loaded.
  2. The user may retry or cancel.
- **4a.** The user chooses to manage their preferences.
  1. The system displays the Edit Profile Settings page, where the user can update their trigger categories, thresholds, and warning responses (Use Cases 3–5).
- **4b.** The user selects a saved movie.
  1. The system starts the View Movie Details use case (Use Case 8) for that movie.
- **4c.** The user chooses to sign out.
  1. The system signs the user out and displays the "My Account" page.

## 3) Toby — Selected Movie Page & Movie Metadata

### Use Case 8: View Movie Details
_(Draft based on the "Selected Movie Page" and "Metadata" parts of the app sketch — Toby to confirm.)_

**Primary actor:** User viewing a selected movie

**Preconditions:**
- The user has selected a movie from the search results or from their saved movies.

**Trigger:** The user selects a movie.

**Success outcome:** The system displays the selected movie's details, along with its trigger warning timeline and the options to add a new trigger or see reviews.

**Main success scenario:**
1. The user selects a movie.
2. The system retrieves the movie's details from the movie database.
3. The system displays the movie's image, title, description, and additional metadata (e.g., release year, genre, runtime).
4. The system displays the movie's trigger warning timeline (Use Case 10) and the options to add a new trigger (Use Case 13) or see reviews (Use Case 11).

**Extensions:**
- **2a.** The system cannot retrieve the movie's details.
  1. The system informs the user that the movie could not be loaded.
  2. The user may retry or return to the previous page.
- **3a.** Some of the movie's details are unavailable.
  1. The system displays the available details and marks the missing ones as unavailable.

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

## 4) Catherine — Trigger Warning Timeline & Reviews

### Use Case 10: View and Review Consolidated Trigger Warnings

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

### Use Case 11: Submit Trigger Warning Feedback

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

## 5) Emirhan — Upload Your Own Media

### Use Case 12: Analyze Uploaded Subtitles

**Primary actor: User wanting to see the trigger warnings**

**Preconditions:**

**Trigger:** 

**Success outcome:** 

**Main success scenario:**

**Extensions:**


## 6) Wenxiao — Submit a New Trigger & Review Form

### Use Case 13: Submit Trigger Warning

**Primary actor:** User submitting a trigger warning

**Preconditions:**

- The user has searched for and selected a piece of media.
- The selected media exists in the system.
- The system has a list of available trigger categories.

**Trigger:** The user chooses to submit a trigger warning for the selected media.

**Success outcome:** The user's trigger warning is successfully recorded and associated with the selected media, making it available for consolidation and display to other users.

**Main success scenario:**

1. The user selects the option to add a trigger warning for the selected media.
2. The system displays a trigger warning submission form.
3. The system displays the available trigger categories.
4. The user selects a trigger category.
5. The user enters the relevant information, including the start and end timestamps (when applicable), a description of the triggering content, and its severity level.
6. The user submits the trigger warning.
7. The system validates the submitted information.
8. The system saves the trigger warning and associates it with the selected media.
9. The system confirms that the trigger warning was successfully submitted.

**Extensions:**

- **4a.** No existing trigger category accurately describes the content.
  1. The user chooses to create a new community trigger category.
  2. The system initiates the Create Community Trigger Category use case (Use Case 14).
  3. After successfully creating the category, the user returns to the submission form and selects the new category.

- **7a.** The submitted information is incomplete or invalid.
  1. The system informs the user which information is missing or invalid.
  2. The user corrects the information and resubmits the form.

- **8a.** The system cannot save the trigger warning.
  1. The system informs the user that the submission was unsuccessful.
  2. The user may retry or cancel.
  3. If the user cancels, the use case ends without recording the warning.

### Use Case 14: Create Community Trigger Category

**Primary actor:** User creating a community trigger category

**Preconditions:**

- The user has access to the available trigger categories.
- The existing categories do not accurately describe the triggering content the user wants to report.

**Trigger:** The user chooses to create a new community trigger category.

**Success outcome:** A new community trigger category is successfully created and becomes available for selection when submitting trigger warnings.

**Main success scenario:**

1. The user selects the option to create a new trigger category.
2. The system displays a form for creating a community trigger category.
3. The user enters a category name and description.
4. The user submits the new category.
5. The system validates the submitted information.
6. The system checks whether a category with the same name already exists.
7. The system saves the new category as a community-created category.
8. The system confirms that the category was successfully created.
9. The new category becomes available for selection when submitting trigger warnings.

**Extensions:**

- **5a.** The category name or description is missing or invalid.
  1. The system informs the user of the missing or invalid information.
  2. The user corrects the information and resubmits the form.

- **6a.** A category with the same name already exists.
  1. The system informs the user that the category already exists.
  2. The user may select the existing category or enter a different name.

- **7a.** The system cannot save the new category.
  1. The system informs the user that the category could not be created.
  2. The user may retry or cancel.
  3. If the user cancels, the use case ends without creating the category.

### Use Case 15: Comment on a Trigger Warning
_(Draft based on the "Review Form" in the app sketch — Wenxiao to confirm.)_

**Primary actor:** User writing a comment about a trigger warning

**Preconditions:**
- The user is logged into their account.
- The user is viewing the reviews of a consolidated trigger warning.

**Trigger:** The user selects "Add Comment" for a trigger warning.

**Success outcome:** The user's comment is saved and displayed under the selected trigger warning.

**Main success scenario:**
1. The user selects "Add Comment" for a trigger warning.
2. The system displays the review form.
3. The user writes their comment.
4. The user submits the comment.
5. The system validates the comment.
6. The system saves the comment and associates it with the selected trigger warning.
7. The system displays the comment under the trigger warning.

**Extensions:**
- **5a.** The comment is empty or too long.
  1. The system informs the user what needs to be fixed.
  2. The user edits the comment and resubmits it.
- **6a.** The system cannot save the comment.
  1. The system informs the user that the comment could not be submitted.
  2. The system keeps the written comment so the user can retry or cancel.

---
## Minimal Viable Product (MVP)
| Team Member | MVP Use Case |
|-------------|--------------|
| Sarina | Viewing and Selecting Current Trigger Categories Available |
| Sarina | Viewing and Modifying Trigger Warning Response |
| Sarina | User Creates an Account |
| Seph | Search for a Movie|
| Seph | View Profile Overview |
| Toby         | Save Trigger Preferences             |
| Toby         | Browse Trigger Preferences           |
| Catherine      | View and Review Consolidated Trigger Warnings             |
| Catherine       | Submit Trigger Warning Feedback             |
| Emirhan         | Upload Your Own Media             |
| Wenxiao | Submit a New Trigger|
| Wenxiao    | Review Form             |
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
Link to Slides: https://docs.google.com/presentation/d/17c_46VmWSpbKd_MX34flg0v0Y5wzYPyVLOiRjhtNk8g/edit?usp=sharing
Link to Figma: https://www.figma.com/design/lfOflhqLBI4IXYdahOSp75/CSC207?node-id=0-1&t=gU9uKzAxIxzfKBMN-1
[Any additional project information.]
