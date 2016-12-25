package ua.goit.java.hibernate.dao.hibernate;

import org.hibernate.SessionFactory;
import ua.goit.java.hibernate.dao.OrderDao;
import ua.goit.java.hibernate.model.Orders;

import java.util.List;

/**
 * Created by Raketa on 25.12.2016.
 */
public class HOrderDao implements OrderDao {
    // 74. и в Orders Dao тоже самое
    private SessionFactory sessionFactory;

    @Override
    public void save(Orders orders) {
        sessionFactory.getCurrentSession().save(orders);
    }

    // 117. Таким же образом


    @Override
    public List<Orders> findAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
