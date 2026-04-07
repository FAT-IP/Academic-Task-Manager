import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * MPU COMP2116 Software Engineering Final Project
 * Project Name: Academic Task Manager
 * Team: Group Project (5 Members)
 * Features: Deadline Sorting, File Auto-Save, Task Deletion
 */

class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String subject;
    private LocalDate deadline;
    private double progress; // 0.0 to 100.0

    public Task(String title, String subject, String deadlineDate) {
        this.title = title;
        this.subject = subject;
        this.deadline = LocalDate.parse(deadlineDate);
        this.progress = 0.0;
    }

    public long getDaysRemaining() {
        return ChronoUnit.DAYS.between(LocalDate.now(), deadline);
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void updateProgress(double p) {
        this.progress = Math.min(100.0, Math.max(0.0, p));
    }

    public void display() {
        long days = getDaysRemaining();
        String status;
        String priority = "";

        if (days < 0) {
            status = "[OVERDUE]";
        } else if (days == 0) {
            status = "[DUE TODAY]";
            priority = " [!!! HIGH PRIORITY]";
        } else {
            status = days + " days left";
            if (days <= 3) {
                priority = " [! URGENT]";
            }
        }
        
        System.out.printf("%-20s | %-12s | %-12s | %-6.1f%% | %s%s\n", 
            title, subject, deadline, progress, status, priority);
    }

    public String getTitle() { return title; }
}

public class AcademicTaskManager {
    private static List<Task> tasks = new ArrayList<>();
    private static final String FILE_NAME = "tasks_data.dat";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=====================================================");
        System.out.println("   Macao Polytechnic University - COMP2116 Project   ");
        System.out.println("             ACADEMIC TASK MANAGER (v1.2)            ");
        System.out.println("=====================================================");
        
        // Load existing data from file
        loadTasksFromFile();

        // If no file exists, load initial demo data
        if (tasks.isEmpty()) {
            initDemoData();
        }

        while (true) {
            printDashboard();
            System.out.println("\n[1] Add Task  [2] Update Progress  [3] Delete Task  [4] Save & Exit");
            System.out.print("Select Option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addNewTask();
                    saveTasksToFile(); 
                    break;
                case "2":
                    updateTaskProgress();
                    saveTasksToFile(); 
                    break;
                case "3":
                    deleteTask();
                    saveTasksToFile();
                    break;
                case "4":
                    saveTasksToFile();
                    System.out.println("Data saved. Exiting System... Good luck!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void printDashboard() {
        System.out.println("\n--- CURRENT TASK LIST (Sorted by Deadline) ---");
        System.out.printf("%-20s | %-12s | %-12s | %-7s | %s\n", 
            "Task Title", "Subject", "Deadline", "Progress", "Status");
        System.out.println("---------------------------------------------------------------------------------------");
        
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            // Sorting Logic: Sort tasks by deadline ascending
            List<Task> sortedTasks = tasks.stream()
                .sorted(Comparator.comparing(Task::getDeadline))
                .collect(Collectors.toList());

            for (Task t : sortedTasks) {
                t.display();
            }
        }
    }

    private static void addNewTask() {
        try {
            System.out.print("Enter Task Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter Subject Code: ");
            String subject = scanner.nextLine();
            System.out.print("Enter Deadline (YYYY-MM-DD): ");
            String date = scanner.nextLine();
            
            tasks.add(new Task(title, subject, date));
            System.out.println("SUCCESS: Task added successfully.");
        } catch (DateTimeParseException e) {
            System.out.println("ERROR: Invalid date format. Use YYYY-MM-DD.");
        }
    }

    private static void updateTaskProgress() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to update.");
            return;
        }
        System.out.print("Enter Task Title to update: ");
        String search = scanner.nextLine();
        
        for (Task t : tasks) {
            if (t.getTitle().equalsIgnoreCase(search)) {
                System.out.print("Enter new progress (0-100): ");
                try {
                    double p = Double.parseDouble(scanner.nextLine());
                    t.updateProgress(p);
                    System.out.println("SUCCESS: Progress updated.");
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: Please enter a valid number.");
                }
                return;
            }
        }
        System.out.println("ERROR: Task not found.");
    }

    // NEW FEATURE: Delete Task from the list
    private static void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to delete.");
            return;
        }
        System.out.print("Enter Task Title to DELETE: ");
        String search = scanner.nextLine();
        
        boolean removed = tasks.removeIf(t -> t.getTitle().equalsIgnoreCase(search));
        
        if (removed) {
            System.out.println("SUCCESS: Task '" + search + "' has been removed.");
        } else {
            System.out.println("ERROR: Task not found.");
        }
    }

    private static void saveTasksToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            System.out.println("ERROR: Could not save data to file.");
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadTasksFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            tasks = (List<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("INFO: No previous data found or file corrupted. Starting fresh.");
        }
    }

    private static void initDemoData() {
        tasks.add(new Task("Final Project", "COMP2116", LocalDate.now().plusDays(2).toString()));
        tasks.add(new Task("SQL Lab", "COMP2112", LocalDate.now().plusDays(10).toString()));
        tasks.add(new Task("Mid-term Essay", "ENGL101", LocalDate.now().minusDays(1).toString()));
    }
}