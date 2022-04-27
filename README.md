[![CircleCI](https://circleci.com/gh/sirlopu/dojo-reservation-system/tree/master.svg?style=svg)](https://circleci.com/gh/sirlopu/dojo-reservation-system/tree/master)

# Dojo Reservation System

A reservation system where customers can log in and reserve a time to use the dojo for coding, game nights, birthday parties, etc.
Each amenity will have a certain capacity so that people can make use of the center safely during the COVID-19 pandemic. 


## Technologies
* Spring Boot
* Thymeleaf (*TODO: Implement new frontend using React or Flutter*)
* Hibernate
* Swagger
* Spring Security
* Maven
* JPA
* MySQL
* Bootstrap

## Use Cases / User Stories

* Customers should be able to log in.
* We will assume that the customer accounts are pre-created and there will be no sign-up feature.
  * *TODO: Integrate with CRM to keep customer accounts up-to-date*
* Customers should be able to view their reservations.
* Customers should be able to create new reservations by selecting the amenity type, date, and time.
* Customers should be able to update their reservations.
* Customers should be able to delete their reservations.
* Only logged-in customers should be able to see the reservations page and create reservations.
* We should check the capacity and only create new reservations if the current number of reservations does not exceed the capacity.


## Dev Environment Notes

### Kubernetes Config

Use Spring Boot Maven plugin to build image:

(Assumption) pom.xml:
```shell
<spring-boot.build-image.imageName>sirlopu/${project.artifactId}:${project.version}</spring-boot.build-image.imageName>
```

In Terminal, run:
```shell
mvnw spring-boot:build-image
```

Confirm docker image was created:

```shell
docker images [docker_username]/dojo-reservation-system
```

**NOTE:**
  *Image will show as "created 42 years ago". Yes, it is correct.*


Push to Docker Hub (ensure to invoke `docker login`)

```shell
mvnw k8s:push
```

Run the following command to invoke the Kubernetes Maven plugin to generate Kubernetes manifests.

```shell
mvnw k8s:resource
```