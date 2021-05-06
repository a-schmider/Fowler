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
        Movie movie;
        int daysRented;
        while (enum_rentals.hasMoreElements()) {
            rental = enum_rentals.nextElement();

            //determine amounts for each line
            thisAmount = rental.getPrice();

            // add frequent renter points
            frequentRenterPoints++;

            movie = rental.getMovie();
            daysRented = rental.getDaysRented();

            // add bonus for a two day new release rental
            if ((movie.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
                frequentRenterPoints++;

            //show figures for this rental
            result += "\t" + movie.getTitle()+ "\t\t" + daysRented + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

}
    