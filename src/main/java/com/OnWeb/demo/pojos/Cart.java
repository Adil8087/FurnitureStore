package com.OnWeb.demo.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Integer cartId;
	@Column(name = "product_id")
	private int productId;
	private String title;
	private int quantity;
	private double price;
	private double amount;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@LazyCollection(LazyCollectionOption.FALSE)
	private User user;
}
