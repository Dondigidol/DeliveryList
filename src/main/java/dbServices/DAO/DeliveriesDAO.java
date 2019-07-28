package dbServices.DAO;


import dataSets.Delivery;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

public class DeliveriesDAO {

    private Session session;

    public DeliveriesDAO(Session session){
        this.session = session;
    }

    public void saveDelivery(Delivery delivery) throws HibernateException {
        session.saveOrUpdate(delivery);
    }

    public Delivery getDelivery(Delivery delivery) throws HibernateException, NullPointerException {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Delivery> criteriaQuery = criteriaBuilder.createQuery(Delivery.class);
        Root<Delivery> root = criteriaQuery.from(Delivery.class);
        criteriaQuery.select(root);

        criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.ge(root.<Long>get("deliveryId"), delivery.getDeliveryId()),
                criteriaBuilder.like(root.<String>get("deliveryDate"), delivery.getDeliveryDate()),
                criteriaBuilder.like(root.<String>get("deliveryOrderId"), delivery.getDeliveryOrderId()),
                criteriaBuilder.like(root.<String>get("deliveryClient"), delivery.getDeliveryClient()),
                criteriaBuilder.greaterThanOrEqualTo(root.<Double>get("deliveryClientPrice"), delivery.getDeliveryClientPrice()),
                criteriaBuilder.greaterThanOrEqualTo(root.<Double>get("deliveryPrice"), delivery.getDeliveryPrice()),
                criteriaBuilder.like(root.<String>get("deliveryCity"), delivery.getDeliveryCity()),
                criteriaBuilder.like(root.<String>get("deliveryComment"), delivery.getDeliveryComment()),
                criteriaBuilder.like(root.<String>get("deliveryAuthor"), delivery.getDeliveryAuthor())));
        Delivery result = session.createQuery(criteriaQuery).getSingleResult();

        return result;
    }

    public List<Delivery> getDeliveries() throws HibernateException, NullPointerException {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Delivery> criteriaQuery = criteriaBuilder.createQuery(Delivery.class);
        Root<Delivery> root = criteriaQuery.from(Delivery.class);
        criteriaQuery.select(root);
        criteriaQuery.where();
        List<Delivery> result = session.createQuery(criteriaQuery).getResultList();
        return result;
    }

}
