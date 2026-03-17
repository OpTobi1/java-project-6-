// Assignment: 1
// Author: Liav Lugasi, ID: 213007271

package id213007271;

/**
 * This class represents a Pizza with size and toppings.
 */

public class Pizza {
    private int size;
    private boolean extraCheese;
    private boolean olives;
    private boolean onions;

    /**
     * Default constructor. Initializes with default values (small size, no toppings).
     */
    public Pizza(){
        this.size = 0;               // 0=Small, 1=Medium, 2=Large
        this.extraCheese = false;
        this.olives = false;
        this.onions = false;
    }

    /**
     * Parameterized constructor.
     * @param size The size of the pizza (0, 1, or 2)
     * @param extraCheese True if extra cheese is requested
     * @param olives True if olives are requested
     * @param onions True if onions are requested
     */
    public Pizza(int size, boolean extraCheese, boolean olives, boolean onions){
        this.size = size;
        this.extraCheese = extraCheese;
        this.olives = olives;
        this.onions = onions;
    }

    /**
     * Copy constructor.
     * @param other The pizza object to copy
     */
    public Pizza (Pizza other) {
        if(other != null) {
            this.size = other.size;
            this.extraCheese = other.extraCheese;
            this.olives = other.olives;
            this.onions = other.onions;
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public boolean isOlives() {
        return olives;
    }

    public void setOlives(boolean olives) {
        this.olives = olives;
    }

    public boolean isOnions() {
        return onions;
    }

    public void setOnions(boolean onions) {
        this.onions = onions;
    }

    /**
     * Calculates the cost of the pizza based on its size and toppings.
     * @return The total cost of the pizza.
     */

    public int calcCost(){
        int sizePrice = 0;
        int toppingsPrice = 0;
        int toppingsCount = 0;

        if(this.extraCheese) toppingsCount++;
        if(this.olives) toppingsCount++;
        if(this.onions) toppingsCount++;

        switch (this.size){
            case 0:
                sizePrice = 35;
                toppingsPrice = 6;
                break;
            case 1:
                sizePrice = 45;
                toppingsPrice = 7;
                break;
            case 2:
                sizePrice = 60;
                toppingsPrice = 9;
                break;
        }
        return sizePrice + (toppingsPrice * toppingsCount);
    }

    /**
     * Returns a string representation of the pizza.
     * @return Pizza details as a formatted string.
     */

    @Override
    public String toString() {
        String sizeStr = "";

        switch (this.size) {
            case 0: sizeStr = "Small"; break;
            case 1: sizeStr = "Medium"; break;
            case 2: sizeStr = "Large"; break;
        }

        String cheeseStr = this.extraCheese ? "Yes" : "No";
        String olivesStr = this.olives ? "Yes" : "No";
        String onionsStr = this.onions ? "Yes" : "No";

        return "Pizza Details:\n" +
                "Size: " + sizeStr + "\n" +
                "Extra Cheese: " + cheeseStr + ", Olives: " + olivesStr + ", Onions: " + onionsStr + "\n" +
                "Price: " + calcCost();
    }
}

