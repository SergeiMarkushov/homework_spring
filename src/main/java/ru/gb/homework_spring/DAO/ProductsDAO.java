package ru.gb.homework_spring.DAO;

import ru.gb.homework_spring.entities.ProductsEntity;

import java.util.List;

public interface ProductsDAO {

    ProductsEntity findById(Long id);

    List<ProductsEntity> findAll();

    ProductsEntity findByTitle(String title);

    void deleteById(Long id);

    ProductsEntity saveOrUpdate(ProductsEntity product);

}
