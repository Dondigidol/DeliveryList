package interfaces;


import dataSets.City;
import dataSets.Delivery;
import dataSets.Position;
import dataSets.User;

import java.sql.SQLException;
import java.util.List;

public interface DBService {

    void printConnectionInfo() throws SQLException;

    void saveUser(User user);

    void saveDelivery(Delivery delivery);

    void savePosition(Position position);

    void saveCity(City city);

    List<Delivery> getDeliveries();



}
