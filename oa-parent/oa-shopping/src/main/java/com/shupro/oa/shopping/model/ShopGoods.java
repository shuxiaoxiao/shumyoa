package com.shupro.oa.shopping.model;

import java.io.Serializable;

public class ShopGoods implements Serializable {
	
	private Integer id;//   	private String name;//   商品名称	private Integer quantity;//   数量	private java.util.Date createtime;//   创建日期	private java.math.BigDecimal origprice;//   原价	private String discount;//   折扣	private java.math.BigDecimal price;//   售价	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public String getName() {	    return this.name;	}	public void setName(String name) {	    this.name=name;	}	public Integer getQuantity() {	    return this.quantity;	}	public void setQuantity(Integer quantity) {	    this.quantity=quantity;	}	public java.util.Date getCreatetime() {	    return this.createtime;	}	public void setCreatetime(java.util.Date createtime) {	    this.createtime=createtime;	}	public java.math.BigDecimal getOrigprice() {	    return this.origprice;	}	public void setOrigprice(java.math.BigDecimal origprice) {	    this.origprice=origprice;	}	public String getDiscount() {	    return this.discount;	}	public void setDiscount(String discount) {	    this.discount=discount;	}	public java.math.BigDecimal getPrice() {	    return this.price;	}	public void setPrice(java.math.BigDecimal price) {	    this.price=price;	}
}

