package com.quentinrouet.amazeni;


/**
 * Created by quentin for HelloWorld on 21/09/2022.
 */
public class Article {
    private int id;
    private String title,description,category,image;
    private float price;
    private Rating rating;

    public Article(int id, String title, String description, String category, String image, float price, Rating rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.image = image;
        this.price = price;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }



    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
