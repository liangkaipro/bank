package cn.sdut.po;

public class Account {
	private int id;
	private String name;
	private float money;
	private String accountID;
	private String password;
	private String date;
	public Account() {
		super();
	}
	
	public Account(int id, String name, float money, String accountID, String password, String date) {
		super();
		this.id = id;
		this.name = name;
		this.money = money;
		this.accountID = accountID;
		this.password = password;
		this.date = date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	
	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", money=" + money + ", accountID=" + accountID + ", password="
				+ password + ", date=" + date + "]";
	}
	
}
