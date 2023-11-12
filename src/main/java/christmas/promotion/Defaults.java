package christmas.promotion;

public enum Defaults {
    INITIAL_D_DAY_DISCOUNT(1000),
    MINIMUM_ORDER_FOR_FREE_GIFT(12000),
    NUMBER_OF_FREE_GIFT(1),
    ;

    private final int number;

    Defaults(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
