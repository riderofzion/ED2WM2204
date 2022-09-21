package com.quentinrouet.okhttp;

/**
 * Created by quentin for HelloWorld on 20/09/2022.
 */
public class People {
   private String name,height,mass,hair_color;

   public People(String name, String height, String mass, String hair_color) {
      this.name = name;
      this.height = height;
      this.mass = mass;
      this.hair_color = hair_color;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getHeight() {
      return height;
   }

   public void setHeight(String height) {
      this.height = height;
   }

   public String getMass() {
      return mass;
   }

   public void setMass(String mass) {
      this.mass = mass;
   }

   public String getHair_color() {
      return hair_color;
   }

   public void setHair_color(String hair_color) {
      this.hair_color = hair_color;
   }
}
