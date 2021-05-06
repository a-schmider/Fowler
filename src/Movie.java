public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDREN = 2;

    private String title;
    private int priceCode;


    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }


    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle (){
        return title;
    }

    public double getBasePrice() {
        double price = 0;

        switch (priceCode) {
            case REGULAR:
                price = 2;
                break;
            case CHILDREN:
                price = 1.5;
        }

        return price;
    }
}