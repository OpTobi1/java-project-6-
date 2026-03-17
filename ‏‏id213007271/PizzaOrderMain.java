// Assignment: 1
// Author: Liav Lugasi, ID: 213007271

package id213007271;
import java.util.Random;

/**
 * Main class to manage pizzeria orders.
 */

public class PizzaOrderMain {

    /**
     * Selects a random un-ordered order, asks the user to fill it,
     * and moves it to the in-progress array.
     * @param openOrder Array of orders that haven't been processed yet
     * @param inProgressOrders Array of orders that are in preparation
     */

    public static void callCustomerToOrder(PizzaOrder[] openOrder, PizzaOrder[] inProgressOrders) {
        Random x = new Random();
        int i;

        // Find a random open order
        while (true) {
            i = x.nextInt(openOrder.length);
            if (openOrder[i] != null) {
                break;
            }
        }

        PizzaOrder currentOrder = openOrder[i];
        currentOrder.order();                               // Start ordering process
        System.out.println(currentOrder.toString());        // Print receipt
        System.out.println();

        // Move to in-progress
        for (int j = 0; j < inProgressOrders.length; j++) {
            if (inProgressOrders[j] == null) {
                inProgressOrders[j] = currentOrder;
                break;
            }
        }

        // Remove from open orders
        openOrder[i] = null;
    }

    /**
     * Selects a random order from in-progress that hasn't been picked up,
     * marks it as ready, and notifies the customer.
     * @param inProgressOrders Array of orders that are in preparation
     */

    public static void callCustomerToPickup(PizzaOrder[] inProgressOrders) {
        Random x = new Random();
        int i;

        // Find a random order in progress that is not ready yet
        while (true) {
            i = x.nextInt(inProgressOrders.length);
            if (inProgressOrders[i] != null && !inProgressOrders[i].isReady()) {
                break;
            }
        }

        PizzaOrder currentOrder = inProgressOrders[i];
        currentOrder.setReady(true);
        System.out.println(currentOrder.getCustomer().getFirstName() + ", your order is ready! Please come and collect it.");
    }


    public static void main(String[] args) {
        // a. Create arrays
        PizzaOrder[] openOrder = new PizzaOrder[4];
        PizzaOrder[] inProgressOrders = new PizzaOrder[4];

        // b. Create 4 static orders
        openOrder[0] = new PizzaOrder("Liav", "Lugasi", "050-6767676");
        openOrder[1] = new PizzaOrder("Tomer", "Ben-Ari", "052-1234567");
        openOrder[2] = new PizzaOrder("Gilad", "Peretz", "054-3334444");
        openOrder[3] = new PizzaOrder("Amir", "Ashuri Biton", "053-4321090");

        // c. Perform orders in random order
        for (int i = 0; i < 4; i++) {
            callCustomerToOrder(openOrder, inProgressOrders);
        }

        // d. Prepare and pickup pizzas in random order
        for (int i = 0; i < 4; i++) {
            callCustomerToPickup(inProgressOrders);
        }
    }
}
