package com.shupro.oa.core;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

/**
 * 公共接口
 * 
 * @author shuheng
 */
public interface GenericDao<T> {

	/**
	 * 插入一个实体对象
	 * @param entity 实体对象
	 * @return 如果插入成功返回1，否则，返回0
	 */
	@Insert("MapperGD.insert")
	@SelectKey(keyProperty="id", before = false, resultType = Integer.class, statement = { "SELECT @@IDENTITY" })
	@Options(useGeneratedKeys=true, keyProperty = "id")
	public int insert(T entity);
	
	/**
	 * 删除一个实体对象
	 * @param entity 实体对象
	 * @return 如果删除成功返回1，否则，返回0
	 */
	@Delete("MapperGD.delete")
	public int delete(T entity);
	
	/**
	 * 修改一个实体对象
	 * @param entity 实体对象
	 * @return 如果修改成功返回1，否则，返回0
	 */
	@Update("MapperGD.update")
	public int update(T entity);
		
}
