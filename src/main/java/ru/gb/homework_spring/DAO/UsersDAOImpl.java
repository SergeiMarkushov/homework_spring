package ru.gb.homework_spring.DAO;

import org.hibernate.Session;
import ru.gb.homework_spring.entities.UsersEntity;
import ru.gb.homework_spring.utills.SessionFactoryUtils;

import java.util.List;

public class UsersDAOImpl implements UsersDAO {
    private SessionFactoryUtils sessionFactoryUtils;

    public UsersDAOImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public UsersEntity findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.getTransaction().begin();
            UsersEntity user = session.get(UsersEntity.class, id);
            session.getTransaction().commit();
            return user;
        }
    }

    @Override
    public List<UsersEntity> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.getTransaction().begin();
            List<UsersEntity> userList = session.createQuery("select u from UsersEntity u").getResultList();
            session.getTransaction().commit();
            return userList;
        }
    }

    @Override
    public UsersEntity findByTitle(String name) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.getTransaction().begin();
            UsersEntity user = session.createQuery("select user from UsersEntity user where user.name = :name", UsersEntity.class)
                    .setParameter("name", name).getSingleResult();
            session.getTransaction().commit();
            return user;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.getTransaction().begin();
            UsersEntity user = session.get(UsersEntity.class, id);
            session.delete(user);
            session.getTransaction().commit();
        }
    }


    @Override
    public UsersEntity saveOrUpdate(UsersEntity user) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.getTransaction().begin();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        }
        return user;
    }
}
