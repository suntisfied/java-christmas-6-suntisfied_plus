package christmas.order.menu;

import christmas.order.Price;

public enum Drinks implements Menu {
    ZERO_COLA(3000),
    RED_WINE(60000),
    CHAMPAGNE(25000);

    private final int price;

    Drinks(int price) {
        this.price = price;
    }

    @Override
    public Price getPrice() {
        return new Price(price);
    }
}
