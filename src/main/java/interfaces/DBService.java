package interfaces;

import dbServices.dataSets.City;
import dbServices.dataSets.Delivery;
import dbServices.dataSets.Position;
import dbServices.dataSets.User;

public interface DBService {

    void printConnectionInfo();

    void saveUser(User user);

    void saveDelivery(Delivery delivery);

    void savePosition(Position position);

    void saveCity(City city);



}
