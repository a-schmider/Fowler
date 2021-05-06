package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {

    private Rental rental;
    private Movie movie;

    @BeforeEach
    public void setup() {
        movie = new Movie("Title", 0);
        rental = new Rental(movie, 10);
    }

    @Test
    void getDaysRented() {
        Assertions.assertEquals(10, rental.getDaysRented());
    }

    @Test
    void getMovie() {
        Assertions.assertEquals(movie, rental.getMovie());
    }

    @Test
    void getPrice() {
        Assertions.assertEquals(2 + (10 - 2) * 1.5, rental.getPrice());
    }

    @Test
    void getRenterPoints() {
        Assertions.assertEquals(1, rental.getRenterPoints());
    }
}