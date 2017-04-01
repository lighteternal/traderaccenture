package traderproject.model;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Customers database table.
 * 
 */
@Entity(name="Customers")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerID;
	private String address;
	private String afm;
	private Date birthday;
	private String city;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	private String email;
	private String firstName;
	private String idCard;
	private String lastName;
	private Integer mobilePhone;
	private String occupation;
	private String password;
	private Integer phone;
	private String sex;
	private String username;

	//bi-directional one-to-one association to Account
	@OneToOne(mappedBy="customer")
	private Account account;

	//bi-directional many-to-one association to Portfolio
	@OneToMany(mappedBy="customer")
	private List<Portfolio> portfolios;

	
	
	//CONSTRUCTORS	
		public Customer(String firstName, String lastName,
				String username,String password) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.password = password;
			this.username = username;
		}
		
		public Customer(){}

	
	//GETTERS AND SETTERS
	public int getCustomerID() {
		return this.customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAfm() {
		return this.afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(int mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Portfolio> getPortfolios() {
		return this.portfolios;
	}
	

	public void setPortfolios(List<Portfolio> portfolios) {
		this.portfolios = portfolios;
	}

	public Portfolio addPortfolio(Portfolio portfolio) {
		getPortfolios().add(portfolio);
		portfolio.setCustomer(this);

		return portfolio;
	}

	public Portfolio removePortfolio(Portfolio portfolio) {
		getPortfolios().remove(portfolio);
		portfolio.setCustomer(null);

		return portfolio;
	}

	@Override
    public String toString() {
        return String.format(
                "Customer id=%d,&emsp; firstName='%s',&emsp; lastName='%s',&emsp; username=%s,&emsp; password=%s<BR>",
               customerID, firstName, lastName, username, password);
	}
	
}