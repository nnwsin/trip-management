Trip Management System

Overview

The Trip Management System is a backend application built using Spring Boot that allows a single user to book and manage trips for their family. Users can book multiple tickets for trains, planes, and buses, providing details for each family member and handling transactions securely.

Features

User authentication and management.

Book trips for multiple family members.

Support for different travel categories: Train, Plane, Bus.

Store trip details, including:

Departure source.

Destination details.

Time of departure.

Vendor name (e.g., Vistara Airlines, Air India, Qatar Airways).

Secure payment handling for transactions.

RESTful API endpoints for trip creation, retrieval, and management.

Tech Stack

Backend: Java, Spring Boot, Spring Data JPA

Database: MySQL

Security: Spring Security, JWT Authentication

Build Tool: Maven

Installation & Setup

Clone the repository:

git clone https://github.com/nnwsin/trip-management.git

Navigate to the project directory:
cd trip-management-system

cd trip-management-system
spring.datasource.url=jdbc:mysql://localhost:3306/trip_db
spring.datasource.username=root
spring.datasource.password=yourpassword

Configure the database settings in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/trip_db
spring.datasource.username=root
spring.datasource.password=yourpassword

Build and run the application:
mvn spring-boot:run

mvn spring-boot:run

API Endpoints

User Management

POST /api/users/register - Register a new user

POST /api/users/login - Authenticate and receive a token

Trip Management

POST /api/trips/book - Book a new trip

GET /api/trips/{id} - Get trip details by ID

GET /api/trips/user/{userId} - Get all trips booked by a user

DELETE /api/trips/{id} - Cancel a trip

Future Enhancements

Integration with third-party payment gateways.

Implementing seat selection for bookings.

Adding notifications and reminders for trips.

Author

Rohit Kumar