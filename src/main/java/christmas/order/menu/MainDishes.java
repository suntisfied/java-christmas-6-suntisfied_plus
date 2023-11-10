package christmas.order.menu;

import christmas.order.Price;

public enum MainDishes implements Menu {
    T_BONE_STEAK(55000),
    BARBECUE_RIBS(54000),
    SEAFOOD_PASTA(35000),
    CHRISTMAS_PASTA(25000);

    private final int price;

    MainDishes(int price) {
        this.price = price;
    }

    @Override
    public Price getPrice() {
        return new Price(price);
    }
}
