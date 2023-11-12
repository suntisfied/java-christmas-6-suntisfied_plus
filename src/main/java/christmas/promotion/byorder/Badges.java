package christmas.promotion.byorder;

public enum Badges {
    NONE("없음"),
    STAR("스타"),
    TREE("트리"),
    SANTA("산타");

    private final String name;

    Badges(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
