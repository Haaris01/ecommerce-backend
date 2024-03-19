# E-Commerce Microservices Application

Welcome to our e-commerce microservices application! This application is built using Spring Boot for the backend services and React for the frontend interface. It consists of multiple microservices, each responsible for specific functionalities such as product management, cart management, and order processing.

## Table of Contents
1. [Features](#features)
2. [Technologies Used](#technologies-used)
3. [Getting Started](#getting-started)
4. [API Documentation](#api-documentation)
5. [Contributing](#contributing)
6. [License](#license)

## Features
- User authentication and authorization
- Product browsing, searching, and filtering
- Cart management: adding, updating, and removing items
- Order processing and tracking
- Admin dashboard for product and order management

## Technologies Used
- Backend:
    - Spring Boot
    - Spring Data MongoDB
    - Spring Security
    - Spring Cloud Gateway
- Frontend:
    - React
    - Redux
    - React Router
    - Bootstrap
- Database:
    - MongoDB
- API Gateway:
    - Spring Cloud Gateway
- Authentication:
    - JSON Web Tokens (JWT)
- Containerization:
    - Docker
    - Docker Compose

## Getting Started
To run this application locally, follow these steps:

1. Clone this repository.
2. Navigate to the root directory of each microservice (e.g., `product-service`, `cart-service`).
3. Run `mvn spring-boot:run` for each Spring Boot microservice.
4. Navigate to the `frontend` directory.
5. Run `npm install` to install dependencies.
6. Run `npm start` to start the React development server.
7. Access the application at `http://localhost:3000` in your web browser.

## API Documentation
For detailed API documentation, refer to the individual `README.md` files in each microservice directory. Each microservice provides its own API endpoints and functionalities.

## Contributing
We welcome contributions from the community! If you'd like to contribute to this project, please follow these guidelines:
- Fork the repository.
- Create a new branch (`git checkout -b feature/your-feature`).
- Make your changes and commit them (`git commit -am 'Add new feature'`).
- Push your changes

## Cart Controller

### Endpoints:

- **GET /api/cart/{userId}**: Retrieves the cart items for a specific user.
- **POST /api/cart/create**: Creates a new cart for a user and adds an item to it.
- **DELETE /api/cart/delete/{userId}**: Deletes a specific item from the user's cart.
- **DELETE /api/cart/delete/cart/{userId}**: Deletes the entire cart for a user.
- **PUT /api/cart/update/{userId}**: Updates the user's cart by adding or updating an item.

### Sample Usage:

1. **GET /api/cart/{userId}**:
    - **Description**: Retrieve the cart items for a specific user.
    - **Request**: GET `/api/cart/{userId}`
    - **Response**: JSON array of cart items.

2. **POST /api/cart/create**:
    - **Description**: Create a new cart for a user and add an item to it.
    - **Request**: POST `/api/cart/create`
    - **Body**:
      ```json
      {
        "userId": "user123",
        "item": {
          "productId": "prod123",
          "quantity": 2,
          "deliveryDate": "2024-03-21"
        }
      }
      ```
    - **Response**: Status code 201 Created.

3. **DELETE /api/cart/delete/{userId}**:
    - **Description**: Delete a specific item from the user's cart.
    - **Request**: DELETE `/api/cart/delete/{userId}`
    - **Response**: Status code 200 OK.

4. **DELETE /api/cart/delete/cart/{userId}**:
    - **Description**: Delete the entire cart for a user.
    - **Request**: DELETE `/api/cart/delete/cart/{userId}`
    - **Response**: Status code 200 OK.

5. **PUT /api/cart/update/{userId}**:
    - **Description**: Update the user's cart by adding or updating an item.
    - **Request**: PUT `/api/cart/update/{userId}`
    - **Body**:
      ```json
      {
        "productId": "prod123",
        "quantity": 3,
        "deliveryDate": "2024-03-25"
      }
      ```
    - **Response**: Status code 202 Accepted.

## Cart Service

The Cart Service handles the business logic for managing carts and cart items. It interacts with the database to perform CRUD operations on carts.

## Cart Model

The Cart Model represents the structure of a user's cart, including the user ID, cart items, and cart ID. It is stored in the MongoDB database.

## Cart Request DTO

The Cart Request DTO (Data Transfer Object) is used to transfer data from the client to the server when creating or updating a cart. It contains the user ID and details of the cart item to be added or updated.

## Cart Item DTO

The Cart Item DTO represents the structure of a single item in the cart, including the product ID, quantity, and delivery date.

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

