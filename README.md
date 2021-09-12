# kafka-example

Contains some services:

* discovery server (eureka server)
* user service (eureka client)
* mail service (eureka client)
* spring cloud gateway (eureka client)

End user will create request to `gateway` to create a user object.
Gateway will forward request to `user` service.
After creating user object, in `user` service, will send a kafka message to `mail` service
Kafka message will be pick by `mail` service and write some console log (instead of sending real email which is not really needed)

# Improvement points:

Apply spring cloud config.

Try with docker-compose:

    version: '2'

    networks:
    app-tier:
        driver: bridge

    services:
    zookeeper:
        image: 'bitnami/zookeeper:latest'
        networks:
        - app-tier
    kafka:
        image: 'bitnami/kafka:latest'
        networks:
        - app-tier
    myapp:
        image: 'YOUR_APPLICATION_IMAGE'
        networks:
        - app-tier
