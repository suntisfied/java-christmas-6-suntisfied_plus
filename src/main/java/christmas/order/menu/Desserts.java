package christmas.order.menu;

public enum Desserts implements Menu {
    CHOCOLATE_CAKE(15000, "dessert"),
    ICE_CREAM(5000, "dessert");

    private final int price;
    private final String category;

    Desserts(int price, String category) {
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
