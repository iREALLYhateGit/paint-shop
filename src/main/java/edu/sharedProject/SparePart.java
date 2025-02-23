package edu.sharedProject;

public enum SparePart
{
    HOOD("Капот", 1d),
    FRONT_DOOR("Передняя дверь", 1.2d),
    BACK_DOOR("Задняя дверь", 1.1d),
    FRONT_BUMPER("Передний бампер", 1d),
    BACK_BUMPER("Задний бампер", 1d),
    ROOF("Крыша", 1.1d);

    private final String ruTerm;
    private final Double factor;

    SparePart(String ruTerm, Double factor)
    {
        this.ruTerm = ruTerm;
        this.factor = factor;
    }

    public String getRuTerm() { return ruTerm; }

    public Double getFactor() { return factor; }
}
