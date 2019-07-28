import dbServices.DBServiceImpl;
import dataSets.City;
import dataSets.Delivery;
import dataSets.Position;
import dataSets.User;
import interfaces.DBService;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.ResourceCollection;
import org.eclipse.jetty.webapp.WebAppContext;


public class Main {

    public static void main(String[] args) throws Exception{
        DBService dbService = new DBServiceImpl();
        dbService.printConnectionInfo();

        for (int i=1; i<10; i++){
            User user = new User();
            user.setUserId(i);
            user.setLogin("Login" + i);
            user.setUserName("Имя 1");
            user.setUserSurname("Фамилия 1");
            user.setUserPosition("Должность 1");
            dbService.saveUser(user);

            Delivery delivery = new Delivery();
            delivery.setDeliveryDate("010" + i + "2019");
            delivery.setDeliveryOrderId("Order" + i);
            delivery.setDeliveryClient("Client"+ i);
            delivery.setDeliveryClientPrice(i * 50);
            delivery.setDeliveryPrice(i*70);
            delivery.setDeliveryCity("City " + i);
            delivery.setDeliveryAuthor("Author " + i);
            delivery.setDeliveryComment("Comment " + i);
            dbService.saveDelivery(delivery);

            Position position = new Position();
            position.setPositionName("Position " + i);
            dbService.savePosition(position);

            City city = new City();
            city.setCityName("City " + i);
            dbService.saveCity(city);
        }
    }
}
