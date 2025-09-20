import java.util.Scanner;

public class ExpenseTrackerApp {
    private ExpenseService expenseService; 
    private Scanner scanner;

    public ExpenseTrackerApp() { //constructor
        expenseService = new ExpenseService();
        scanner = new Scanner(System.in);
    }

    public void start() { //main loop - shows menu 
        int choice;
        do {
            System.out.println("\n=== Expense Tracker Menu ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Calculate Total Expenses");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt(); //reads user choice
            scanner.nextLine(); // consume newline

            switch (choice) { //action to perform based on user choice
                case 1 -> addExpense();
                case 2 -> expenseService.viewExpenses();
                case 3 -> expenseService.calculateTotal();
                case 4 -> deleteExpense();
                case 5 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5); //do-while keeps repeating until user chooses case 5
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
