package dbServices.DAO;

import dbServices.dataSets.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;

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

    public User getUserbyId(long id) throws HibernateException{
        return session.get(User.class, id);
    }

    public List<User> getUserByName(String name, String surname) throws HibernateException{
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        return (List<User>)query.select(root).where(builder.equal(root.get("name"), name));

    }

    public void deleteUser(long id) throws HibernateException{

    }

}
