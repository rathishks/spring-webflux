package com.rathish.spring.webfluxdemo;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// Consumer Webclient - invoked from WebfluxDemoApplication
public class EmployeeWebClient {

    private final WebClient employeeWebClient =  WebClient.create("http://localhost:8080");

    public void consume(){
        Mono<Employee> employeeMono = employeeWebClient.get()
                .uri("/employees/{id}", "1")
                .retrieve()
                .bodyToMono(Employee.class);
        employeeMono.subscribe(System.out::println);

        Flux<Employee> employeeFlux = employeeWebClient.get()
                .uri("/employees")
                .retrieve()
                .bodyToFlux(Employee.class);
        employeeFlux.subscribe(System.out::println);

        /* Output
        Employee(id=1, name=Employee 1)
        Employee(id=2, name=Employee 2)
        Employee(id=3, name=Employee 3)
        Employee(id=4, name=Employee 4)
        Employee(id=5, name=Employee 5)
        Employee(id=6, name=Employee 6)
        Employee(id=7, name=Employee 7)
        Employee(id=8, name=Employee 8)
        Employee(id=1, name=Employee 1) - *****.
        Employee(id=9, name=Employee 9)
        Employee(id=10, name=Employee 10)*/

    }
}
