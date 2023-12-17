package com.shop.dao;

import com.shop.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    
    // Retrieves a list of all employees
    List<Employee> getAllEmployees();
    
    // Retrieves an employee by their unique identifier
    Optional<Employee> getEmployeeById(Long id);
    
    // Saves or updates employee information
    Employee saveEmployee(Employee employee);
    
    // Deletes an employee by their unique identifier
    void deleteEmployee(Long id);
    
    // Confirms an employee with a given order and employee ID
    void confirm(Long oId, Long eId);
}
