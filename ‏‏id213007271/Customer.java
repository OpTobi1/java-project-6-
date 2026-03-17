// Assignment: 1
// Author: Liav Lugasi, ID: 213007271

package id213007271;

/**
 * This class represents a customer in the pizzeria.
 */

public class Customer {
    private String firstName;
    private String lastName;
    private String phoneNum;

    /**
     * Parameterized constructor.
     * @param firstName The first name of the customer
     * @param lastName The last name of the customer
     * @param phoneNum The phone number of the customer
     */

    public Customer(String firstName,String lastName,String phoneNum){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
    }

    /**
     * Copy constructor.
     * @param other The customer to copy
     */
    public Customer(Customer other) {
        if (other != null) {
            this.firstName = other.firstName;
            this.lastName = other.lastName;
            this.phoneNum = other.phoneNum;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phoneNum;
    }

    public void setPhone(String phone) {
        this.phoneNum = phone;
    }

    /**
     * Returns a string representation of the customer.
     * @return Customer details as a formatted string.
     */

    @Override
    public String toString() {
        return "Customer Details:\n" +
                "Name: " + this.firstName + " " + this.lastName + ", Phone: " + this.phoneNum;
    }
}
