package christmas.converter;

public enum Delimiters {
    DELIMITER_ORDER(","),
    DELIMITER_NAME_WITH_VOLUME("-"),
    ;

    private final String delimiter;

    Delimiters(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
