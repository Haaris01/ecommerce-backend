## Order Microservice Documentation

### Overview

The Order Microservice is responsible for managing orders in the e-commerce application. It provides endpoints for retrieving, creating, and updating orders for users.

### Endpoints

#### Retrieve Orders by User ID

- **URL:** `/api/order/{userId}`
- **Method:** `GET`
- **Description:** Retrieves orders associated with the specified user ID.
- **Request Parameters:**
    - `{userId}`: The unique identifier of the user.
- **Response:**
    - `OrderResponse`: Contains a list of orders associated with the user.

#### Create Order

- **URL:** `/api/order/createOrder`
- **Method:** `POST`
- **Description:** Creates a new order for the user.
- **Request Body:** `OrderRequest`
    - `userId`: The unique identifier of the user placing the order.
    - `ordersList`: Details of the order, including order ID, date placed, and order details.
- **Response:** None

#### Update Order

- **URL:** `/api/order/updateOrder`
- **Method:** `PUT`
- **Description:** Updates an existing order for the user.
- **Request Body:** `OrderRequest`
    - `userId`: The unique identifier of the user placing the order.
    - `ordersList`: Updated details of the order, including order ID, date placed, and order details.
- **Response:** None

### Models

#### Orders

Represents an order placed by a user.

- **Fields:**
    - `userId`: The unique identifier of the user.
    - `ordersList`: List of orders associated with the user.

#### OrderDetails

Details of a specific order item within an order.

- **Fields:**
    - `productId`: The unique identifier of the product.
    - `quantity`: The quantity of the product ordered.
    - `deliveryOptionId`: The unique identifier of the delivery option.

#### OrdersList

Represents a list of orders within an order.

- **Fields:**
    - `orderId`: The unique identifier of the order.
    - `datePlaced`: The date when the order was placed.
    - `orderDetails`: List of order details associated with the order.

### Service

#### OrderService

Provides business logic for handling order-related operations.

- **Methods:**
    - `returnOrders(userId)`: Retrieves orders by user ID.
    - `createOrder(orderRequest)`: Creates a new order.
    - `updateOrder(orderRequest)`: Updates an existing order.