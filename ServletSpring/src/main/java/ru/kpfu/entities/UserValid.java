package ru.kpfu.entities;

import javax.validation.constraints.NotNull;

/**
 * Created by Anatoly on 04.04.2017.
 */
public class UserValid {
    private String email;
    private String surname;
    private String name;
    private String password;
    private String repassword;
    private String country;
    @NotNull
    private String gender;
    private boolean news;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserValid userValid = (UserValid) o;

        if (email != null ? !email.equals(userValid.email) : userValid.email != null) return false;
        if (surname != null ? !surname.equals(userValid.surname) : userValid.surname != null) return false;
        if (name != null ? !name.equals(userValid.name) : userValid.name != null) return false;
        if (password != null ? !password.equals(userValid.password) : userValid.password != null) return false;
        return gender != null ? gender.equals(userValid.gender) : userValid.gender == null;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

}
