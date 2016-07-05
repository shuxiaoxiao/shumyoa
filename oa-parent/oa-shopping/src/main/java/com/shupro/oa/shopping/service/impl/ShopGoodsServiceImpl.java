package com.shupro.oa.shopping.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shupro.oa.shopping.dao.ShopGoodsMapper;
import com.shupro.oa.shopping.model.ShopGoods;
import com.shupro.oa.shopping.service.ShopGoodsService;
import com.shupro.oa.core.AbstractService;
import com.shupro.oa.core.BaseMapper;
import com.shupro.oa.utils.page.PageBean;

@Service
public class ShopGoodsServiceImpl extends AbstractService<ShopGoods, Integer> implements ShopGoodsService {
	
	@Autowired
	private ShopGoodsMapper shopGoodsMapper;
	
	/**具体子类service的实现需要使用的mapper*/
	@Override
	@Autowired
	public void setBaseMapper(BaseMapper<ShopGoods, Integer> baseMapper) {
		super.setBaseMapper(baseMapper);
	}

	@Override
	public PageBean<ShopGoods> select2PageBean(Map<String, Object> map) {
		PageBean<ShopGoods> pageBean = new PageBean<>();
		pageBean.setPageNo(Integer.parseInt(map.get("pageNo").toString()));
		pageBean.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		//注意map要先设置pageBean,拦截器里面要获取其值
		map.put("pageBean", pageBean);
		pageBean.setRows(shopGoodsMapper.selectAll4Page(map));
		map.put("needPage", true);//是否分页，默认是false不分页
		return pageBean;
	}
	
	@Override
	@Transactional
	public int deleteById(String ids) {
		String[] idsStr = ids.split(",");
		if (idsStr.length > 0) {
			for (String id : idsStr) {
				shopGoodsMapper.deleteById(Integer.parseInt(id));
			}
			return 1;
		} else {
			return 0;
		}
	}
}
