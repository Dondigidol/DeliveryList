package dbServices;

import dbServices.DAO.CitiesDAO;
import dbServices.DAO.DeliveriesDAO;
import dbServices.DAO.PositionsDAO;
import dbServices.DAO.UsersDAO;
import dbServices.dataSets.City;
import dbServices.dataSets.Delivery;
import dbServices.dataSets.Position;
import dbServices.dataSets.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.util.List;


public class DBService {
    private static final String hibernate_show_sql = "true";
    private static final String hibernate_hbm2ddl_auto = "create";

    private final SessionFactory sessionFactory;

    public DBService(){
        Configuration configuration = getMySqlConfiguration();
        sessionFactory = createSessionFactory(configuration);
//        Session session = sessionFactory.openSession();
//        UsersDAO usersDAO = new UsersDAO(session);
//        PositionsDAO positionsDAO = new PositionsDAO(session);
//        DeliveriesDAO deliveriesDAO = new DeliveriesDAO(session);
    }

    private Configuration getMySqlConfiguration(){
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Position.class);
        configuration.addAnnotatedClass(Delivery.class);
        configuration.addAnnotatedClass(City.class);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/delivery?useTimezone=true&serverTimezone=UTC");
        configuration.setProperty("hibernate.connection.username","delivery");
        configuration.setProperty("hibernate.connection.password","Passwd039");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        return configuration;
    }

    private SessionFactory createSessionFactory(Configuration configuration){
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public void printConnectionInfo(){
        try{
            SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) sessionFactory;
            Connection connection = sessionFactoryImpl.getJdbcServices().getBootstrapJdbcConnectionAccess().obtainConnection();
            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver: " + connection.getMetaData().getDriverVersion());
            System.out.print("Autocommit: " + connection.getAutoCommit());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveUser(User user){
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();
        UsersDAO usersDAO = new UsersDAO(session);
        usersDAO.saveUser(user);
        ts.commit();
        session.close();
    }

    public void saveDelivery(Delivery delivery){
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();
        DeliveriesDAO dao = new DeliveriesDAO(session);
        dao.saveDelivery(delivery);
        ts.commit();
        session.close();
    }

    public void savePosition(Position position){
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();
        PositionsDAO dao = new PositionsDAO(session);
        dao.savePosition(position);
        ts.commit();
        session.close();
    }

    public void saveCity(City city){
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();
        CitiesDAO dao = new CitiesDAO(session);
        dao.saveCity(city);
        ts.commit();
        session.close();
    }

    public User getUserById(long id){
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();
        UsersDAO dao = new UsersDAO(session);
        User user = dao.getUserById(id);
        ts.commit();
        session.close();
        return user;
    }

    public void getUserByName(String name, String surname){
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();
        UsersDAO dao = new UsersDAO(session);
        dao.getUserByName(name, surname);
        ts.commit();
        session.close();
        //return users;
    }







}
