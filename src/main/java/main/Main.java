package main;

import dbServices.DBService;
import dbServices.dataSets.City;
import dbServices.dataSets.Delivery;
import dbServices.dataSets.Position;
import dbServices.dataSets.User;
import services.ADService;

import java.util.List;

public class Main {

    public static void main(String[] args){
        DBService dbService = new DBService();
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

       /* Delivery delivery3 = new Delivery();
        List<Delivery> deliveries = dbService.getDelivery(delivery3);
        for (Delivery delivery: deliveries){
            System.out.println(delivery.toString());
        }

        List<Position> positions = dbService.getPosition();
        for (Position position: positions){
            System.out.println(position.toString());
        }

        List<City> cities = dbService.getCity();
        for(City city: cities){
            System.out.println(city.toString());
        }*/

        //ADService adService = new ADService("60031809", "Passwd186");
        //System.out.println(adService.getUserInfo().toString());




    }



}
