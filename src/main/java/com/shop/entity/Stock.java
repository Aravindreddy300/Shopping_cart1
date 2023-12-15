package com.shop.entity;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Validated
public class Stock {
    
    public Stock() {
		super();
	}

	public Stock(@Min(value = 0, message = "Quantity must be greater than or equal to 0") int quantity,
			@NotBlank(message = "Location is required") String location,
			@NotBlank(message = "Supplier is required") String supplier) {
		super();
		this.quantity = quantity;
		this.location = location;
		this.supplier = supplier;
		//this.product = product;
	}
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  

	@Min(value = 0, message = "Quantity must be greater than or equal to 0")
    private int quantity;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Supplier is required")
    private String supplier;

    
//    @OneToOne
  //  private Product product;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	/*public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Stock [quantity=" + quantity + ", location=" + location + ", supplier=" + supplier + ", product="
				+ product + "]";
	}*/
    

}
