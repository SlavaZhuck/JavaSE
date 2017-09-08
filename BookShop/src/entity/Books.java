package entity;

public class Books {

	private int id_book;
	private String author;
	private String name;
	private int price;
	private int del_status;

	public Books(int id_book, String author, String name, int price, int del_status) {
		this.id_book = id_book;
		this.author = author;
		this.name = name;
		this.price = price;
		this.del_status = del_status;
	}

	public Books(String author, String name, int price, int del_status) {
		this.author = author;
		this.name = name;
		this.price = price;
		this.del_status = del_status;
	}

	@Override
	public String toString() {
		return "Books [id_book=" + id_book + ", author=" + author + ", name=" + name + ", price=" + price
				+ ", del_status=" + del_status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + del_status;
		result = prime * result + id_book;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
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
		Books other = (Books) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (del_status != other.del_status)
			return false;
		if (id_book != other.id_book)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	public int getId_book() {
		return id_book;
	}

	public void setId_book(int id_book) {
		this.id_book = id_book;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDel_status() {
		return del_status;
	}

	public void setDel_status(int del_status) {
		this.del_status = del_status;
	}

	public Books() {

	}

}
