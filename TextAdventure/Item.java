public abstract class Item {
    protected String name;
    protected String description;
    protected double weight;
    protected double value;

    public Item(String name, String description, double weight, double value) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public double getValue() {
        return value;
    }
}
