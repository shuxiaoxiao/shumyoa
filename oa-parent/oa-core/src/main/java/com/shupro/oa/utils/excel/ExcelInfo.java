package com.shupro.oa.utils.excel;

import java.util.List;
import java.util.Map;

/**
 * excel操作的pojo<br>
 * titles的顺序和fields顺序保持一致
 * @author shu
 *
 */
public class ExcelInfo {
	private String sheetName;
	private String[] titles;
	private String[] fields;
	private List<Map<String, Object>> list;

	public ExcelInfo(String sheetName, String[] titles, String[] fields, List<Map<String, Object>> list) {
		this.sheetName = sheetName;
		this.titles = titles;
		this.fields = fields;
		this.list = list;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String[] getTitles() {
		return titles;
	}

	public void setTitles(String[] titles) {
		this.titles = titles;
	}

	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
	}

	public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}

}
