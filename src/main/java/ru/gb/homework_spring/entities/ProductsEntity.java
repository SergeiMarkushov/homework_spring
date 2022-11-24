package ru.gb.homework_spring.entities;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class ProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "title", nullable = false, length = -1)
    private String title;

    @Basic
    @Column(name = "cost", nullable = false)
    private Integer cost;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public ProductsEntity() {
    }

    public void print() {
        System.out.println("Product id: " + getId() + " ProductTitle = " + getTitle());
    }
}