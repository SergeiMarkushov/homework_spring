package ru.gb.homework_spring.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;

    @OneToMany(mappedBy = "users")
    private List<ProductsEntity> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UsersEntity() {
    }

    public String toString() {
        return String.format("User id %d, name is %s, product count = %d", id, name, products.size());
    }

    public List<ProductsEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsEntity> products) {
        this.products = products;
    }
}