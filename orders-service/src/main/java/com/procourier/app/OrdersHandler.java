package com.procourier.app;

import com.procourier.model.Order;
import com.procourier.model.repository.OrderRepository;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;
import java.util.Optional;

public final class OrdersHandler implements Route {
    private final OrderRepository repository;

    //private OrdersHandler() {}
    //public static final OrdersHandler INSTANCE = new OrdersHandler();

    public OrdersHandler(OrderRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }



    @Override
    public Object handle(Request request, Response response) throws Exception {
        //return "Hello World";
        final String ID = request.params(":ID");
        final Long longID = Long.valueOf(ID);

        final Optional<Order> order = repository.findByID(longID);
        final String info = order.map(o -> o.getID() + " " + o.getBuyer().getName())
                                    .orElse("Not found");
        return info;
    }
}
