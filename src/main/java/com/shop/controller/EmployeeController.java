package com.shop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.Employee;
import com.shop.entity.Product;
import com.shop.exception.CustomerNotFoundException;
import com.shop.exception.EmployeeNotFoundException;
import com.shop.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) throws EmployeeNotFoundException {
    	
    	Optional<Employee> employee = employeeService.getEmployeeById(id);
    	
    	 employee.orElseThrow(()-> new EmployeeNotFoundException("customer not found "+id));
          	
    	  	   	
    	
      return employee.get();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employeeService.getEmployeeById(id).get();

        employee.setId(id);
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.getEmployeeById(id).get();

        employeeService.deleteEmployee(id);
    }

    @PostMapping("/confirmorder/{oId}/{eId}")
    public String confirmOrder(@PathVariable Long oId, @PathVariable Long eId) {
    	employeeService.confirm(oId,eId);
        return "Order confirmed for employee with orderId " + oId;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
