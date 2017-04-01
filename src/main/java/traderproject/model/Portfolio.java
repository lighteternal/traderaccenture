package traderproject.model;

import java.io.Serializable;
import javax.persistence.*;



@Entity(name="Portfolio")
public class Portfolio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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

	public Portfolio(int pStockID, int pStockAmount, Customer customer) {
		super();
		this.pStockID = pStockID;
		this.pStockAmount = pStockAmount;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Portfolio [pStockID=" + pStockID + ", pStockAmount=" + pStockAmount + ", customer=" + customer + "]";
	}

}