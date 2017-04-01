package traderproject.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Account database table.
 * 
 */
@Entity(name="Account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accountID;

	private double acBalance;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date acDateCreated;

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

	public Date getAcDateCreated() {
		return this.acDateCreated;
	}

	public void setAcDateCreated(Date acDateCreated) {
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

	public Account(double acBalance, Date acDateCreated, int customerID, Customer customer, List<Activity> activities) {
		super();
		this.acBalance = acBalance;
		this.acDateCreated = acDateCreated;
		this.customerID = customerID;
		this.customer = customer;
		this.activities = activities;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", acBalance=" + acBalance + ", acDateCreated=" + acDateCreated
				+ ", customerID=" + customerID + ", customer=" + customer + ", activities=" + activities + "]";
	}
	
	

}