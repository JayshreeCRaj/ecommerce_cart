package com.ecommercecart.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "address")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	
	private String street;
	private String city;
	private String country;
	private String postcode;
	
	private boolean enabled;
	
	@ManyToOne
	@JoinColumn(name="customerId",referencedColumnName = "customerId")
	private Customer customer;

}
