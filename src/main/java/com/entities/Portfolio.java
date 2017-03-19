package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Portfolio database table.
 * 
 */
@Entity
@NamedQuery(name="Portfolio.findAll", query="SELECT p FROM Portfolio p")
public class Portfolio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int pStockID;

	private int pStockAmount;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customerID")
	private Customer customer;

	public Portfolio() {
	}

	public int getPStockID() {
		return this.pStockID;
	}

	public void setPStockID(int pStockID) {
		this.pStockID = pStockID;
	}

	public int getPStockAmount() {
		return this.pStockAmount;
	}

	public void setPStockAmount(int pStockAmount) {
		this.pStockAmount = pStockAmount;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}