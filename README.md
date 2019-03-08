# springboot-crud-demo

Spring Boot CRUD demo is demonstrating how to implement simple CRUD operations with a 'Product' entity.
This CRUD demo inlcudes Spring Pagination, Spring Validation of fields, Datatables used for searching in table and sorting the table columns.

## What's inside 
This project is based on the [Spring Boot](http://projects.spring.io/spring-boot/) project and uses these packages :
- Maven
- Spring Core
- Spring Data (Hibernate & MySQL)
- Spring MVC (Tomcat)
- [Thymleaf](https://thymeleaf.org)

![demo](https://github.com/ccheruku/sprinboot-crud-demo-master/blob/release/docker1/src/main/resources/static/images/demo.GIF?raw=true)

## Installation 
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

## Database configuration 
Create a MySQL database with the name 'TestDB' and add the credentials to '/resources/application.properties'.  
The default ones are :

'''
spring.datasource.url=jdbc:mysql://localhost:3306/TestDB
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
'''

## Usage 
Run the project through the IDE and head out to [http://localhost:8080](http://localhost:8080)

or 

run this command in the command line:
'''
mvn spring-boot:run
'''
