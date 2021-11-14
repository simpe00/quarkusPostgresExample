# example project

[![Actions Status](https://github.com/simpe00/quarkusPostgresExample/workflows/Java%20CI%20with%20Gradle/badge.svg)](https://github.com/simpe00/quarkusPostgresExample/actions)

This is a showcase project.

Table of Contents
=================

* [example project](#example-project)
* [Table of Contents](#table-of-contents)
  * [Running the application in dev mode](#running-the-application-in-dev-mode)
  * [Packaging and running the application](#packaging-and-running-the-application)
  * [Creating a native executable](#creating-a-native-executable)
  * [Start production mode with docker-compose](#start-production-mode-with-docker-compose)
  * [Start production mode with minikube](#start-production-mode-with-minikube)
  * [Guids &amp; miscellanies](#guids--miscellanies)
    * [commands](#commands)
    * [links](#links)
  * [TODO for future](#todo-for-future)

#
## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_** for develop - **quarkusDev** - only the database is needed. So just use the docker-compose.db.yml file or another postgres.

## Packaging and running the application

The application can be packaged using:
```shell script
./gradlew build
```

## Creating a native executable

You can create a native executable using: 
```shell script
./gradlew build -Dquarkus.package.type=native
```

## Start production mode with docker-compose

First, take sure that you already have generated a jar for the docker build.

build the container
````shell script
docker-compose -f docker-compose.yml build --no-cache
````

start both containers
````shell script
docker-compose -f docker-compose.db.yml -f docker-compose.yml up -d   
````

> **_NOTE:_** in this example, the swagger-ui is always available at http://localhost:8080/q/swagger-ui .

## Start production mode with minikube

For using the project with minikube.

minikube yml via kompose (just as a template)
````commandline
kompose convert -f docker-compose.db.yml -f docker-compose.yml --out minikube.template.yaml
````

deploy service to minikube
````commandline
kubectl apply -f minikube.yaml
````

The endpoint for the swagger-ui is: http://**{IPAddress}**:30080/q/swagger-ui/

## Guids & miscellanies

#### commands

get all pods
````commandline
kubectl get pods -A
````

#### links

[quarkus - Rest json](https://quarkus.io/guides/rest-json)

[quarkus PostgreSQL Example](https://www.coding-daddy.xyz/node/45)

[reactive sql clients](https://quarkus.io/guides/reactive-sql-clients)

[testing with in-memory databases](https://quarkus.io/guides/datasource#in-memory-databases)

[example for postgres](https://www.techtalksteve.com/blog/2-first-microservice-with-quarkus/)

[quarkus - postgres - ORM Panache](https://quarkus.io/guides/hibernate-orm-panache)

[implement health check](https://quarkus.io/guides/smallrye-health)

[example kubernetes config](https://github.com/OpenLiberty/guide-kubernetes-microprofile-health/blob/b3f1effc1206582474f373fc5b6eacb31470b023/finish/kubernetes.yaml)


> **_NOTE:_** the **ReadinessCheck** for the datasource is allready implemented by the **quarkus-smallrye-health** [datasource-health-check](https://quarkus.io/guides/datasource#datasource-health-check)


## TODO for future

* [quarkus - Kubernetes Extension](https://quarkus.pro/guides/deploying-to-kubernetes.html)
  * automatically provide a kubernetes.yml

* [infrastructure as code ](https://www.terraform.io/)
  * shall provide the infrastructure needed, e.g. docker, minikube etc.
