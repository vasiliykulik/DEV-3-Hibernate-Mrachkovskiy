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
    // 30. И здесь тоже зделаем метод @Transactional - что бы были уверены - что ничего не поламается
    // 30. что ничего не поламается если мы вызовен не их тразакционного контекста,
    // зависит от архитектурного - решения - можно ли дергать метод из нетранзакционного контекста
    @Transactional
    public void save(Employee employee) {
        // 23. напишем первый метод - понадобится SessionFactory
        // 25. Процесс сохранения - вот и в принципе и все
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
// 36. Создадим setter
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
