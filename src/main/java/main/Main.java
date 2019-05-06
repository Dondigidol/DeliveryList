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

        User user = new User(6031809, "Олеся", "Фатихова", "логист");
        dbService.saveUser(user);

        User user2 =  new User(60031809, "Эмиль", "Тулбаев", "специалист по информационным технологиям");
        dbService.saveUser(user2);

        User user3 = new User(12324, "Вася", "Петров", "логист");
        dbService.saveUser(user3);

        Delivery delivery = new Delivery();
        delivery.setDeliveryDate("28042019");
        delivery.setDeliveryOrderId("1234321");
        delivery.setDeliveryClient("Василий Пупкин Иванович");
        delivery.setDeliveryPrice(500.00);
        delivery.setDeliveryClientPrice(400.00);
        delivery.setDeliveryAuthor("Эмиль Тулбаев");
        delivery.setDeliveryCity("Челны");
        dbService.saveDelivery(delivery);

        Delivery delivery2 = new Delivery();
        delivery2.setDeliveryDate("06052019");
        delivery2.setDeliveryOrderId("8765432");
        delivery2.setDeliveryClient("Дунькин Иван Федорович");
        delivery2.setDeliveryClientPrice(700.00);
        delivery2.setDeliveryPrice(1000.00);
        delivery2.setDeliveryCity("Елабуга");
        delivery2.setDeliveryComment("не поднимать на этаж");
        delivery2.setDeliveryAuthor("Горбунькова Светлана Игнатевна");

        Delivery delivery3 = new Delivery();
        delivery3.setDeliveryAuthor("улбаев");

        Position position = new Position("Специалист доставки");
        dbService.savePosition(position);

        City city = new City("Набережные Челны");
        dbService.saveCity(city);

        City city2 = new City("Елабуга");
        dbService.saveCity(city2);

        //User user4 = dbService.getUserById(60031809);
        //System.out.println(user4.getUserName() +" "+ user4.getUserSurname());

        //dbService.getUserByName("Эмиль", "Тулбаев");
        dbService.getDelivery(delivery3);
    }



}
