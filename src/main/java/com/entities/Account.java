package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int accountID;

	private double acBalance;

	private Timestamp acDateCreated;

	private int customerID;

	//bi-directional one-to-one association to Customer
	@OneToOne
	@JoinColumn(name="accountID")
	private Customer customer;

	//bi-directional many-to-one association to Activity
	@OneToMany(mappedBy="account")
	private List<Activity> activities;

	public Account() {
	}

	public int getAccountID() {
		return this.accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public double getAcBalance() {
		return this.acBalance;
	}

	public void setAcBalance(double acBalance) {
		this.acBalance = acBalance;
	}

	public Timestamp getAcDateCreated() {
		return this.acDateCreated;
	}

	public void setAcDateCreated(Timestamp acDateCreated) {
		this.acDateCreated = acDateCreated;
	}

	public int getCustomerID() {
		return this.customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public Activity addActivity(Activity activity) {
		getActivities().add(activity);
		activity.setAccount(this);

		return activity;
	}

	public Activity removeActivity(Activity activity) {
		getActivities().remove(activity);
		activity.setAccount(null);

		return activity;
	}

}