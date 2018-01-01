package cn.sdut.po;

public class Record {
	private int id;
	private String style;
	private float change;
	private String date;
	private String account_id;

	public Record(int id, String style, float change, String date, String account_id) {
		super();
		this.id = id;
		this.style = style;
		this.change = change;
		this.date = date;
		this.account_id = account_id;
	}

	public Record() {
		super();
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "record [id=" + id + ", style=" + style + ", change=" + change + ", date=" + date + ", account_id="
				+ account_id + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public float getChange() {
		return change;
	}

	public void setChange(float change) {
		this.change = change;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

}
