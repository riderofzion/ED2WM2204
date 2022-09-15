package com.quentinrouet.recyclerview;

/**
 * Created by quentin for HelloWorld on 15/09/2022.
 */
public class Article {
   String titre, description;
   float prix;

   public Article(String titre, String description, float prix) {
      this.titre = titre;
      this.description = description;
      this.prix = prix;
   }

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
