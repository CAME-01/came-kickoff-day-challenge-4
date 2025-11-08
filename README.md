# Spring Boot JSON Fetcher with MySQL Persistence

This Spring Boot application periodically fetches
JSON data from a remote API, transforms it into entities,
and stores it in a MySQL database. It also automatically refreshes
the data every **five seconds.**

### Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL 8+**
- **Lombok**
- **Maven 3.8+**

### Prerequisites

- **Java 17** or higher
- **Maven 3.8+**
- **MySQL 8.0+** (running locally or remotely)

### Configuration

Update your **`src/main/resources/application.properties`** file with your database credentials:

```
person.data.url=https://microsoftedge.github.io/Demos/json-dummy-data/64KB.json
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.jdbc.batch_size=50
spring.datasource.url=jdbc:mysql://localhost:3306/rest-mysql-db?createDatabaseIfNotExist=true
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
```
