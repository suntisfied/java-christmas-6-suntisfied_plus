package christmas.order.menu;

public enum Appetizers implements Menu {
    MUSHROOM_CREAM_SOUP(6000, "appetizer"),
    TAPAS(5500, "appetizer"),
    CAESAR_SALAD(8000, "appetizer");

    private final int price;
    private final String category;

    Appetizers(int price, String category) {
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
