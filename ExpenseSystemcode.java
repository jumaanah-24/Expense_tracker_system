import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ------------------- Expense Class -------------------
class Expense {
    private int id;
    private String description;
    private double amount;

    public Expense(int id, String description, double amount) {
        this.id = id;
        this.description = description;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Expense ID: " + id + ", Description: " + description + ", Amount: ₹" + amount;
    }
}

// ------------------- ExpenseService Class -------------------
class ExpenseService {
    private List<Expense> expenses = new ArrayList<>();
    private int idCounter = 1;

    // Add expense
    public void addExpense(String description, double amount) {
        Expense expense = new Expense(idCounter++, description, amount);
        expenses.add(expense);
        System.out.println("✅ Expense added successfully!");
    }

    // View expenses
    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }
        System.out.println("\n--- List of Expenses ---");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    // Calculate total
    public void calculateTotal() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        System.out.println("💰 Total Expenses: ₹" + total);
    }

    // Delete expense by ID
    public void deleteExpense(int id) {
        Expense toRemove = null;
        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                toRemove = expense;
                break;
            }
        }

        if (toRemove != null) {
            expenses.remove(toRemove);
            System.out.println("🗑️ Expense deleted successfully.");
        } else {
            System.out.println("⚠️ Expense ID not found.");
        }
    }
}

// ------------------- ExpenseTrackerApp Class -------------------
class ExpenseTrackerApp {
    private ExpenseService expenseService;
    private Scanner scanner;

    public ExpenseTrackerApp() {
        expenseService = new ExpenseService();
        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("\n=== Expense Tracker Menu ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Calculate Total Expenses");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addExpense();
                case 2 -> expenseService.viewExpenses();
                case 3 -> expenseService.calculateTotal();
                case 4 -> deleteExpense();
                case 5 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    private void addExpense() {
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        expenseService.addExpense(description, amount);
    }

    private void deleteExpense() {
        System.out.print("Enter Expense ID to delete: ");
        int id = scanner.nextInt();
        expenseService.deleteExpense(id);
    }
}

// ------------------- Main Class -------------------
public class Main {
    public static void main(String[] args) {
        ExpenseTrackerApp app = new ExpenseTrackerApp();
        app.start();
    }
}
