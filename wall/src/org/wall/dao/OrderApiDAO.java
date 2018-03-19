package org.wall.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.wall.entity.OrderApiEntity;

@Component
public class OrderApiDAO {

    final ConcurrentHashMap<Long, OrderApiEntity> map = new ConcurrentHashMap<>();
    static Long count = 0L;

    public OrderApiEntity createOrderRequest(Long noOfBricks) {
        count = count + 1;
        map.put(count, new OrderApiEntity(count, noOfBricks));
        return map.get(count);
    }

    public OrderApiEntity getOrderRequest(Long order) {
        return map.get(order);
    }

    @SuppressWarnings("boxing")
    public List<OrderApiEntity> getAllOrderRequest(List<String> orders) {
        List<OrderApiEntity> list = new ArrayList<>();
        for (String order : orders) {
            OrderApiEntity entity = map.get(Long.parseLong(order));
            if (entity != null) {
                list.add(entity);
            }
        }
        return list;
    }

    public OrderApiEntity updateOrderRequest(OrderApiEntity order) {
        if (map.containsKey(order.getOrderId())) {
            OrderApiEntity updatedOrder = new OrderApiEntity(order.getOrderId(), order.getNoOfBricks());
            map.put(order.getOrderId(), updatedOrder);
            return map.get(order.getOrderId());
        }
        return null;
    }

    public OrderApiEntity fulfilOrderRequest(Long orderId) {
        if (map.containsKey(orderId)) {
            OrderApiEntity order = map.get(orderId);
            if (order.getDispatched()) {
                return null;
            }
            order.setDispatched(true);
            map.put(orderId, order);
            return map.get(order.getOrderId());
        }
        return null;
    }

    public OrderApiEntity updateFulfilOrderRequest(Long orderId) {
        if (map.containsKey(orderId)) {
            OrderApiEntity order = map.get(orderId);
            if (order.getDispatched()) {
                return null;
            }
            order.setDispatched(true);
            map.put(orderId, order);
            return map.get(order.getOrderId());
        }
        return null;
    }
}
