package ru.kpfu.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * Created by Anatoly on 01.05.2017.
 */
@Entity
@Table(name = "orders")

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "order_id", unique = true)
    private int id;
    @Column
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "login", nullable = false)
    private User user;
    @ManyToMany
    @JoinTable(name = "order_goods",
            joinColumns = @JoinColumn(name = "order_id1", referencedColumnName = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "good_id", referencedColumnName = "good_id"))
    private Set<Goods> goods;


    public Orders() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (id != orders.id) return false;
        return date != null ? date.equals(orders.date) : orders.date == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
