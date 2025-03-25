# CSE360TeamProject Phase 2
```plaintext
Project 2 Overview, Technical, and Execution of Application Screencasts:
Screencast 1:https://asu.zoom.us/rec/share/UCuMWaJl_RZUg-VEBk2NT-AR9KvsjlxzGlkchFymauTLk201nDRT-oB8MRhiiror.JabSxxxJu24EdDsu?startTime=1740807714000
Passcode: ZUXm8n$
Screencast 2:https://asu.zoom.us/rec/share/Ph67nA-kGDbq4siY3YYvBhFg-gCk0BWvDNvYSL04qTMapi2-Bv9ROv2XW3v8JoLK.ZHBBp-nv0pcqeSHQ?startTime=1740791463000 
Passcode: @&Wxa@t0
Screencast 3: https://asu.zoom.us/rec/share/Ph67nA-kGDbq4siY3YYvBhFg-gCk0BWvDNvYSL04qTMapi2-Bv9ROv2XW3v8JoLK.ZHBBp-nv0pcqeSHQ?startTime=1740792022000 
Passcode: @&Wxa@t0


Project Overview

The CSE360 team progect is a JavaFX-based application that facilitates user registration, authentication, and role-based navigation. It supports both admin and user roles, with an invitation code system for user registration. The system is backed by an H2 database for persistent user data storage. Additionally, Student users, and the admin, may access a Question and Answewr page that allows users to post questions and answers, add comments, answer questions, and search through the lists of questions and answers to find specific ones  within. The User Interface allows for editing and deletion by the question or answer posted, or the Admin if needed.

Features:
  -Admin Setup: The first user initializes the system with an admin account.
  -User Registration: New users can sign up using a valid invitation code.
  -Login Authentication: Secure login system that verifies credentials.
  -Role-Based Navigation:
  -Admin users access an Admin Home Page with invitation management.
  -Regular users access a User Home Page.
  -Database Management: Uses an H2 database for storing user credentials and invitation codes.
  -Invitation Code System: Admins can generate unique codes for user registration.
  -Student Home Page.
  -Question and Answer Page.
  -Associated functions and classes required to allow for posting, editing, seeing, and searching through questions and answers.

Project Structure
| |-/src
├── application/
│   ├── StartCSE360.java             # Main entry point of the application
│   ├── WelcomeLoginPage.java        # Initial welcome page 
│   ├── FirstPage.java               # First-time admin setup page
│   ├── UserHomePage.java            # The User Home Page
│   ├── AdminSetupPage.java          # Admin registration and setup page
│   ├── AdminHomePage.java           # Home page for the Admin user
│   ├── SetupLoginSelectionPage.java # Selection page for login/setup
│   ├── SetupAccountPage.java        # New user registration page
│   ├── ForgotPasswordPage.java      # Page for filling out a new password if old one is forgotten
│   ├── OneTimePasswordPage.java     # Page for getting a OTP 
│   ├── InvitatioPage.java           # Page seen for getting an invitiation to join
│   ├── UserLoginPage.java           # User login page
│   ├── WelcomeLoginPage.java        # Role-based welcome page
│   ├── Question.juava               # Question class to initizliae a question
│   ├── Questions.java               # Keeps track of and lists the list of questions
│   ├── Answer.java                  # Answer class to initizlize an answer
│   ├── Answers.java                 # Keeps track of and lists the answers and associated questions
│   ├── Clarification.java           # Keeps track of and initizlizes the Comments/Clarifications for questions
│   ├── StudentHomePage.java         # The Home Page for Student users
│   ├── QAHomePage.java              # The home page to access the Questions and Answers posted within
│   ├── AdminHomePage.java           # Home page for admin users
│   ├── UserHomePage.java            # Home page for regular users
│   ├── InvitationPage.java          # Admin invitation code generation
│   ├── User.java                    # User entity (username, password, role)
│
├── databasePart1
│   ├── DatabaseHelper.java          # Manages database connection and queries
│
├── module-info.java                 # Java module system configuration

Installation and Setup
1. Prerequisites
  -Java JDK 11+ installed
  -JavaFX SDK (ensure your IDE is configured to support JavaFX)
  -H2 Database (embedded database, no external setup required)
2. Clone the Repository
  sh
  Copy
  Edit
  git clone <repository-url>
  cd CSE360-UserManagement
3. Run the Application
  -Open the project in your IDE (IntelliJ IDEA, Eclipse, or VS Code with Java support).
  -Ensure JavaFX dependencies are correctly configured.
  -Run the StartCSE360.java file.
Database Structure
  The system uses an H2 database (FoundationDatabase) with the following tables:
    -CSE360users (Stores user Credentials (username, password, role)) 
    -InvitationCoded (Tracks Admin generated invitation codes)

Usage
First-Time Setup:
  -The first user creates an admin account.
  -The admin logs in and can generate invitation codes.
User Registration:
  -Users register with a username, password, and invitation code.
Login & Navigation:
  -After login, users are redirected to their respective pages based on their roles.
Admin Actions:
  -Generate invitation codes for new users.
  -Manage user roles and permissions.
Technologies Used
  -Java 11+ (Core Programming language)
  -JavaFX (UI Framework)
  -H2 Database (Embedded SQL Database)
  -JDBC (Database Connectivity)
Future Enhancements
  -Implement password hashing for better security.
  -Add an admin dashboard with user management options.
  -Introduce email verification for account activation.
  -Enhance UI/UX with additional JavaFX components.

Contributors
  -Daniel Campanella
  -Anshika Rai
  -Landen Webb
  -Danny Diaz Aguirre
  -Sam Oroud

Username and Password input fields validation requirements
  -Username must START with a capital letter.
  -Password MUST be 8 or MORE character, and Needs at least 1 capital letter and a special character from:   ~`!@#$%^&*()_-+={}[]|:;<>,.?/“

