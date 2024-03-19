# E-Commerce Microservices API Documentation

Welcome to the API documentation for our e-commerce microservices application. This documentation provides an overview of the endpoints and functionalities of our cart service.

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

---