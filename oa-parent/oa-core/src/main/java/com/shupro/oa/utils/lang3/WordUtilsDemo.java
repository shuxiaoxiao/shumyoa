package com.shupro.oa.utils.lang3;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

/**
 * apache.commons.lang3.text包中的WordUtils类 
 * 单词处理功能
 * @author Administrator
 * 
 */
public class WordUtilsDemo {

	/**首字母大写*/
	public void capitalize() {
		String str1 = "wOrD";
		System.out.println(WordUtils.capitalize(str1)); // 首字母大写 WOrD
		System.out.println(WordUtils.capitalizeFully(str1)); // 首字母大写其它字母小写 Word

		char[] ctrg = { '_' };// 在规则地方转换 
		String str = WordUtils.capitalizeFully("hEllo_woRld", ctrg);
		//方式一：
		System.out.println(str.replace("_", ""));
		//方式二：
		System.out.println(StringUtils.replace(str,"_", ""));
		
//		System.out.println(WordUtils.capitalizeFully("hEllo_woRld", ctrg)); //Hello_World
	}
	
	/**获取首字母*/
	public void initials() {
		String str1 = "wOrD";
		System.out.println(WordUtils.initials(str1)); // 获取首字母 w
		
		System.out.println(WordUtils.initials("Ben John Lee", null)); // 取每个单词的首字母 BJL
		char[] ctr2 = { ' '};
		System.out.println(WordUtils.initials("Ben J.Lee", ctr2)); // 按指定规则获取首字母 BJ
		
		char[] ctr = { ' ', '.' };
		System.out.println(WordUtils.initials("Ben J.Lee", ctr)); // 按指定规则获取首字母 BJL
	}
	
	/**其他功能*/
	public void other() {
		String str1 = "wOrD";
		System.out.println(WordUtils.swapCase(str1)); // 大小写逆转 WoRd
		
		String str2 = "ghj\nui\tpo";
		System.out.println(WordUtils.wrap(str2, 1)); // 解析\n和\t等字符
		
	}
	
}
