package hibernate.test.school;

public class Pet {
    private int id;
    private String description;
    private int weight;

    public Pet() {
    }

    public Pet(String description, int weight) {
        this.description = description;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", weight=" + weight + '\'' +
                '}';
    }
}
