package christmas.view.input;

public record Date(int date) {
    public Date(int date) {
        this.date = date;
        validate(date);
    }

    private void validate(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException();
        }
    }
}
