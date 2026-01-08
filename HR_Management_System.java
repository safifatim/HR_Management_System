import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.util.*;

// ================= Employee Class =================
class Employee {
    String name;
    String id;
    LocalDateTime entryTime;
    LocalDateTime exitTime;

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
        this.entryTime = null;
        this.exitTime = null;
    }
}

// ================= Interview Class =================
class Interview {
    private String[] questions = {
            "Tell me about yourself.",
            "Why do you want to work here?",
            "What are your strengths?",
            "What are your weaknesses?",
            "Where do you see yourself in 5 years?",
            "How do you handle pressure?",
            "Why should we hire you?",
            "What is your expected salary?",
            "Do you have any experience?",
            "Are you willing to relocate?"
    };

    public void conductInterview() {
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < questions.length; i++) {
            sb.append((i + 1)).append(". ").append(questions[i]).append("\n\n");
        }

        area.setText(sb.toString());
        JScrollPane pane = new JScrollPane(area);
        pane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(null, pane, "Interview Questions", JOptionPane.INFORMATION_MESSAGE);
    }
}

// ================= Salary Calculator =================
class SalaryCalculator {
    private static final double HOURLY_RATE = 500;

    public static double calculateSalary(LocalDateTime entry, LocalDateTime exit) {
        long hours = Duration.between(entry, exit).toHours();
        if (hours <= 0) return 0;
        return hours * HOURLY_RATE;
    }
}

// ================= Main Class =================
public class HR_Management_System {

    // ArrayList for sorting & binary search
    private static ArrayList<Employee> employeeList = new ArrayList<>();

    // ================= Selection Sort =================
    public static void selectionSortById() {
        int n = employeeList.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (employeeList.get(j).id.compareTo(employeeList.get(minIndex).id) < 0) {
                    minIndex = j;
                }
            }

            Employee temp = employeeList.get(i);
            employeeList.set(i, employeeList.get(minIndex));
            employeeList.set(minIndex, temp);
        }
    }

    // ================= Binary Search =================
    public static Employee binarySearchById(String id) {
        int left = 0;
        int right = employeeList.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = employeeList.get(mid).id.compareTo(id);

            if (cmp == 0)
                return employeeList.get(mid);
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }
    // ================= Show Employees GUI =================
    public static void showEmployeesGUI() {

        if (employeeList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No employees registered yet.");
            return;
        }

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        StringBuilder sb = new StringBuilder();
        sb.append("EMPLOYEE LIST (Sorted by ID)\n");
        sb.append("---------------------------------\n\n");

        for (Employee e : employeeList) {
            sb.append("ID: ").append(e.id).append("\n");
            sb.append("Name: ").append(e.name).append("\n");
            sb.append("---------------------------------\n");
        }

        area.setText(sb.toString());

        JScrollPane pane = new JScrollPane(area);
        pane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(null, pane, "Employees", JOptionPane.INFORMATION_MESSAGE);
    }


    // ================= Main Method =================
    public static void main(String[] args) {

        JFrame frame = new JFrame("HR Management System");
        frame.setSize(500, 250);
        frame.setLayout(new GridLayout(2, 3, 10, 10));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton registerBtn = new JButton("Register Employee");
        JButton interviewBtn = new JButton("Conduct Interview");
        JButton entryBtn = new JButton("Mark Entry Time");
        JButton exitBtn = new JButton("Mark Exit Time");
        JButton salaryBtn = new JButton("Calculate Salary");
        JButton showBtn = new JButton("Show Employees");


        // ================= Register =================
        registerBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Employee Name:");
            if (name == null || name.trim().isEmpty()) return;

            String id = JOptionPane.showInputDialog("Enter Employee ID:");
            if (id == null || id.trim().isEmpty()) return;

            if (binarySearchById(id.trim()) != null) {
                JOptionPane.showMessageDialog(frame, "Employee ID already exists.");
                return;
            }

            Employee emp = new Employee(name.trim(), id.trim());
            employeeList.add(emp);

            selectionSortById(); // IMPORTANT

            JOptionPane.showMessageDialog(frame, "Employee Registered Successfully");
        });

        // ================= Interview =================
        interviewBtn.addActionListener(e -> new Interview().conductInterview());

        // ================= Entry =================
        entryBtn.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Enter Employee ID:");
            Employee emp = binarySearchById(id);

            if (emp == null) {
                JOptionPane.showMessageDialog(frame, "Employee not found.");
                return;
            }

            emp.entryTime = LocalDateTime.now();
            JOptionPane.showMessageDialog(frame, "Entry Time Marked: " + emp.entryTime);
        });

        // ================= Exit =================
        exitBtn.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Enter Employee ID:");
            Employee emp = binarySearchById(id);

            if (emp == null || emp.entryTime == null) {
                JOptionPane.showMessageDialog(frame, "Invalid entry data.");
                return;
            }

            emp.exitTime = LocalDateTime.now();
            JOptionPane.showMessageDialog(frame, "Exit Time Marked: " + emp.exitTime);
        });

        // ================= Salary =================
        salaryBtn.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Enter Employee ID:");
            Employee emp = binarySearchById(id);

            if (emp == null || emp.entryTime == null || emp.exitTime == null) {
                JOptionPane.showMessageDialog(frame, "Incomplete data.");
                return;
            }

            double salary = SalaryCalculator.calculateSalary(emp.entryTime, emp.exitTime);
            JOptionPane.showMessageDialog(frame, "Total Salary: Rs. " + salary);
        });

        // ================= Salary =================
        salaryBtn.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Enter Employee ID:");
            Employee emp = binarySearchById(id);

            if (emp == null || emp.entryTime == null || emp.exitTime == null) {
                JOptionPane.showMessageDialog(frame, "Incomplete data.");
                return;
            }

            double salary = SalaryCalculator.calculateSalary(emp.entryTime, emp.exitTime);
            JOptionPane.showMessageDialog(frame, "Total Salary: Rs. " + salary);
        });

// ================= Show Employees =================
        showBtn.addActionListener(e -> showEmployeesGUI());


        frame.add(registerBtn);
        frame.add(interviewBtn);
        frame.add(entryBtn);
        frame.add(exitBtn);
        frame.add(salaryBtn);
        frame.add(showBtn);

        frame.setVisible(true);
    }
}