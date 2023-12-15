package com.shop.entity;


import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="carts")

public class Cart {

   

	public Cart() {
		super();
	}
	
	

public Cart(Long id, int quantity, List<Product> products, Customer customer) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.products = products;
		this.customer = customer;
	}



//	public Cart(Long id,  @NotBlank int quantity, Product product, Customer customer) {
//		super();
//		this.id = id;
//		
//		this.quantity = quantity;
//		this.product = product;
//		this.customer = customer;
//	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}



	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  // Assuming you have a primary key for the Cart entity


    
   
    private int quantity;
    
    @OneToMany
    private List<Product> products;
    
    @OneToOne
    private Customer customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

//	@Override
//	public String toString() {
//		return "Cart [id=" + id + ", quantity=" + quantity + ", product=" + product + ", customer="
//				+ customer + "]";
//	}

	
    

   }
