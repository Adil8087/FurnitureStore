package com.OnWeb.demo.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.core.SpringVersion;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer userId;
	@Column(length = 30, name = "first_name")
	private String firstName;
	@Column(length = 30, name = "last_name")
	private String lastName;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private GenderType gender;
	@Column(length = 30, unique = true)
	private String email;
	@Column(length = 100)
	private String password;
	@Column(name = "mobile_no", length = 10)
	private String mobileNo;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private RoleType role;
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Address> address = new ArrayList<>();
	private boolean status;
	@OneToOne
	@JoinColumn(name = "order_id")
	private Order orders;
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Cart> carts = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ProductReview> reviews = new ArrayList<>();
	public void addAdress(Address address2) {
		this.address.add(address2);
		
	}
	public void removeAddress(Address address2) {
		this.address.remove(address2);
		
	}
}