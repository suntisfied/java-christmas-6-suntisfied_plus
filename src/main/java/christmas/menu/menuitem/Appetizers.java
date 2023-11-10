package christmas.menu.menuitem;

import christmas.menu.Price;

public enum Appetizers implements Menu {
    MUSHROOM_CREAM_SOUP(6000),
    TAPAS(5500),
    CAESAR_SALAD(8000);

    private final int price;

    Appetizers(int price) {
        this.price = price;
    }

    @Override
    public Price getPrice() {
        return new Price(price);
    }
}
