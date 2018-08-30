package com.rathish.spring.webfluxdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository =  employeeRepository;
    }


    @GetMapping("/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable String id){
        return employeeRepository.findEmployeeById(id);
    }

    @GetMapping
    public Flux<Employee> getAllEmployees(){
        return employeeRepository.findAllEmployees();
    }


    @PostMapping("/update")
    public Mono<Employee> updateEmployee(@RequestBody Employee employee){
        return employeeRepository.updateEmployee(employee);
    }
}
