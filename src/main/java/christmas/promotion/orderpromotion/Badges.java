package christmas.promotion.orderpromotion;

import christmas.promotion.Discount;

public enum Badges {
    NONE(0, "없음", new Discount(0)),
    STAR(5000,"스타", new Discount(0)),
    TREE(10000, "트리", new Discount(0)),
    SANTA(20000, "산타", new Discount(0));

    private final int requiredOrder;
    private final String name;
    private final Discount discount;

    Badges(int requiredOrder, String name, Discount discount) {
        this.requiredOrder = requiredOrder;
        this.name = name;
        this.discount = discount;
    }

    public int getRequiredOrder() {
        return requiredOrder;
    }

    public String getName() {
        return name;
    }

    public Discount getDiscount() {
        return discount;
    }
}
