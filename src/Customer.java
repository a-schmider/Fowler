import java.lang.*;
import java.util.*;

class Customer {

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

        Rental rental;
        Enumeration<Rental> enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            rental = enum_rentals.nextElement();

            //show figures for this rental
            result = result.concat("\t" + rental.getMovie().getTitle()+ "\t\t" + rental.getDaysRented() + "\t" + rental.getPrice() + "\n");
        }

        //add footer lines
        result = result.concat("Amount owed is " + totalPrice + "\n");
        result = result.concat("You earned " + totalFrequentPoints + " frequent renter points");
        return result;
    }

}
    