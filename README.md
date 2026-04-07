Academic Task Manager

1. Graphical Abstract:
 <img width="724" height="314" alt="螢幕擷取畫面 2026-04-07 163701" src="https://github.com/user-attachments/assets/a1ca6530-4277-4f35-a62d-def8ceb80a33" />
 
2. Project Purpose:

Our group decided to use the Agile Development approach for this semester's project. The reason why we chose Agile is because as a student group, we expected that our requirements would change as we refined the user interface. Agile allowed us to work in short iterations—starting with a basic task list and then adding features like progress tracking and sorting based on our testing.

Target Market:

University Students: Specifically those juggling multiple courses and assignments simultaneously.

Goal: To reduce academic stress by providing a clear visual overview of pending tasks and their urgency.

3. Software Development Plan

Team Members and Roles:

We divided the project into five parts, with each member contributing 20%.

Wu Tin Kin: Project Manager, Progress monitoring, task allocation, and documentation oversight.

SIO HOU WENG: Lead Developer, Core Java logic, data structures, and Task class development.

Rex, NG KA IP: Software Architect,Algorithm design (Deadline Logic), GitHub version control, and technical writing.

Lui Yuk Shing: UI/UX Designer,Console interface styling (ASCII art) and ensuring a user-friendly command flow.

LOU HO: QA & Testing, Unit testing (JUnit), bug fixing.

Development Schedule:

Week 1: Requirement analysis and UI sketching.

Week 2: Core coding phase (Base classes and file storage).

Week 3: System integration (Priority algorithm and data persistence).

Week 4: Final testing, bug fixing, and recording the demo video.

Core Algorithm:

The system relies on a "Deadline Priority Scoring" logic:

Fetch the current date ($T_{now}$) and task due date ($T_{due}$).

Calculate remaining days: $D = T_{due} - T_{now}$.

Categorization:

If D < 0: Mark as OVERDUE.

If 0 <= D <= 3: Mark as HIGH PRIORITY.

If D > 3: Mark as NORMAL.

Progress: (Completed_Step / Total_step) * 100%

Platform: Runs on Windows, macOS, or Linux (requires JVM).

5. Status & Future Work

Current Status: We have completed the Pilot Level. The software is fully functional with CRUD operations (Add, View, Update, Delete) and data persistence.

Future Roadmap: We hope to add a GUI (Graphic User Interface) using JavaFX and potentially a cloud sync feature.

6. References

Kim, S.-K. (Amang). COMP2116: Software Engineering Final Project Guideline. Macao Polytechnic University.

Oracle Java Docs. Serialization and Date-Time API. Official Documentation.

Agile Alliance. The Agile Manifesto for Software Development.
