import java.util.ArrayList;
import java.util.List; //they allow to store and manage multiple Expense

public class ExpenseService {
    private List<Expense> expenses = new ArrayList<>(); //list to store all expense , intialize as empty array
    private int idCounter = 1;

    // Add expense
    public void addExpense(String description, double amount) {
        Expense expense = new Expense(idCounter++, description, amount);
        //creates new expense objects
        //idCounter++ assigns the current ID then increments the next one.

        expenses.add(expense);  //add expense to the list
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
            total += expense.getAmount(); //adds amt of each expense to total
        }
        System.out.println("💰 Total Expenses: ₹" + total);
    }

    // Delete expense by ID
    public void deleteExpense(int id) {
        Expense toRemove = null; //temporary variable to find the expense to delete.
        for (Expense expense : expenses) { //searches for expense with matching ID
            if (expense.getId() == id) {
                toRemove = expense;
                break;
            }
        }

        if (toRemove != null) { //if expense found ,removed
            expenses.remove(toRemove);
            System.out.println("🗑️ Expense deleted successfully.");
        } else {
            System.out.println("⚠️ Expense ID not found.");
        }
    }
}
