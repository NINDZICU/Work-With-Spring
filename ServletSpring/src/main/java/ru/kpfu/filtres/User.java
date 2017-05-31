package ru.kpfu.filtres;

import javax.validation.constraints.*;

/**
 * Created by Anatoly on 04.04.2017.
 */
public class User {
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,8}$", message = " Login must contain valid characters and have a length from 11 to 30")
    private String email;
    @NotNull
    @Max(128)
    private String surname;
    @NotNull
    @Max(128)
    private String name;
    @Size(min = 6, max = 128)
    @NotNull
    private String password;
    @Max(128)
    private String country;
    @NotNull
    private String gender;
    private boolean news;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isNews() {
        return news;
    }

    public void setNews(boolean news) {
        this.news = news;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        return gender != null ? gender.equals(user.gender) : user.gender == null;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }
}
