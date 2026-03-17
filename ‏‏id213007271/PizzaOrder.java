// Assignment: 1
// Author: Liav Lugasi, ID: 213007271

package id213007271;
import java.util.Scanner;

/**
 * This class represents a pizza order containing multiple pizzas for a specific customer.
 */

public class PizzaOrder {
    private Customer customer;
    private Pizza[] pizzas;
    private boolean isOrdered;
    private boolean isReady;

    /**
     * Parameterized constructor.
     * @param firstName First name of the ordering customer
     * @param lastName Last name of the ordering customer
     * @param phoneNum Phone number of the ordering customer
     */

    public PizzaOrder(String firstName, String lastName, String phoneNum) {
        this.customer = new Customer(firstName, lastName, phoneNum);
        this.pizzas = null;
        this.isOrdered = false;
        this.isReady = false;
    }

    /**
     * Copy constructor.
     * @param other The order to copy
     */
    public PizzaOrder(PizzaOrder other){
        if(other != null){
            this.customer = new Customer(other.customer);
            this.isOrdered = other.isOrdered;
            this.isReady = other.isReady;
        }

        if (other.pizzas != null) {
            this.pizzas = new Pizza[other.pizzas.length];
            for (int i = 0; i < other.pizzas.length; i++) {
                this.pizzas[i] = new Pizza(other.pizzas[i]);
            }
        }

        else {
            this.pizzas = null;
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Pizza[] getPizzas() {
        return pizzas;
    }

    public void setPizzas(Pizza[] pizzas) {
        this.pizzas = pizzas;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
    public void setOrdered(boolean isOrdered) {
        this.isOrdered = isOrdered;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean isReady) {
        this.isReady = isReady;
    }

    /**
     * Handles the ordering process by taking input from the user for the pizzas.
     */

    public void order(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of pizzas for " + this.customer.getFirstName() + " " + this.customer.getLastName() + ":");
        int numPizzas = scan.nextInt();
        this.pizzas = new Pizza[numPizzas];

        for (int i = 0; i < numPizzas; i++) {
            System.out.println("Pizza #" + (i + 1) + ":");

            System.out.print("Select size (0 = Small, 1 = Medium, 2 = Large): ");
            int size = scan.nextInt();

            System.out.print("Extra Cheese (true/false): ");
            boolean extraCheese = scan.nextBoolean();

            System.out.print("Olives (true/false): ");
            boolean olives = scan.nextBoolean();

            System.out.print("Onions (true/false): ");
            boolean onions = scan.nextBoolean();

            this.pizzas[i] = new Pizza(size, extraCheese, olives, onions);
        }

        this.isOrdered = true;
    }

    /**
     * Calculates the total cost of all pizzas in the order.
     * @return The total price.
     */

    public int calcTotal() {
        int total = 0;

        if (this.pizzas != null) {
            for(int i = 0; i < this.pizzas.length; i++){
                total += this.pizzas[i].calcCost();
            }
        }
        return total;
    }

    /**
     * Returns a string representation of the full order details.
     * @return The receipt as a formatted string.
     */

    @Override
    public String toString() {
        String result = this.customer.toString() + "\n";

        if (this.pizzas != null) {
            for (int i = 0; i < this.pizzas.length; i++) {
                result += "Pizza #" + (i + 1) + ":\n";
                result += this.pizzas[i].toString() + "\n";
            }
        }

        result += "Total Price: " + calcTotal();
        return result;
    }
}
