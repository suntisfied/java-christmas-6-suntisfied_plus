package christmas.order.menu;

public enum Drinks implements Menu {
    ZERO_COLA(3000,"drink"),
    RED_WINE(60000,"drink"),
    CHAMPAGNE(25000,"drink");

    private final int price;
    private final String category;

    Drinks(int price, String category) {
        this.price = price;
        this.category = category;
    }

    @Override
    public Price getPrice() {
        return new Price(price);
    }

    @Override
    public String getCategory() {
        return category;
    }
}
