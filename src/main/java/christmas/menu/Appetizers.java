package christmas.menu;

public enum Appetizers {
    MUSHROOM_CREAM_SOUP(6000),
    TAPAS(5500),
    CAESAR_SALAD(8000);

    private final int price;

    Appetizers(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
