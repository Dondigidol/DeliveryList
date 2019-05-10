package dbServices.DAO;

import dbServices.dataSets.Position;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PositionsDAO {
    private Session session;

    public PositionsDAO(Session session){
        this.session = session;
    }

    public void savePosition(Position position) throws HibernateException {
        session.save(position);
    }

    public List<Position> getPosition(String positonName) throws HibernateException{
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Position> criteriaQuery = criteriaBuilder.createQuery(Position.class);
        Root<Position> root = criteriaQuery.from(Position.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.like(root.<String>get("positionName"), "%" + positonName + "%"));
        List<Position> result = session.createQuery(criteriaQuery).getResultList();
        return result;
    }



}
