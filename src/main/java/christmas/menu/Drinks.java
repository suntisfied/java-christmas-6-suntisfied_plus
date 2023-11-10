package christmas.menu;

public enum Drinks {
    ZERO_COLA(3000),
    RED_WINE(60000),
    CHAMPAGNE(25000);

    private final int price;

    Drinks(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
