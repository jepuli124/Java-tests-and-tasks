package com.example.week11;

public class Product {
    String text;
    int id;
    boolean star;
    public Product(String text, int id, boolean star) {
        this.text = text;
        this.id = id;
        this.star = star;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public boolean isStar() {
        return star;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }
}
