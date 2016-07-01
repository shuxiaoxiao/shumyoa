package com.shupro.oa.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TreeDto
 * @Description: 封装 树型结构
 * @author shuheng
 * @date 2014-11-28
 */
public class TreeNode {

	/** 节点ID，对加载远程数据很重要 */
	private String id;
	/** 显示节点文本 */
	private String text;
	/** 节点图标 */
	private String iconCls;
	/** 表示该节点是否被选中 */
	private boolean checked;
	/** 节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。 */
	private String state;
	/** 节点父ID */
	private String pid;
	/** 被添加到节点的自定义属性 */
	private Map<String, Object> attributes = new HashMap<String, Object>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
