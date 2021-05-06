package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    public void setup() {
        customer = new Customer("Chris");
    }

    @Test
    void getName() {
        Assertions.assertEquals("Chris", customer.getName());
    }

    @Test
    void addRental() {
        customer.addRental(new Rental(new Movie("Saw", 0), 10));
        Assertions.assertEquals(1, customer.getTotalFrequentPoints());
        Assertions.assertEquals(14, customer.getTotalPrice());
    }

    @Test
    void statement() {
        String result = """
                Rental Record for Chris
                \tTitle\t\tDays\tAmount
                Amount owed is 0.0
                You earned 0 frequent renter points""";

        Assertions.assertEquals(result, customer.statement());
    }
}