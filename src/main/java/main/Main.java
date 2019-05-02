package main;

import dbServices.DBService;
import dbServices.dataSets.City;
import dbServices.dataSets.Delivery;
import dbServices.dataSets.Position;
import dbServices.dataSets.User;

public class Main {

    public static void main(String[] args){
        DBService dbService = new DBService();
        dbService.printConnectionInfo();

        User user = new User(6031809, "Emil", "Tulbaev", "IT");
        dbService.saveUser(user);

        User user2 =  new User(60031809, "Emil", "Tulbaev", "специалист по информационным технологиям");
        dbService.saveUser(user2);

        Delivery delivery = new Delivery();
        delivery.setDeliveryDate("28042019");
        delivery.setDeliveryOrderId("1234321");
        delivery.setDeliveryClient("Василий Пупкин Иванович");
        delivery.setDeliveryPrice(500.00);
        delivery.setDeliveryClientPrice(400.00);
        delivery.setDeliveryAuthor("Эмиль Тулбаев");
        delivery.setDeliveryCity("Челны");
        dbService.saveDelivery(delivery);

        Position position = new Position("Специалист доставки");
        dbService.savePosition(position);

        City city = new City("Набережные Челны");
        dbService.saveCity(city);

        City city2 = new City("Елабуга");
        dbService.saveCity(city2);

        User user3 = dbService.getUserById(60031809);
        System.out.println(user3.getUserName());

        dbService.getUserByName("Emil", "Tulbaev");



    }



}
