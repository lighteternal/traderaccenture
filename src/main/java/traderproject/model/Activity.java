package traderproject.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the Activity database table.
 * 
 */
@Entity(name="Activity")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int txID;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	private int stockAmount;

	private int stockID;

	private double stockPrice;

	private byte type;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="accountID")
	private Account account;

	public Activity() {
	}

	public int getTxID() {
		return this.txID;
	}

	public void setTxID(int txID) {
		this.txID = txID;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getStockAmount() {
		return this.stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}

	public int getStockID() {
		return this.stockID;
	}

	public void setStockID(int stockID) {
		this.stockID = stockID;
	}

	public double getStockPrice() {
		return this.stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public byte getType() {
		return this.type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Activity(int txID, Date creationDate, int stockAmount, int stockID, double stockPrice, byte type,
			Account account) {
		super();
		this.txID = txID;
		this.creationDate = creationDate;
		this.stockAmount = stockAmount;
		this.stockID = stockID;
		this.stockPrice = stockPrice;
		this.type = type;
		this.account = account;
	}

	@Override
	public String toString() {
		return "Activity [txID=" + txID + ", creationDate=" + creationDate + ", stockAmount=" + stockAmount
				+ ", stockID=" + stockID + ", stockPrice=" + stockPrice + ", type=" + type + ", account=" + account
				+ "]";
	}

}