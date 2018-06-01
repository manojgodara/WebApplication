# WebApplication
The task is to create a simple system ordering system for a fictional organisation that sells bricks.

# Rest Resources:

## To retrieve orders
    GET wallapi/restapi/order/{orderId}
        Response Body: (OrderApiEntity)entity 
        JSON Ex: {
          orderId: 1
          noOfBricks: 10
        }

    GET wallapi/restapi/order?orders=1,2..
    Response Body: List<OrderApiEntity> entities 
    JSON Ex: [
    {
      orderId: 1
      noOfBricks: 10
    }, .... 
    ]

## To submit new orders for bricks
    POST wallapi/restapi/order
    Request Body: (Long)noOfBricks
    Response Body: (OrderApiEntity)entity 
    JSON Ex: {
      orderId: 1
      noOfBricks: 10
    }

## To update orders for bricks
    PUT wallapi/restapi/order
    Request Body: (OrderApiEntity)entity 
    Response Body: (OrderApiEntity)updatedEntity 

    JSON Ex: {
      orderId: 1
      noOfBricks: 10
    }

## To note when orders have been dispatched
    PUT wallapi/restapi/order/fulfil
    Reuest Body: (Long)orderId
    Response Body: (OrderApiEntity)entity 
    JSON Ex: {
      orderId: 1,
      noOfBricks: 10,
      dispatched: true
    }
