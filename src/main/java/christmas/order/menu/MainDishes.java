package christmas.order.menu;

public enum MainDishes implements Menu {
    T_BONE_STEAK(55000, "maindish"),
    BARBECUE_RIBS(54000, "maindish"),
    SEAFOOD_PASTA(35000, "maindish"),
    CHRISTMAS_PASTA(25000, "maindish");

    private final int price;
    private final String category;

    MainDishes(int price, String category) {
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
