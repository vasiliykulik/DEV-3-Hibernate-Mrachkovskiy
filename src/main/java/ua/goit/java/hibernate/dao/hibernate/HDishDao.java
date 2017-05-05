package ua.goit.java.hibernate.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibernate.dao.DishDao;
import ua.goit.java.hibernate.model.Dish;

import java.util.List;

/**
 * Created by Raketa on 25.12.2016.
 */
public class HDishDao implements DishDao {

  private SessionFactory sessionFactory;

  @Transactional
  @Override
  public void save(Dish dish) {
    sessionFactory.getCurrentSession().save(dish);
  }

  @Transactional
  @Override
  public List<Dish> findAll() {
    return sessionFactory.getCurrentSession().
            createQuery("select d from Dish d").list();
  }


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
}
