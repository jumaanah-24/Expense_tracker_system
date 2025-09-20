public class Expense {
    private int id;
    private String description;
    private double amount;

    public Expense(int id, String description, double amount) {
        //method to create objects
        //assigns the value passed as the instance variable
        this.id = id; 
        this.description = description;
        this.amount = amount;
    }
    //getter method
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
