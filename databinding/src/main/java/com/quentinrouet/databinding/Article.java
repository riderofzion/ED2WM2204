package com.quentinrouet.databinding;

import android.os.Parcel;
import android.os.Parcelable;

public class Article implements Parcelable {
    String titre, description;
    float prix;

    public Article(String titre, String description, float prix) {
        this.titre = titre;
        this.description = description;
        this.prix = prix;
    }

    protected Article(Parcel in) {
        titre = in.readString();
        description = in.readString();
        prix = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titre);
        dest.writeString(description);
        dest.writeFloat(prix);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
