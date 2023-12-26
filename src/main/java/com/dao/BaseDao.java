package com.dao;

import java.util.List;

public interface BaseDao<E> {
	public boolean add(E e);
	public void delete(E e);
	public void upadate(E e);
	public boolean findbone(String username , String password);
	public List<E> findall();
	
}
