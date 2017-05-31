package ru.kpfu.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Anatoly on 01.05.2017.
 */
@Entity
@Table(name = "Goods")
public class Goods implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "good_id", unique = true)
    private Integer id = -1;
    @Column
    private String name;
    @Column
    private double price;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "goods")
    private Set<Orders> orders;

    public Goods() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (Double.compare(goods.price, price) != 0) return false;
        if (id != null ? !id.equals(goods.id) : goods.id != null) return false;
        return name != null ? name.equals(goods.name) : goods.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
