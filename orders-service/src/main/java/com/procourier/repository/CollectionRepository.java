package com.procourier.repository;

import com.procourier.model.Order;
import com.procourier.model.repository.OrderRepository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class CollectionRepository implements OrderRepository{
    private final Map<Long, Order> orders = new HashMap<>();

    @Override
    public Optional<Order> findByID(Long ID) {
        return Optional.ofNullable(orders.get(ID));
    }

    @Override
    public List<Order> getAll() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public Long put(Order item) {
        orders.put(item.getID(), item);
        return item.getID();
    }

    //predicat -> functie care primeste param si intoarce boolean

    @Override
    public List<Long> putAll(List<Order> items) {
        final var ids = items.stream()
                            .map(Order::getID)
                            .collect(Collectors.toList());
        final Map<Long, Order> newValues =  items.stream()
                                               .collect(Collectors.toMap(Order::getID, Function.identity()));
        orders.putAll(newValues);
        return ids;
    }
}
