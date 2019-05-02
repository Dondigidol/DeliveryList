package dbServices.DAO;

import dbServices.dataSets.City;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CitiesDAO {
    private Session session;

    public CitiesDAO(Session session){
        this.session = session;
    }

    public void saveCity(City city) throws HibernateException{
        session.saveOrUpdate(city);
    }


}
