package com.shop.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "order1")
public class Order {

	public Order() {
		super();
	}

	public Order(Long oId, Double oCost, LocalDate oDate, Cart cart) {
		super();
		this.oId = oId;
		this.oCost = oCost;
		this.oDate = oDate;
		this.cart = cart;
	}

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long oId;

	private Double oCost;

	private LocalDate oDate;

	private boolean orderStatus;

	@OneToOne
	private Cart cart;

	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}

	public Double getoCost() {
		return oCost;
	}

	public void setoCost(Double oCost) {
		this.oCost = oCost;
	}

	public LocalDate getoDate() {
		return oDate;
	}

	public void setoDate(LocalDate oDate) {
		this.oDate = oDate;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public boolean isOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [oId=" + oId + ", oCost=" + oCost + ", oDate=" + oDate + ", orderStatus=" + orderStatus
				+ ", cart=" + cart + "]";
	}

}
