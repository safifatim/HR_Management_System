# HR Management System – Java Swing

This project is a desktop-based HR Management System developed in Java using the Swing framework. The application provides an interactive graphical interface to manage employees while applying fundamental Data Structures and Algorithms concepts in a practical way.

---

## 📘 System Description
The application is designed to assist an organization in handling essential HR operations through a GUI-based system. It allows users to store, organize, and process employee information efficiently while ensuring better understanding of algorithmic logic.

The system supports:
- Employee registration and record management
- Automatic sorting of employee data
- Fast searching of employee records
- Attendance tracking (entry and exit time)
- Salary computation based on working hours

---

## 🧱 Core Modules

### 1. Employee Data Model
- Stores employee details such as:
  - Employee Name
  - Employee ID
  - Entry Time
  - Exit Time
- Acts as the central data structure for all HR operations

---

### 2. Employee Sorting (Insertion Sort)
- Employees are arranged in ascending order of Employee ID
- Insertion Sort is used to maintain order
- Sorting is triggered automatically after adding a new employee
- Each sorting step is visualized using GUI dialog boxes

**Why Insertion Sort?**
- Easy to implement and understand
- Efficient for small data sets
- Commonly used for academic learning

---

### 3. Employee Search (Binary Search)
- Employee records are located using Binary Search
- Requires the employee list to be sorted
- Provides faster search performance
- Used during:
  - Attendance marking
  - Exit time recording
  - Salary calculation

---

### 4. Interview Handling Module
- Displays predefined interview questions
- Implemented using a scrollable Swing window
- Simulates a basic interview environment

---

### 5. Attendance Tracking
- Entry and exit times are recorded automatically
- System time is captured using Java Time API
- Ensures accurate attendance records

---

### 6. Salary Processing
- Salary is computed using:
  - Entry time
  - Exit time
  - Fixed hourly wage
- Total working hours are calculated using time difference logic

---

## 🛠️ Tools and Technologies
- Java
- Java Swing
- Java AWT
- Java Time API

---

## 🎓 Learning Objectives
- Practical implementation of Insertion Sort
- Efficient searching using Binary Search
- Strong understanding of OOP principles
- Hands-on experience with Java Swing GUI
- Working with real-time date and time in Java

---

## ▶️ Execution Steps
1. Open the project in any Java IDE (IntelliJ IDEA, Eclipse, or NetBeans)
2. Run the `HR_Management_System.java` file
3. Use the GUI buttons to interact with the system

---

## 👩‍💻 Developer
Fatima Safi  
Software Engineering Student

---

## 📄 Note
This project is developed for academic and learning purposes.
