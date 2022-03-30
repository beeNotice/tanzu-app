# Tanzu App

## Introduction

Spring-boot application used to demonstrate VMware Tanzu Application Platform

Components :

* Spring Web + Thymeleaf
* Spring Data JPA
* Spring Data REST
** /
** /helloes
** /prime/{num}
* Spring Actuator
** /actuator
* Flyway with (Postgres & H2)
* Open API v3 with springdoc
** /v3/api-docs

## Tanzu Application Platform

Prerequisites to integrate the application to TAP
* TAP is installed and working with OOTB supply chain
* Developper namespace (dev) is created
* Postgresql deployed and accessible from the dev namespace as a ServiceBinding

## Launch

Local run

```
# Run DB
docker run -e POSTGRES_USER=pgappuser -e POSTGRES_PASSWORD=pgappuser -e POSTGRES_DB=postgres-tanzu-app -p 5432:5432 postgres:14.2
# Run App
./mvnw spring-boot:run
```

Docker run

```
# Build Image
./mvnw spring-boot:build-image
# Run app
docker-compose up
```

Tanzu Application Platform Integration

```
# Integrate to TAP
tanzu apps workload create -f config/workload.yaml
# Retrieve url
tanzu apps workload get tanzu-app-deploy -n dev
```

## Load testing

You can use the Gatling Simulation in the performance folder