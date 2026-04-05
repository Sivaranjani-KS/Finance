# Finance Data Processing and Access Control Backend

##  Project Overview

This project is a backend system for a finance dashboard that manages users, financial transactions, and role-based access control. It provides APIs to perform CRUD operations on financial records and generate dashboard summaries.


##  Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven


##  User Roles

The system supports three roles:

* **ADMIN** → Full access (create, update, delete users & transactions)
* **ANALYST** → View data and dashboard insights
* **VIEWER** → Read-only access (cannot modify data)


##  Features

### 1. User Management

* Create users
* View all users
* Assign roles (ADMIN / ANALYST / VIEWER)

### 2. Transaction Management

* Create transactions
* View all transactions
* Update transactions
* Delete transactions

### 3. Dashboard Summary

* Total Income
* Total Expense
* Net Balance


##  Access Control

* VIEWER cannot create, update, or delete transactions
* ADMIN has full access
* Role-based restrictions implemented in service layer


##  Validation & Error Handling

* Input validation using annotations (`@NotBlank`, `@Email`, `@Pattern`, etc.)
* Proper HTTP status codes:

  * 400 → Bad Request (invalid input)
  * 403 → Forbidden (unauthorized action)
  * 404 → Not Found (resource not found)
  * 500 → Internal Server Error


##  Data Persistence

* Uses MySQL database
* JPA entities for User and Transaction
* Relationship:

  * One User → Many Transactions (`@ManyToOne`)


## API Endpoints

###  User APIs

* `POST /user` → Create user
* `GET /user` → Get all users


###  Transaction APIs

* `POST /transaction` → Create transaction
* `GET /transaction` → Get all transactions
* `PUT /transaction/{id}` → Update transaction
* `DELETE /transaction/{id}` → Delete transaction


###  Dashboard API

* `GET /dashboards/summary` → Get income, expense, balance


## How to Run the Project

1. Clone the repository
2. Open in IntelliJ / Eclipse
3. Configure MySQL database:

   * Create database: `finance_db`
4. Update `application.properties`:

   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
   spring.datasource.username=root
   spring.datasource.password=Siva_kutty@123
   ```
5. Run the application
6. Access APIs using Postman:

   ```
   http://localhost:8081
   ```


## Testing

Use Postman to test APIs:

* Valid input → 200 OK
* Invalid input → 400 Bad Request
* Unauthorized role → 403 Forbidden
* Non-existing resource → 404 Not Found


##  Assumptions

* Balance = Income − Expense
* Roles are manually assigned
* No authentication implemented (simplified for assignment)



##  Conclusion

This project demonstrates backend development skills including API design, data modeling, validation, error handling, and role-based access control using Spring Boot.


