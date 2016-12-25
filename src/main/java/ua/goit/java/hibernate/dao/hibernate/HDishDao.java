package ua.goit.java.hibernate.dao.hibernate;

import org.hibernate.SessionFactory;
import ua.goit.java.hibernate.dao.DishDao;
import ua.goit.java.hibernate.model.Dish;

import java.util.List;

/**
 * Created by Raketa on 25.12.2016.
 */
public class HDishDao implements DishDao {
    // 72. Здесь нам понадобится Session Factory

    private SessionFactory sessionFactory;
    @Override
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    // 77.
    @Override
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    // 73. setter понадобиться

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
