# URL Shortener App

[![Java](https://img.shields.io/badge/Java-21%2B-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-Build-red)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-blue)](LICENSE)

A simple URL shortener REST API built with Spring Boot. It accepts a URL and generates a unique code for it.

## Features

* REST API built with Spring Boot
* Returns `201 CREATED` when a URL is successfully created
* Layered architecture using `controller`, `service`, and `repository` packages
* Dependency Injection using Spring IoC
* Error handling

## Testing

### Create a shortened URL

**Request**

```ps
curl -Uri "http://localhost:8080/links" `
    -Method POST `
    -Headers @{ "Content-Type" = "application/json" } `
    -Body '{"url":"example.com"}'
```

**Response**

```ps
StatusCode : 201

Content    : {"url":"example.com","code":"cad06b7e-447b-4427-a5ba-d47895a85308"}
```

## Getting Started

### Prerequisites

* Java 21+
* Maven

### Run the application

```bash
./mvnw spring-boot:run
```

The API will be available at:

```text
http://localhost:8080/links
```
