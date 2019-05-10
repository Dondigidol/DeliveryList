package dbServices.DAO;

import dbServices.dataSets.City;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CitiesDAO {
    private Session session;

    public CitiesDAO(Session session){
        this.session = session;
    }

    public void saveCity(City city) throws HibernateException{
        session.save(city);
    }

    public List<City> getCity(String cityName) throws HibernateException{
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<City> criteriaQuery = criteriaBuilder.createQuery(City.class);
        Root<City> root = criteriaQuery.from(City.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.like(root.<String>get("cityName"), "%" + cityName+"%"));
        List<City> cities = session.createQuery(criteriaQuery).getResultList();
        return cities;
    }

    public City getCityById(long cityId) throws HibernateException{
        return session.get(City.class, cityId);
    }

    public boolean deleteCity(long cityId) throws HibernateException{
        try{
            session.delete(session.get(City.class, cityId));
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
