package com.dao;

import com.entity.Collection;
import com.entity.User;

public interface CollectionDao {
	
	void addnew(User user);
	
	/**
	 * 往数据库中插入数据
	 * @param collection 藏品对象
	 */
	void addnew1(Collection collection);
	/**
	 * 查询记录的总条数
	 * @return
	 */
	Integer count();

}
