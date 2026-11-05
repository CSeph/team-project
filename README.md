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
- user stories here
(Add additional user stories as needed.)
---
## Use Cases
### Use Case 1
### Use Case 2
### Use Case 3
### Use Case: View and Review Consolidated Trigger Warnings

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

### Use Case: Submit Trigger Warning Feedback

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
### Use Case 5
### Use Case 6

---
## Minimal Viable Product (MVP)
| Team Member | MVP Use Case |
|-------------|--------------|
| Sarina | Use Case 1 |
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

