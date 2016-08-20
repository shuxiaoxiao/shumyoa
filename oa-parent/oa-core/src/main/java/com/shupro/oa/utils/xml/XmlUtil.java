package com.shupro.oa.utils.xml;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



/**
 * 使用的jar包有 dom4j-1.6.1.jar
 * @ClassName: XmlUtil
 * @author	shuheng
 * @date 2015-8-8
 */
public class XmlUtil {

	public static List getChild(String filePath) throws Exception {
		//获得解析流
		SAXReader reader = new SAXReader();
		//xml文件的解析
		Document document = reader.read(filePath);
		//获得根元素
		Element root = document.getRootElement();
		//获得子节点
		List childList = root.elements();
		return childList;
	}
	
	
//	public static void read(List list) throws Exception {
//		getChild("download/books.xml");
//	}
	
	/**读取xml
	 * @throws DocumentException */
//	public static void read(String filePath) throws DocumentException {
////		getChild("download/books.xml");
//		//需要List 存放所有的book对象
//		List allBook = new ArrayList();
//		
//		//获得解析流
//		SAXReader reader = new SAXReader();
//		//xml文件的解析
//		Document document = reader.read(filePath);
//		//获得根元素
//		Element root = document.getRootElement();
//		System.out.println("根节点："+ root.getName());
//		//获得所有的书籍
//		List list = root.elements();
//		//遍历所有的书籍 -- list
//		for(int i = 0 ; i < list.size() ; i ++){
//			//创建book对象
//			Book book = new Book();
//			//获得每一本book元素
//			Element bookElement = (Element)list.get(i);
//			//获得书籍的id属性值
//			String id = bookElement.attributeValue("id");
//			//System.out.println(id);
//			book.setId(id);
//			
//			//获得title和price
//			List childList = bookElement.elements();
//			//遍历子元素
//			for(int c = 0 ; c < childList.size() ; c ++){
//				//获得每一个子元素
//				Element child = (Element) childList.get(c);
////				System.out.println(child);
//				//获得子元素文本内容
//				String content = child.getText();
//				//判断是否是title
//				if("title".equals(child.getName())){
//					book.setTitle(content);
//				}
//				//判断是否是price
//				if("price".equals(child.getName())){
//					book.setPrice(content);
//				}
//				
//				
//			}
//			
//			//将已经封装了内容的book对象，添加到list中
//			allBook.add(book);
//		}
//		
//		
//		//程序解析前，输出内容
//		System.out.println(allBook);
//		
//	}
}
