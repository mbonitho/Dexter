package fr.boniespadon.dexter;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mathieu on 03/08/2015.
 *
 * Classe représentant l'objet métier Pokémon
 */
public class Pokemon {

    //MB : Attributs privés
    private int id;
    private String name;
    private String description;
    private String imageName;
    private boolean isFavourite;

    //MB : Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getImageName() { return imageName; }
    public boolean isFavourite() { return isFavourite; }
    public void setIsFavourite(boolean isFavourite) { this.isFavourite = isFavourite; }

    //MB : Constructeur par défaut de l'objet Pokémon
    public Pokemon() {
        this(0, "MissingNo", "Le Pokémon bug", "", false);
    }

    //MB : Constructeur complet de l'objet Pokémon
    public Pokemon(int id, String name, String description, String imageName, boolean isFavourite) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageName = imageName;
        this.isFavourite = isFavourite;
    }

    @Override
    public String toString() {
        return Integer.toString(id) + " - " + getName() + " : " + getDescription() + " | " + getImageName();
    }
}
