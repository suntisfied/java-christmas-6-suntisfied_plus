package christmas.menu;

public enum Desserts {
    CHOCOLATE_CAKE(15000),
    ICE_CREAM(5000);

    private final int price;

    Desserts(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
