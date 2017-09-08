package dao;

public interface DaoInterface<T> {

	public abstract void insert(T ob);

	public abstract void delete(int id);

	public abstract int update(T ob);

	public abstract T get(int id);

}
