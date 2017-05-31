package ru.kpfu.entities;

/**
 * Created by Anatoly on 11.04.2017.
 */
public class Post {
    private String slug;
    private String name;
    private String text;

    public Post(String slug, String name, String text) {
        this.slug = slug;
        this.name = name;
        this.text = text;
    }

    public Post() {
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
