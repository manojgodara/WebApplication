package org.wall.resource;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wall.dao.OrderApiDAO;
import org.wall.entity.OrderApiEntity;

@Component
@Path("/order")
public class BricksApiResource {

    @Autowired
    private OrderApiDAO m_dao;

    @GET
    @Path("/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrder(@PathParam("orderId") Long orderId) {

        OrderApiEntity order = m_dao.getOrderRequest(orderId);
        if (order != null) {
            return Response.status(200).entity(order).build();
        }
        return Response.status(400).entity("Invalid Order.").build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrder(@QueryParam("orders") String orderIds) {

        String[] orders = orderIds.split(",");
        List<String> orderStrIds = Arrays.asList(orders);

        List<OrderApiEntity> entities = m_dao.getAllOrderRequest(orderStrIds);
        if (entities != null) {
            return Response.status(200).entity(entities).build();
        }
        return Response.status(400).entity("Invalid Order.").build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response placeOrder(Long noOfBricks) {
        OrderApiEntity order = m_dao.createOrderRequest(noOfBricks);
        return Response.status(201).entity(order).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOrder(OrderApiEntity order) {
        OrderApiEntity entity = m_dao.updateOrderRequest(order);
        if (entity != null) {
            return Response.status(200).entity(entity).build();
        }
        return Response.status(400).entity("Invalid Order.").build();
    }

    @PUT
    @Path("/fulfil")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response fulfilOrderRequest(Long orderId) {
        OrderApiEntity entity = m_dao.fulfilOrderRequest(orderId);
        if (entity != null) {
            return Response.status(200).entity(entity).build();
        }
        return Response.status(400).entity("Invalid Order.").build();
    }

}