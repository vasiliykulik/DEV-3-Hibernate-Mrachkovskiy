package ua.goit.java.jdbc.model.hibernate;

import org.hibernate.Session;
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
    // 55. имплементируем findAll vtjnlz для этого воспользуемся другой возможностью Hibernate
    // а именно выполнение запросов
    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("select e from Employee e").list(); // 56. select * from Employee, будет raw casting
        return null;
    }


    // 51. Делается это точно так же через sessionFactory
    // 52. так как мы при каждом запуске будем создавать employee, можно написать маленький код - или удалять - или проверку существования

    @Override
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
