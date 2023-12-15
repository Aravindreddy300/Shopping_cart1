package com.shop.entity;


import org.springframework.validation.annotation.Validated;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Validated
public class Product {


	public Product() {
		super();
	}


	public Product(Long id, @NotBlank(message = "Name is required") String name,
			@Positive(message = "Price must be greater than 0") double price,
			@NotBlank(message = "Category is required") String category, Stock stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.stock = stock;
		//this.customer = customer;
	}
	


	public Product(Long id, @NotBlank(message = "Name is required") String name,
			@Positive(message = "Price must be greater than 0") double price,
			@NotBlank(message = "Category is required") String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}


	public Product(@NotBlank(message = "Name is required") String name,
			@Positive(message = "Price must be greater than 0") double price,
			@NotBlank(message = "Category is required") String category) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
	}



	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Positive(message = "Price must be greater than 0")
    private double price;

    @NotBlank(message = "Category is required")
    private String category;

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="profuct_id",referencedColumnName = "id")
    private Stock stock;


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


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Stock getStock() {
		return stock;
	}


	public void setStock(Stock stock) {
		this.stock = stock;
	}




	



   
    
}