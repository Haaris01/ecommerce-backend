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
