# axon-spring-boot-expl

## Intro
Demo project for [Axon Fwk](http://axoniq.io) with Spring Boot

_(**Note**: please bear in mind that the structure of this project may vary from the proposed one in the official [Axoniq.io website](https://docs.axoniq.io/reference-guide/quick-start))_ 

## Fwks., Tools and Versions
- Java 1.8 _(Not 11 due to [kotlin-stdlib-jdk8](https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib-jdk8/1.3.50))_
- Spring Boot 2.1.8.RELEASE _(Actuator + Web + DevTools + Data JPA + Data Rest + H2 + Axon starter)_
- [Kotlin](https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib-jdk8/1.3.50) 1.3.50
- [Jackson Kotlin](https://mvnrepository.com/artifact/com.fasterxml.jackson.module/jackson-module-kotlin/2.10.0) 2.10.0
- [Lombok](https://projectlombok.org/) 1.18.1
- [AssertJ](https://joel-costigliola.github.io/assertj/) 3.13.2
- [Pragmatists/JUnitParams](https://github.com/Pragmatists/JUnitParams) 1.1.1

## References
- [A Guide to the Axon Framework _(by baeldung)_](https://www.baeldung.com/axon-cqrs-event-sourcing)
- [Axon reference guide _(by axoniq.io)_](https://docs.axoniq.io/reference-guide/)
- [Axon youtube channel _(by axoniq.io)_](https://www.youtube.com/channel/UCQb0g7zJCWrzkpxznSUkERw/videos)
- [GOTO 2019 • CQRS & Event Sourcing Apps with Axon & Pivotal Cloud Foundry • S. v. Beelen & B. Wilcock _(youtube)_](https://www.youtube.com/watch?v=moRDmcl5_WY)
- [Axon - CQRS with Spring Boot by examples](https://sgitario.github.io/axon-by-example/)
- [Implementing Event Sourcing Using Axon and Spring Boot - Part 1 _(by dzone)_](https://dzone.com/articles/implementing-event-sourcing-using-axon-and-spring)
- [Implementing Event Sourcing with Axon and Spring Boot – Part 2 _(by progressivecoder)_](http://progressivecoder.com/implementing-event-sourcing-with-axon-and-spring-boot-part-2/)

## Local Dev. platform
- [Axon Server Docker container](https://hub.docker.com/r/axoniq/axonserver/) _(accessible at http://localhost:8024)_