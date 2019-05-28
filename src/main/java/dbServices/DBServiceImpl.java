package dbServices;

import dbServices.DAO.CitiesDAO;
import dbServices.DAO.DeliveriesDAO;
import dbServices.DAO.PositionsDAO;
import dbServices.DAO.UsersDAO;
import dataSets.City;
import dataSets.Delivery;
import dataSets.Position;
import dataSets.User;
import interfaces.DBService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class DBServiceImpl implements DBService {
    private static final String hibernate_show_sql = "true";
    private static final String hibernate_hbm2ddl_auto = "create";

    private final SessionFactory sessionFactory;

    public DBServiceImpl(){
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

    public void printConnectionInfo() throws SQLException {
        SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) sessionFactory;
        Connection connection = sessionFactoryImpl.getJdbcServices().getBootstrapJdbcConnectionAccess().obtainConnection();
        System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
        System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
        System.out.println("Driver: " + connection.getMetaData().getDriverVersion());
        System.out.println("Autocommit: " + connection.getAutoCommit());
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

    public User getUserById(long id) throws NullPointerException {
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();
        UsersDAO dao = new UsersDAO(session);
        User user = dao.getUserById(id);
        ts.commit();
        session.close();
        return user;
    }

    public List<User> getUserByName(String name, String surname) throws NullPointerException {
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();
        UsersDAO dao = new UsersDAO(session);
        List<User> users = dao.getUserByName(name, surname);
        ts.commit();
        session.close();
        return users;
    }

    public void deleteUserById(long userId) {
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();
        UsersDAO dao = new UsersDAO(session);
        dao.deleteUser(userId);
        ts.commit();
        session.close();
    }

    public List<Delivery> getDelivery(Delivery delivery) throws NullPointerException {
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();
        DeliveriesDAO dao = new DeliveriesDAO(session);
        System.out.println(delivery);
        delivery.prepareSearch();
        System.out.println(delivery);
        List<Delivery> deliveries = dao.getDelivery(delivery);
        ts.commit();
        session.close();
        return deliveries;
    }

    public List<Position> getPosition(String positionName) throws NullPointerException {
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();
        PositionsDAO dao = new PositionsDAO(session);
        List<Position> result= dao.getPosition(positionName);
        ts.commit();
        session.close();
        return result;
    }

    public List<Position> getPosition(){
        return getPosition("");
    }

    public List<City> getCity(String cityName){
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();
        CitiesDAO dao = new CitiesDAO(session);
        List<City> result = dao.getCity(cityName);
        ts.commit();
        session.close();
        return result;
    }

    public List<City> getCity(){
        return getCity("");
    }

    public List<User> getUserByPosition(String positionName) throws NullPointerException {
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();
        UsersDAO dao = new UsersDAO(session);
        List<User> users = dao.getUserByPosition(positionName);
        ts.commit();
        session.close();
        return users;
    }









}
