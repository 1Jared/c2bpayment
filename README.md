# c2bpayment
# B2C API Handlers

## Requirements
- Java 17
- Maven
- MongoDB
- Kafka

## Setup
1. Clone the repository
2. Configure MongoDB and Kafka in `application.properties`
3. Build the project
    mvn clean install
4. Run the application
    mvn spring-boot:run

## API Endpoints
- `POST /b2c/request`: Receive a B2C request
- `GET /b2c/request/{id}`: Fetch payment status
- `PUT /b2c/request/{id}`: Update payment status

## Testing
Run the tests using the following command:
mvn test
