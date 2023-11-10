package christmas.menu;

public enum MainDishes {
    T_BONE_STEAK(55000),
    BARBECUE_RIBS(54000),
    SEAFOOD_PASTA(35000),
    CHRISTMAS_PASTA(25000);

    private final int price;

    MainDishes(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
