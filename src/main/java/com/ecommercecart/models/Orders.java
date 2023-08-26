package com.ecommercecart.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.WhereJoinTable;

import lombok.Data;

@Entity
@Table(name="orders")
@Data
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@CreationTimestamp
	private Date createdTime;
	
	@OneToOne
	@JoinColumn(name = "cartId", referencedColumnName = "cartId")
    private Cart cart;
    
    @OneToOne
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    @WhereJoinTable( clause = "enabled = 'TRUE' ")
    private Address address;
}
