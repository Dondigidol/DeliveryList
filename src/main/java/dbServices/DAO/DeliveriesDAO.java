package dbServices.DAO;


import dbServices.dataSets.Delivery;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DeliveriesDAO {

    private Session session;

    public DeliveriesDAO(Session session){
        this.session = session;
    }

    public void saveDelivery(Delivery delivery) throws HibernateException {
        session.saveOrUpdate(delivery);
    }

    public void getDelivery(Delivery delivery) throws HibernateException{
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Delivery> criteriaQuery = criteriaBuilder.createQuery(Delivery.class);
        Root<Delivery> root = criteriaQuery.from(Delivery.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.like(root.<String>get("deliveryId"), "%" + delivery.getDeliveryId().toString() + "%"),
                                                criteriaBuilder.like(root.<String>get("deliveryDate"), "%" + delivery.getDeliveryDate() + "%"),
                                                criteriaBuilder.like(root.<String>get("deliveryOrderId"), "%"+delivery.getDeliveryOrderId()+ "%"),
                                                criteriaBuilder.like(root.<String>get("deliveryClient"), "%"+delivery.getDeliveryClient()+"%"),
                                                criteriaBuilder.like(root.<String>get("deliveryClientPrice"), "%" + delivery.getDeliveryClientPrice().toString() + "%"),
                                                criteriaBuilder.like(root.<String>get("deliveryPrice"), "%"+delivery.getDeliveryPrice().toString()+"%"),
                                                criteriaBuilder.like(root.<String>get("deliveryCity"), "%"+delivery.getDeliveryCity()+"%"),
                                                criteriaBuilder.like(root.<String>get("deliveryComment"), "%" + delivery.getDeliveryComment()+"%"),
                                                criteriaBuilder.like(root.<String>get("deliveryAuthor"), "%" + delivery.getDeliveryAuthor() + "%")));
        List<Delivery> result = session.createQuery(criteriaQuery).getResultList();
        for(Delivery del: result){
            System.out.print(del.getDeliveryId() + " | ");
            System.out.print(del.getDeliveryDate() + " | ");
            System.out.print(del.getDeliveryOrderId()+ " | ");
            System.out.print(del.getDeliveryClient() + " | ");
            System.out.print(del.getDeliveryClientPrice() + " | ");
            System.out.print(del.getDeliveryPrice() + " | ");
            System.out.print(del.getDeliveryCity() + " | ");
            System.out.print(del.getDeliveryComment() + " | ");
            System.out.println(del.getDeliveryAuthor());
        }


    }

}
