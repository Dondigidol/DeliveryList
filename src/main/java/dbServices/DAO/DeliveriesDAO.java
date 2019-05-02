package dbServices.DAO;


import dbServices.dataSets.Delivery;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class DeliveriesDAO {

    private Session session;

    public DeliveriesDAO(Session session){
        this.session = session;
    }

    public void saveDelivery(Delivery delivery) throws HibernateException {
        session.saveOrUpdate(delivery);
    }
}
