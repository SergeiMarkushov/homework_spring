package ru.gb.homework_spring;


import org.hibernate.Session;
import ru.gb.homework_spring.DAO.ProductsDAO;
import ru.gb.homework_spring.DAO.ProductsDAOImpl;
import ru.gb.homework_spring.DAO.UsersDAO;
import ru.gb.homework_spring.DAO.UsersDAOImpl;
import ru.gb.homework_spring.entities.ProductsEntity;
import ru.gb.homework_spring.entities.UsersEntity;
import ru.gb.homework_spring.utills.SessionFactoryUtils;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            Session session = sessionFactoryUtils.getSession();
            session.getTransaction().begin();
            UsersEntity user = session.get(UsersEntity.class,1L);
            List<ProductsEntity> products = user.getProducts();
            System.out.println("================================================");
            System.out.println("User with id: " + user.getId() + " name: " + user.getName());
            for (ProductsEntity product : products) {
                product.print();
            }
            System.out.println("================================================");


            session.getTransaction().commit();



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
