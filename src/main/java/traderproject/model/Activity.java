package traderproject.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the Activity database table.
 * 
 */
@Entity(name="Activity")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "txID")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="txID")
	private int txID;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="creationDate")
	private Date creationDate;
	@Column(name="stockAmount")
	private int stockAmount;
	@Column(name="stockID")
	private int stockID;
	@Column(name="stockPrice")
	private double stockPrice;
	@Column(name="type")
	private byte type;

	//bi-directional many-to-one association to Account
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="accountID", nullable=true)
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

	public Activity(Date creationDate, int stockAmount, int stockID, double stockPrice, byte type,
			Account account) {
		
		
		this.creationDate = creationDate;
		this.stockAmount = stockAmount;
		this.stockID = stockID;
		this.stockPrice = stockPrice;
		this.type = type;
		this.account = account;
	}

	/*@Override
	public String toString() {
		return "Activity [txID=" + txID + ", creationDate=" + creationDate + ", stockAmount=" + stockAmount
				+ ", stockID=" + stockID + ", stockPrice=" + stockPrice + ", type=" + type + ", account=" + account
				+ "]";
	}*/

}