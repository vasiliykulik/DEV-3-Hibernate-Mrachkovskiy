package ua.goit.java.jdbc.model.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.jdbc.model.Employee;
import ua.goit.java.jdbc.model.EmployeeDao;

import java.util.List;

/**
 * Created by Raketa on 24.12.2016.
 */
public class HEmployeeDao implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public Employee load(Long id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
