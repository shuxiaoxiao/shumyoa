package com.shupro.oa.admin.model;

import java.io.Serializable;

public class SysDictionary implements Serializable {
	
		private Integer id;//   	private Integer pid;//   父id	private String name;//   文字描述	private String value;//   具体值	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public Integer getPid() {	    return this.pid;	}	public void setPid(Integer pid) {	    this.pid=pid;	}	public String getName() {	    return this.name;	}	public void setName(String name) {	    this.name=name;	}	public String getValue() {	    return this.value;	}	public void setValue(String value) {	    this.value=value;	}
}

