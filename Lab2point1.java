package javaprojects;
import java.util.*;

public class Lab2point1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Item prices
        int soda = 0;
        int chips = 15;
        int chocolate = 20;

        // Get initial balance from the user with validation
        int balance = 0;
        while (true) {
            try {
            System.out.print("Enter your Initial Balance: ");
            balance = sc.nextInt(); // Expecting an integer input
            if (balance < 15) {
            System.out.println("Error: Balance cannot be less than $15. Please try again.");
            } else {
            break; // Exit the loop if a valid balance is entered
            }
            } catch (InputMismatchException e) {
            // Catch error if input is not an integer (like letters)
            System.out.println("Invalid input! Please Try again.");
            sc.next(); // Clear the invalid input
            }
            
        }
        boolean loop = true;
        // Loop for multiple transactions
        while (loop) {
            // Display available items
            System.out.println("Available items:");
            System.out.println("1. Soda = $25 \n2. Chips = $15 \n3. Chocolate = $20");
            
            // Get item selection from the user
            System.out.print("Enter the item number you want to buy: ");
            int sold = sc.nextInt();
            
            // Determine the price of the selected item
            int itemPrice = priceList(sold, soda, chips, chocolate);
            
            if (itemPrice > 0) {
                // Check if the user has enough balance
                if (balance >= itemPrice) {
                    // Check if the transaction would leave a balance of at least $15
                    if (balance - itemPrice < 0) {
                        System.out.println("Transaction denied: Your balance cannot drop below $15.");
                    } else {    
                        balance -= itemPrice; // Deduct the item price
                        System.out.println("Item purchased successfully!");
                        System.out.println("Remaining balance: $" + balance);
                    }
                } else {
                    System.out.println("Insufficient balance to purchase this item.");
                }
            } else {
                System.out.println("Invalid item number.");
            }

            // Check if user wants another transaction
            if (balance > 1) { // Only prompt if balance is greater than $15
                System.out.print("Do you want to make another transaction? (yes/no): ");
                String response = sc.next();

                if (!response.equalsIgnoreCase("yes")) {
                    System.out.print("Do you want to make another transaction? (yes/no): ");
                    response = sc.next();
                }
                
            } else {
                System.out.println("You have run out of balance or are at the minimum allowed balance of $15. No more transactions allowed.");
                break;
            }
        }

        System.out.println("Thank you for your transactions!");
        sc.close();
    }

    // Method to return the price of the selected item
    public static int priceList(int sold, int soda, int chips, int chocolate) {
        if (sold == 1) {
            return soda;
        } else if (sold == 2) {
            return chips;
        } else if (sold == 3) {
            return chocolate;
        } else {
            return -1; // Invalid selection
        }
    }
}
