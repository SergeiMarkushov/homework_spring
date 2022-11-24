package ru.gb.homework_spring.DAO;

import ru.gb.homework_spring.entities.ProductsEntity;
import ru.gb.homework_spring.entities.UsersEntity;

import java.util.List;

public interface UsersDAO {
    UsersEntity findById(Long id);

    List<UsersEntity> findAll();

    UsersEntity findByTitle(String name);

    void deleteById(Long id);

    UsersEntity saveOrUpdate(UsersEntity user);

}
