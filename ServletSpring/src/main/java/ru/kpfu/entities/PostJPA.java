package ru.kpfu.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Anatoly on 24.04.2017.
 */
@Entity
@Table(name="posts")
public class PostJPA implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id", unique = true, nullable = false)
    private Integer id = -1;
    @Column(unique = true)
    private String slug;
    @Column
    @Size(min = 1, max = 255)
    private String name_ru;
    @Column
    private String text_ru;
    @Column
    private String name_eng;
    @Column
    private String text_eng;

    public PostJPA(String slug, String name_ru, String text_ru, String name_eng, String text_eng) {
        this.slug = slug;
        this.name_ru = name_ru;
        this.text_ru = text_ru;
        this.name_eng = name_eng;
        this.text_eng = text_eng;
    }
    public PostJPA(){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostJPA postJPA = (PostJPA) o;

        if (id != null ? !id.equals(postJPA.id) : postJPA.id != null) return false;
        if (slug != null ? !slug.equals(postJPA.slug) : postJPA.slug != null) return false;
        if (name_ru != null ? !name_ru.equals(postJPA.name_ru) : postJPA.name_ru != null) return false;
        if (text_ru != null ? !text_ru.equals(postJPA.text_ru) : postJPA.text_ru != null) return false;
        if (name_eng != null ? !name_eng.equals(postJPA.name_eng) : postJPA.name_eng != null) return false;
        return text_eng != null ? text_eng.equals(postJPA.text_eng) : postJPA.text_eng == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (slug != null ? slug.hashCode() : 0);
        result = 31 * result + (name_ru != null ? name_ru.hashCode() : 0);
        result = 31 * result + (text_ru != null ? text_ru.hashCode() : 0);
        result = 31 * result + (name_eng != null ? name_eng.hashCode() : 0);
        result = 31 * result + (text_eng != null ? text_eng.hashCode() : 0);
        return result;
    }
}
