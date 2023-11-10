package christmas.menu;

public enum MenuItems {
    CHAMPAGNE(25000);

    private final int price;

    MenuItems(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
