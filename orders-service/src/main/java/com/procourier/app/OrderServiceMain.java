package com.procourier.app;

import spark.Spark;

public final class OrderServiceMain {
    public static void main(String[] args) {    // psvm -> genereaza main
        Spark.port(8082);
        //Spark.get("/orders/hello", (request, response) -> "Hello World!"); // inainte de implementarea clasei OrdersHandler
        //Spark.get("/orders/hello", new OrdersHandler());  // inainte de a face constructorul privat
        Spark.get("/orders/hello", OrdersHandler.INSTANCE);
    }
}
