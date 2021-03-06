[![CircleCI](https://circleci.com/gh/sirlopu/dojo-reservation-system/tree/master.svg?style=svg)](https://circleci.com/gh/sirlopu/dojo-reservation-system/tree/master)

# Dojo Reservation System

A reservation system where customers can log in and reserve a time to use the dojo for coding, game nights, birthday parties, etc.
Each amenity will have a certain capacity so that people can make use of the center safely during the COVID-19 pandemic. 

## Technologies
* Spring Boot
* Thymeleaf
* Hibernate
* Spring Security
* Maven
* JPA
* MySQL
* Bootstrap

## Use Cases / User Stories

* Customers should be able to log in.
* We will assume that the customer accounts are pre-created and there will be no sign-up feature.
* Customers should be able to view their reservations.
* Customers should be able to create new reservations by selecting the amenity type, date, and time.
* Customers should be able to update their reservations.
* Customers should be able to delete their reservations.
* Only logged-in customers should be able to see the reservations page and create reservations.
* We should check the capacity and only create new reservations if the current number of reservations does not exceed the capacity.

## TO-DO
* Containerized application
* Implement new frontend using React or Flutter
* Integrate with CRM to keep customer accounts up-to-date
