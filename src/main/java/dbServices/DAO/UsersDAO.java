package dbServices.DAO;

import dbServices.dataSets.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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

    public void getUserByName(String name, String surname) throws HibernateException{
        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        List<User> users = em.createQuery(cq).getResultList();
        for (User user: users){
            System.out.println(user.getUserId());
        }


    }

    public void deleteUser(long id) throws HibernateException{

    }

}
