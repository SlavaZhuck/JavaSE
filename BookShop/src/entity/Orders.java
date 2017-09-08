package entity;

public class Orders {

	private int id_order;
	private int order_number;
	private int id_user;
	private int id_book;
	private int order_status;

	public Orders(int id_order, int order_number, int id_user, int id_book, int order_status) {
		this.id_order = id_order;
		this.order_number = order_number;
		this.id_user = id_user;
		this.id_book = id_book;
		this.order_status = order_status;
	}

	public Orders(int order_number, int id_user, int id_book) {
		this.order_number = order_number;
		this.id_user = id_user;
		this.id_book = id_book;
		this.order_status = 0;
	}

	public Orders() {

	}

	@Override
	public String toString() {
		return "Orders [id_order=" + id_order + ", order_number=" + order_number + ", id_user=" + id_user + ", id_book="
				+ id_book + ", order_status=" + order_status + "]";
	}

	public int getId_order() {
		return id_order;
	}

	public void setId_order(int id_order) {
		this.id_order = id_order;
	}

	public int getOrder_number() {
		return order_number;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_book() {
		return id_book;
	}

	public void setId_book(int id_book) {
		this.id_book = id_book;
	}

	public int getOrder_status() {
		return order_status;
	}

	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_book;
		result = prime * result + id_order;
		result = prime * result + id_user;
		result = prime * result + order_number;
		result = prime * result + order_status;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (id_book != other.id_book)
			return false;
		if (id_order != other.id_order)
			return false;
		if (id_user != other.id_user)
			return false;
		if (order_number != other.order_number)
			return false;
		if (order_status != other.order_status)
			return false;
		return true;
	}
}
