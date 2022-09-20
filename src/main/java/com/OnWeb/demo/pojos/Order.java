package com.OnWeb.demo.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer orderId;
	@OneToOne(mappedBy = "orders", cascade = CascadeType.ALL)
	private User user;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_id", nullable = false)
	private Payment payment;
	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	private int quantity;
	private double amount;
	@Column(name = "o_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate orederDate;
}
