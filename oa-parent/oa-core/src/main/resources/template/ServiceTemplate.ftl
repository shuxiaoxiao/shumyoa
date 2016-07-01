package ${bussPackage}.service;

import ${bussPackage}.model.${className};
import com.shupro.oa.core.BaseService;

public interface ${className}Service extends BaseService<${className}, Integer> {
	
	/**
	 * 批量删除
	 * @param ids	多个主键值，用","隔开
	 * @return
	 */
	int deleteById(String ids);
}
