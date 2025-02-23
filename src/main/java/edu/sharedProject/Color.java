package edu.sharedProject;

public enum Color {
    WHITE("Белый", 1d),
    BLUE("Синий", 1d),
    YELLOW("Жёлтый", 1.1d),
    RED("Красный", 1d),
    PEARL("Перламутровый", 1.2d),
    GREY_METALLIC("Серый металлик", 1.3d);

    private final String ruTerm;
    private final Double factor;

    Color(final String ruTerm, final Double factor) {
        this.ruTerm = ruTerm;
        this.factor = factor;
    }

    public String getRuTerm() { return this.ruTerm; }
    public Double getFactor() { return this.factor; }
}
