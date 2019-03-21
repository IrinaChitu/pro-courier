package com.procourier.app;

import com.procourier.model.*;
import com.procourier.repository.CollectionRepository;
import spark.Spark;

import java.util.Map;

public final class OrderServiceMain {
    public static void main(String[] args) {    // psvm -> genereaza main
        final var repository = new CollectionRepository();
        final var handler = new OrdersHandler(repository);

        final Address sellerAddress = new Address("DJ", "Craiova", "Nicolae Titulescu");
        final Seller seller = new Seller("Evomag", sellerAddress);

        final Address buyerAddress = new Address("DJ", "Craiova", "Ileana Cosanzeana");
        final Buyer buyer = new Buyer("Cosmin", buyerAddress);

        final Address courierAddress = new Address("OT", "Slatina", "Cantemir");
        final Courier courier = new Courier(1L, "ExpressFan", courierAddress, 5L, 7L);


        final var products = Map.of(new Product(20L, "Jeans", "Men Jeans", 22L), 4);

        final Order order = new Order(6L, seller, buyer, courier, products);

        repository.put(order);
        Spark.port(8082);
        Spark.threadPool(26, 10, 2000); // nr de fire de executie care pot raspunde la request-uri
        //Spark.get("/orders/hello", (request, response) -> "Hello World!"); // inainte de implementarea clasei OrdersHandler
        //Spark.get("/orders/hello", new OrdersHandler());  // inainte de a face constructorul privat
        //Spark.get("/orders/hello", OrdersHandler.INSTANCE);   // inainte de a face contructorul public si a rescrie metoda handler in OrdersHandler
        Spark.get("/orders/:ID", handler);
    }
}
