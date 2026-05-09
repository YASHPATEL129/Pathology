# Pathology Lab Management System - Backend

Spring Boot backend for the Pathology Lab Management System.

## 🚀 API Endpoints

### Tests
- `GET /api/tests`: Get all tests.
- `GET /api/tests/active`: Get all active tests.
- `POST /api/tests`: Create a new test.

### Orders
- `GET /api/orders/today`: Get all orders created today.
- `GET /api/orders/{orderId}/items`: Get all tests and results for a specific order.
- `POST /api/orders`: Create a new patient order.

### Results
- `POST /api/results/{orderItemId}`: Save test result for an order item.
- `GET /api/results/order/{orderId}`: Get completed results for an order.

## 🛠️ Setup
1. Ensure MySQL is running and create a `pathology` database.
2. Update `application.properties` with your database username and password.
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## 📋 Database Schema
The system uses three main tables:
- `pathology_test`: Stores test master data.
- `test_order`: Stores patient details and order metadata.
- `test_order_item`: Stores specific tests requested in an order and their results.
