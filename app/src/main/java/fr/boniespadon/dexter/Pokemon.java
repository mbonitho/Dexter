package fr.boniespadon.dexter;

/**
 * Created by Mathieu on 03/08/2015.
 */
public class Pokemon {

    private int id;
    private String name;
    private String description;
    private String imageName;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getImageName() { return imageName; }
    public void setImageName(String imageName) { this.imageName = imageName; }

    public Pokemon(int id, String name, String description, String imageName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return Integer.toString(id) + " - " + getName() + " : " + getDescription() + " | " + getImageName();
    }
}
