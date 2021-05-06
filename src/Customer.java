import java.lang.*;
import java.util.*;

class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<>();


    public Customer (String name){
        this.name = name;
    }


    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName (){
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        double thisAmount;
        Rental rental;
        while (enum_rentals.hasMoreElements()) {
            rental = enum_rentals.nextElement();

            //determine amounts for each line
            thisAmount = rental.getPrice();

            // add frequent renter points
            frequentRenterPoints = rental.getRenterPoints();

            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle()+ "\t\t" + rental.getDaysRented() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

}
    