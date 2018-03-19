package org.wall.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.wall.entity.OrderApiEntity;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

public class BricksApiDAOTest extends JerseyTest {

    private WebResource ws;

    public BricksApiDAOTest() {
        super(new WebAppDescriptor.Builder("org.wall.test").build());
    }

    @Test
    public void testGetOrder() {
        ws = resource().path("order");
        ClientResponse response = ws.type("application/json").post(ClientResponse.class, Long.valueOf(10));
        assertEquals(201, response.getStatus());
        ws = resource().path("order/10");
        OrderApiEntity out = response.getEntity(OrderApiEntity.class);
        assertEquals(Long.valueOf(10), out.getNoOfBricks());
    }

}