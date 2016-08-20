package com.shupro.oa.utils.jsoup;

import java.util.List;

import org.junit.Test;

public class JsoupTest {

	@Test
	public void getDatasByClass() {
		Rule rule = new Rule("http://www1.sxcredit.gov.cn/public/infocomquery.do?method=publicIndexQuery",
				new String[] { "query.enterprisename", "query.registationnumber" }, new String[] { "兴网", "" },
				"cont_right", Rule.CLASS, Rule.POST);
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		System.out.println(extracts);
		printf(extracts);
	}

	@Test
	public void getDatasByCssQuery() {
		// http://www.11315.com/newSearch?regionMc=%E9%80%89%E6%8B%A9%E5%9C%B0%E5%8C%BA&regionDm=&searchType=&searchTypeHead=0&name=%E5%85%B4%E7%BD%91
		Rule rule = new Rule("http://www.11315.com/newSearch", new String[] { "name" }, new String[] { "兴网" },
				"div.g-mn div.con-model", Rule.SELECTION, Rule.GET);
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		printf(extracts);
	}

	@Test
	public void getDatasByCssQueryUserBaidu() {
		Rule rule = new Rule("http://news.baidu.com/ns", new String[] { "wd" }, new String[] { "云平台建设方案" }, null, -1,
				Rule.GET);
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		printf(extracts);
	}

	public void printf(List<LinkTypeData> datas) {
		for (LinkTypeData data : datas) {
			System.out.println(data);
			// System.out.println(data.getLinkText());
			// System.out.println(data.getLinkHref());
			System.out.println("***********************************");
		}

	}
}