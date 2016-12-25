package ua.goit.java.hibernate.dao.hibernate;

import org.hibernate.SessionFactory;
import ua.goit.java.hibernate.dao.OrderDao;
import ua.goit.java.hibernate.model.Order;

/**
 * Created by Raketa on 25.12.2016.
 */
public class HOrderDao implements OrderDao {
    // 74. и в Order Dao тоже самое
    private SessionFactory sessionFactory;
    @Override
    public void sace(Order order) {
sessionFactory.getCurrentSession().save(order);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
