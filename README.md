# spring-microservices

Contains example codes for different Spring Boot and Spring Cloud technologies.

Spring Boot
-----------
- Spring Web
- Spring Data JPA
- Actuator
- HATEOAS

Spring Cloud
---------------
- Config Server and Config Client
- Open Feign Client
- Eureka Naming and Discovery
- Ribbon Load Balancing
- Zuul API Gateway
- Sleuth for distributed tracing
- Zipkin distributed tracing
- Spring cloud Bus
- Hystrix for fault tolerance

Others
----------------
- Springfox Swagger 2
- H2


Running Zipkin
===================
1. Install RabbitMQ
----------------------
docker pull rabbitmq
docker run -d --hostname my-rabbit --name some-rabbit rabbitmq:3

2. Set RABBIT_URI (to be used by Zipkin)
---------------------------------
export RABBIT_URI=amqp://localhost

3. Install and run Zipkin
----------------------
docker run -d -p 9411:9411 openzipkin/zipkin

4. Open Zipkin UI
--------------------
http://localhost:9411/zipkin


