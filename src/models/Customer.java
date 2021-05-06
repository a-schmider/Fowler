package models;

import java.util.Vector;

public class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<>();

    private double totalPrice = 0;
    private int totalFrequentPoints = 0;


    public Customer (String name){
        this.name = name;
    }


    public void addRental(Rental rental) {
        rentals.addElement(rental);
        totalPrice += rental.getPrice();
        totalFrequentPoints += rental.getRenterPoints();
    }

    public String getName (){
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + this.getName() + "\n";
        result = result.concat("\tTitle\t\tDays\tAmount" + "\n");

        for (Rental currentRental : rentals) {
            //show figures for this rental
            result = result.concat("\t" + currentRental.getMovie().getTitle()+ "\t\t" +
                    currentRental.getDaysRented() + "\t" + currentRental.getPrice() + "\n");
        }

        //add footer lines
        result = result.concat("Amount owed is " + totalPrice + "\n");
        result = result.concat("You earned " + totalFrequentPoints + " frequent renter points");
        return result;
    }

}
    