## Product Microservice Documentation

### Overview

The Product Microservice is responsible for managing products in the e-commerce application. It provides endpoints for creating, retrieving, updating, and deleting products.

### Endpoints

#### Welcome

- **URL:** `/api/product/`
- **Method:** `GET`
- **Description:** Welcome message to the Product Microservice.
- **Response:** Welcome message string.

#### Create Product

- **URL:** `/api/product`
- **Method:** `POST`
- **Description:** Creates a new product.
- **Request Body:** `ProductRequest`
    - `name`: Name of the product.
    - `price`: Price of the product.
    - `quantity`: Quantity of the product available.
    - `imageUrl`: URL of the product image.
- **Response:** None

#### Get All Products

- **URL:** `/api/product`
- **Method:** `GET`
- **Description:** Retrieves all products.
- **Response:** List of all products in the system.

#### Get Product by Name

- **URL:** `/api/product/{name}`
- **Method:** `GET`
- **Description:** Retrieves a product by its name.
- **Request Parameters:**
    - `{name}`: Name of the product to retrieve.
- **Response:** Details of the product with the specified name.

#### Update Product

- **URL:** `/api/product/{name}`
- **Method:** `PUT`
- **Description:** Updates an existing product.
- **Request Parameters:**
    - `{name}`: Name of the product to update.
- **Request Body:** `ProductRequest`
    - Updated details of the product, including name, price, quantity, and image URL.
- **Response:** Success message indicating the product was updated.

### Models

#### Product

Represents a product in the system.

- **Fields:**
    - `id`: Unique identifier of the product.
    - `name`: Name of the product.
    - `price`: Price of the product.
    - `quantity`: Quantity of the product available.
    - `imageUrl`: URL of the product image.
    - `ratings`: Ratings associated with the product.

#### ProductRequest

Request DTO for creating or updating a product.

- **Fields:**
    - `id`: Unique identifier of the product.
    - `name`: Name of the product.
    - `price`: Price of the product.
    - `quantity`: Quantity of the product available.
    - `imageUrl`: URL of the product image.
    - `ratings`: Ratings associated with the product.

#### ProductResponse

Response DTO for retrieving product details.

- **Fields:**
    - `id`: Unique identifier of the product.
    - `name`: Name of the product.
    - `price`: Price of the product.
    - `quantity`: Quantity of the product available.
    - `imageUrl`: URL of the product image.
    - `ratings`: Ratings associated with the product.

### Service

#### ProductService

Provides business logic for handling product-related operations.

- **Methods:**
    - `createProduct(productRequest)`: Creates a new product.
    - `getAllProducts()`: Retrieves all products.
    - `findProductByName(name)`: Retrieves a product by name.
    - `updateProduct(name, productRequest)`: Updates an existing product.

---

Feel free to expand on each section as needed, providing more details about request/response formats, error handling, and any additional functionality.