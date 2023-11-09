package christmas.menu;

public enum Prices {
    CHAMPAGNE(25000);

    private final int price;

    Prices(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
