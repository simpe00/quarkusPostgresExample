# quarkus-tutorial Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./gradlew build
```
It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/quarkus-tutorial-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.

## Related Guides

- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)


## Additional Guid

This is a showcase project.

### start production mode with docker-compose

First, take sure that you already have generated a jar for the docker build.

build jar with gradle
````shell script
./gradlew build
````

Now you can bring up the containers.

docker-compose up
````shell script
docker-compose -f docker-compose.db.yml -f docker-compose.yml up -d   
````
> **_NOTE:_** for develop (quarkusDev) only the database is needed. So just use the docker-compose.db.yml file. 

> **_NOTE:_** in this example, the swagger-ui is always available at http://localhost:8080/q/swagger-ui .


minikube yml via kompose (just as a template)
````commandline
kompose convert -f docker-compose.db.yml -f docker-compose.yml --out minikube.template.yaml
````

deyploy service to minikube
````commandline
kubectl apply -f minikube.yaml
````

The endpoint for the swagger-ui is: http://[IPAddress]:30080/q/swagger-ui/

get all pods
````commandline
kubectl get pods -A
````

Links:

https://quarkus.io/guides/rest-json

https://www.coding-daddy.xyz/node/45

https://quarkus.io/guides/reactive-sql-clients

[example for postgres](https://www.techtalksteve.com/blog/2-first-microservice-with-quarkus/)

[quarkus - postgres - ORM Panache](https://quarkus.io/guides/hibernate-orm-panache)

rsync -r /mnt/c/Projekte/quarkus-tutorial/quarkus-tutorial/ ubuntu@192.168.178.94:/home/ubuntu/quarkus-tutorial/ --delete --exclude "SSH"