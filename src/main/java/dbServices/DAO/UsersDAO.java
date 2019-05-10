package dbServices.DAO;

import dbServices.dataSets.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class UsersDAO {
    private Session session;

    public UsersDAO(Session session){
        this.session = session;
    }

    public void saveUser(User user) throws HibernateException {
        session.saveOrUpdate(user);
    }

    public User getUserById(long id) throws HibernateException{
        return session.get(User.class, id);
    }

    public List<User> getUserByName(String name, String surname) throws HibernateException{
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        cq.where(cb.and(cb.like(root.<String>get("userName"), "%" + name +"%"), cb.like(root.<String>get("userSurname"), "%" + surname + "%")));
        List<User> users = session.createQuery(cq).getResultList();
        return users;
    }

    public List<User> getUserByPosition(String positionName) throws HibernateException{
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.like(root.<String>get("userPosition"), "%" + positionName + "%"));
        List<User> users = session.createQuery(criteriaQuery).getResultList();
        return users;
    }

    public boolean deleteUser(long id) throws HibernateException{
        try {
            session.delete(session.get(User.class, id));
            return true;
        } catch (Exception e){
            return false;
        }
    }



}
