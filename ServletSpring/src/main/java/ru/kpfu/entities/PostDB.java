package ru.kpfu.entities;

/**
 * Created by Anatoly on 11.04.2017.
 */
public class PostDB {

    private String slug;
    private String name_ru;
    private String text_ru;
    private String name_eng;
    private String text_eng;

    public PostDB(String slug, String name_ru, String text_ru, String name_eng, String text_eng) {
        this.slug = slug;
        this.name_ru = name_ru;
        this.text_ru = text_ru;
        this.name_eng = name_eng;
        this.text_eng = text_eng;
    }
    public PostDB(){
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName_ru() {
        return name_ru;
    }

    public void setName_ru(String name_ru) {
        this.name_ru = name_ru;
    }

    public String getText_ru() {
        return text_ru;
    }

    public void setText_ru(String text_ru) {
        this.text_ru = text_ru;
    }

    public String getName_eng() {
        return name_eng;
    }

    public void setName_eng(String name_eng) {
        this.name_eng = name_eng;
    }

    public String getText_eng() {
        return text_eng;
    }

    public void setText_eng(String text_eng) {
        this.text_eng = text_eng;
    }
}
