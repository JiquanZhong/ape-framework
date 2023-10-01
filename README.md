# Project Introduction

ape-frame, where "ape" denotes "猿" (a playful moniker for programmers in Chinese), aligns perfectly with our designation as programmers! I envision this framework as the go-to development framework for us programmers in the future.

I've always wanted to create a lightweight rapid development framework suited for small and medium-sized enterprises, encompassing common scenarios encountered in routine business development, ensuring it's ready to use right out of the box. Users can select components based on their individual needs, embracing a component-based development approach.

For instance, if a user requires Redis, they would select the Redis component; if WebSocket is needed, they would incorporate the WebSocket component. Users won't need to develop anything on their own, but simply follow the component rules for utilization.

Additionally, numerous examples are provided for some classic tools and design pattern code. Whenever users encounter these business scenarios, they can use them directly.

The project is developed using a Maven structure, encapsulating a multitude of modules, each decoupled from the others, catering to the everyday development needs of the users.

I hope everyone could lend a hand by giving a Star; your Star is the greatest support for me. Continuous updates are in progress, with microservices version being updated!

# Project Module Structure Introduction

## ape-cloud

Microservices module under development, currently includes the following modules:

- **ape-cloud-eureka**: Eureka service registration component
- **ape-cloud-eureka-server**: Eureka server for service governance and discovery
- **ape-cloud-ribbon**: Ribbon load balancing
- **ape-cloud-openFeign**: Feign remote invocation
- **ape-cloud-home**: Homepage microservice for microservice invocation scenarios
- **ape-cloud-sku**: SKU microservice for microservice invocation scenarios

## ape-common

- **ape-common-job**: Distributed task scheduling component
- **ape-common-log**: Logging component, provides automatic logging aspect and asynchronous log enhancement for performance
- **ape-common-mybatisplus**: Interacts with the database using Mybatisplus
- **ape-common-redis**: Cache component, provides encapsulation of operations based on Redis, Redis distributed locks, Guava's cache utility class
- **ape-common-starter**: Starter class component, functionality related to starter classes is placed here, currently includes mongoStarter
- **ape-common-swagger**: Swagger component, provides entry point for accessing the project's API and method documentation
- **ape-common-test**: Testing component, integrates springboot-test and code unit testing, code coverage, and line coverage detection
- **ape-common-tool**: Common utility component, meets various needs for daily business development, ensuring security and low intrusion
- **ape-common-web**: Web component, provides unified exception handling, web module conversion, and unified return values
- **ape-common-websocket**: WebSocket component, provides an authenticated WebSocket system, easy to use and convenient
- **ape-mail**: Email sending component

## ape-demo

The demo provides numerous examples to teach users how to utilize this project framework directly. During development, you can refer to this module to establish your own projects. Currently, the provided sample functionalities include:

## ape-dependencies

This module serves as a parent POM module, providing overall Maven package management and standardization, ensuring unified upgrades and dependencies.

# Contributions

I welcome everyone to raise issues and collaborate on improving this framework. Your valuable suggestions are greatly appreciated as we aim to develop it into a commercial development framework. If you feel that our code can be optimized or have better solutions, please feel free to submit pull requests at any time.
