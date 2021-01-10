package dao;

import java.util.List;


public interface ICrudRepository<T> {
	
	List<T> query();
	T getById(int id);
	T create(T o);
	boolean update(T o);
	boolean delete(int id);

}
