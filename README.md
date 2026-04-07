Academic Task Manager

1. Graphical Abstract
 <img width="724" height="314" alt="螢幕擷取畫面 2026-04-07 163701" src="https://github.com/user-attachments/assets/a1ca6530-4277-4f35-a62d-def8ceb80a33" />

2. Project Purpose

2.1 Software Development Process
Our team adopted the Agile Development methodology for this project.
	Reasoning: As a student group, we anticipated that our requirements might evolve as we refined the user interface. Agile allowed us to work in short iterations—starting with a basic task list and gradually integrating advanced features like progress tracking and deadline sorting based on our testing feedback.

2.2 Target Market
	University Students: Specifically those juggling multiple courses, assignments, and exams simultaneously.

 
3. Software Development Plan
3.1 Team Members and Roles
Name	Role	Responsibilities	Contribution (%)
Wu Tin Kin	Project Manager (PM)	Overall progress monitoring, task allocation, and documentation oversight.	20%
SIO HOU WENG	Lead Developer	Implementing core Java logic, designing data structures, and Task class development.	20%
Rex, NG KA IP	Software Architect	Algorithm design (Deadline Logic), GitHub version control, and README technical writing.	20%
Lui Yuk Shing	UI/UX Designer	Console interface styling (ASCII art) and ensuring a user-friendly command flow.	20%
LOU HO	QA & Testing	Unit testing (JUnit), bug fixing,	20%

 
3.2 Development Schedule
	Week 1: Requirement analysis and initial UI sketching.
	Week 2: Core coding phase – establishing base classes and file storage logic.
	Week 3: System integration – implementing the priority algorithm and data persistence.
	Week 4: Final testing, bug squashing, and producing the demonstration video.
3.3 Core Algorithm
The system relies on a "Deadline Priority Scoring" logic:
	Fetch current date (T_now) and task due date (T_due).
	Calculate remaining days (D = T_due - T_now).
	Priority Categorization:
	If D < 0: Mark as OVERDUE (Immediate action required).
	If 0 <= D <= 3: Mark as HIGH PRIORITY (Urgent attention).
	If D > 3: Mark as NORMAL.
	Progress Calculation: 
Progress = (Completed_Step / Total_step) * 100%.

4. Technical Specifications
	Language: Java 17
	Key Libraries: java.time for date management, java.util for collection frameworks, and java.io for data persistence.
	Environment: Developed using VS Code.
	Requirements: Compatible with any OS supporting JVM (Windows/macOS/Linux) with at least 4GB RAM.

5. Status and Future Roadmap
	Current Status: Successfully completed the Pilot Stage. The app supports full CRUD operations (Create, Read, Update, Delete), automated deadline sorting, and local data saving.
	Future Plans:
	Implement cloud synchronization for multi-device access.
	Transition from local file storage to a structured JSON or Database system.
	Develop a mobile application version (Android/iOS).
 
6. References & Resources
6.1 Academic & Course References
	Beck, K., et al. (2001). Manifesto for Agile Software Development. Retrieved from AgileAlliance.org.
	Note: Provided the theoretical basis for our iterative development approach.
	Sommerville, I. (2015). Software Engineering (10th Edition). Pearson.
	Note: Used as a reference for defining software requirements and system architecture.
6.2 Technical Documentation
	Oracle. Java Platform, Standard Edition (Java SE) 17 Documentation. Official Documentation.
	Java Time API. Interface Local Date and Chrono Unit. Reference Link.
	Used for implementing the deadline calculation and priority sorting algorithm.
	Java I/O Serialization. Serializable Interface and Object Streams. Reference Link.
	Referenced for implementing the local data persistence (Save/Load) functionality.
