package edu.esprit.entities;


import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {
    private int idCategory;
    private String description;
    private String libelle;

    public Category() {
    }

    public Category(Parcel in) {
        idCategory = in.readInt();
        description = in.readString();
        libelle = in.readString();
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idCategory);
        dest.writeString(description);
        dest.writeString(libelle);
    }

    public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel source) {
            return new Category(source);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return idCategory == category.idCategory;

    }


    @Override
    public int hashCode() {
        return idCategory;
    }
}
