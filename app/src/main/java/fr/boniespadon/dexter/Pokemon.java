package fr.boniespadon.dexter;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * Created by Mathieu on 03/08/2015.
 */
public class Pokemon implements Parcelable{

    private int id;
    private String name;
    private String description;
    private String imageName;
    private boolean isFavourite;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getImageName() { return imageName; }
    public void setImageName(String imageName) { this.imageName = imageName; }
    public boolean isFavourite() { return isFavourite; }
    public void setIsFavourite(boolean isFavourite) { this.isFavourite = isFavourite; }

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

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Pokemon> CREATOR = new
            Parcelable.Creator<Pokemon>() {
                public Pokemon createFromParcel(Parcel in) {
                    return new Pokemon(in);
                }

                public Pokemon[] newArray(int size) {
                    return new Pokemon[size];
                }
            };

    public Pokemon() {
    }

    private Pokemon(Parcel in) {
        readFromParcel(in);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(imageName);
    }

    public void readFromParcel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        imageName = in.readString();
    }
}
