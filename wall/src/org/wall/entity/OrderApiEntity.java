package org.wall.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OrderApiEntity {

    private Long orderId;

    private Long noOfBricks;

    private boolean dispatched;

    public OrderApiEntity() {
    }

    public OrderApiEntity(Long orderId, Long noOfBricks) {
        setOrderId(orderId);
        setNoOfBricks(noOfBricks);
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getNoOfBricks() {
        return noOfBricks;
    }

    public void setNoOfBricks(Long noOfBricks) {
        this.noOfBricks = noOfBricks;
    }

    public boolean getDispatched() {
        return dispatched;
    }

    public void setDispatched(boolean dispatched) {
        this.dispatched = dispatched;
    }

}
