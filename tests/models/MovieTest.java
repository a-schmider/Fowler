package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    private Movie movie;

    @BeforeEach
    void setup() {
        movie = new Movie("Movie Title", 0);
    }

    @Test
    void getPriceCode() {
        Assertions.assertEquals(0, movie.getPriceCode());
    }


    @Test
    void getTitle() {
        Assertions.assertEquals("Movie Title", movie.getTitle());
    }

    @Test
    void getBasePrice() {
        Assertions.assertEquals(2, movie.getBasePrice());
    }
}