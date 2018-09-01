package com.rathish.spring.webfluxdemo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository =  employeeRepository;
    }


    @GetMapping("/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable String id){
        log.info("Fetching employee with employee id {} ", id);
        return employeeRepository.findEmployeeById(id);
    }

    @GetMapping
    public Flux<Employee> getAllEmployees(){
        log.info("Fetching all employees");
        return employeeRepository.findAllEmployees();
    }


    @PostMapping("/update")
    public Mono<Employee> updateEmployee(@RequestBody Employee employee){
        log.info("Updating employee with employee id {} ", employee.getId());
        return employeeRepository.updateEmployee(employee);
    }
}
