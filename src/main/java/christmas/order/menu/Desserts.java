package christmas.order.menu;

public enum Desserts implements Menu {
    CHOCOLATE_CAKE(15000),
    ICE_CREAM(5000);

    private final int price;

    Desserts(int price) {
        this.price = price;
    }

    @Override
    public Price getPrice() {
        return new Price(price);
    }
}
