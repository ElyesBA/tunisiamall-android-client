package edu.esprit.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Subcategory implements Parcelable {
    private int idSubCategory;
    private String description;
    private String libelle;
    private Category category;

    public Subcategory() {
    }

    public Subcategory(Parcel in) {
        idSubCategory = in.readInt();
        description = in.readString();
        libelle = in.readString();
        category = in.readParcelable(Category.class.getClassLoader());
    }

    public int getIdSubCategory() {
        return idSubCategory;
    }

    public void setIdSubCategory(int idSubCategory) {
        this.idSubCategory = idSubCategory;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idSubCategory);
        dest.writeString(description);
        dest.writeString(libelle);
        dest.writeParcelable(category, flags);
    }

    public static final Parcelable.Creator<Subcategory> CREATOR = new Parcelable.Creator<Subcategory>() {
        @Override
        public Subcategory createFromParcel(Parcel source) {
            return new Subcategory(source);
        }

        @Override
        public Subcategory[] newArray(int size) {
            return new Subcategory[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subcategory that = (Subcategory) o;

        return idSubCategory == that.idSubCategory;

    }

    @Override
    public int hashCode() {
        return idSubCategory;
    }

}
