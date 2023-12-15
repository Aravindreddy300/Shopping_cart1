package com.shop.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employee")
@Validated
public class Employee {
	
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

	@NotNull(message = "Salary cannot be null")
    @Min(value = 0, message = "Salary must be a non-negative value")
    private double salary;

	@NotBlank(message = "Position cannot be blank")
    private String position;
    public Employee() {
		super();
	}

	public Employee(Long id, String name, double salary, String position) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.position = position;
		
	}

	
    
    @ManyToMany
    private Set<Order> orders=new HashSet<>();
    
    private int ordersAccepted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public int getOrdersAccepted() {
		return ordersAccepted;
	}

	public void setOrdersAccepted(int ordersAccepted) {
		this.ordersAccepted = ordersAccepted;
	}
    
    
    
    
    
}
