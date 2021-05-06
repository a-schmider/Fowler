package models;

public class Rental {

    private Movie movie;
    private int daysRented;


    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }


    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getPrice() {
        double basePrice = movie.getBasePrice();

        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                if (getDaysRented() > 2)
                    basePrice += (getDaysRented() - 2) * 1.5;
                break;

            case Movie.NEW_RELEASE:
                basePrice += getDaysRented() * 3;
                break;

            case Movie.CHILDREN:
                if (getDaysRented() > 3)
                    basePrice += (getDaysRented() - 3) * 1.5;
                break;
        }

        return basePrice;
    }

    public int getRenterPoints() {
        if ((movie.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2;
        }

        return 1;
    }
}