package com.birhman.grocery.model;

public class StoreModel {
    String id;
    String title;
    String distance;
    String times;
    String image;
    String rating;

    public StoreModel(String id, String title, String image, String distance, String times, String rating) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.distance = distance;
        this.times = times;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
