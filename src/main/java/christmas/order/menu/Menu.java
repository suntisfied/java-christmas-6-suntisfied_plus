package christmas.order.menu;

public enum Menu {
    MUSHROOM_CREAM_SOUP(6000, Category.APPETIZER),
    TAPAS(5500, Category.APPETIZER),
    CAESAR_SALAD(8000, Category.APPETIZER),
    T_BONE_STEAK(55000, Category.MAIN_DISH),
    BARBECUE_RIBS(54000, Category.MAIN_DISH),
    SEAFOOD_PASTA(35000, Category.MAIN_DISH),
    CHRISTMAS_PASTA(25000, Category.MAIN_DISH),
    CHOCOLATE_CAKE(15000, Category.DESSERT),
    ICE_CREAM(5000, Category.DESSERT),
    ZERO_COLA(3000, Category.DRINK),
    RED_WINE(60000, Category.DRINK),
    CHAMPAGNE(25000, Category.DRINK);

    private final int price;
    private final Category category;

    Menu(int price, Category category) {
        this.price = price;
        this.category = category;
    }

    public Price getPrice() {
        return new Price(price);
    }

    public Category getCategory() {
        return category;
    }
}
