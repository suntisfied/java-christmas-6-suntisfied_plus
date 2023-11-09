package christmas.promotion;

public enum Defaults {
    INITIAL_D_DAY_DISCOUNT(1000);

    private final int number;

    Defaults(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
