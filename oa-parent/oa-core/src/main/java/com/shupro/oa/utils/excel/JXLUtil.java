package com.shupro.oa.utils.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * 使用jxl读写excel，只支持读取 03版本(.xls)
 * 
 * @ClassName: JXLUtil
 * @author shuheng
 */
public class JXLUtil {
	
	/**
	 * 读取excel
	 * 原理：一行一行读取内容，保存到List<String[]>中
	 * @param file	需要读取的文件
	 * @throws BiffException
	 * @throws IOException
	 */
	public static List<String[]> readXls03(File file) throws BiffException, IOException {
		// 创建一个list 用来存储读取的内容
		List<String[]> list = new ArrayList<String[]>();
//		if (file!=null) {
//			StringUtils.getCommonPrefix(file.getName());
//		}
		// 创建输入流
		InputStream inStream = new FileInputStream(file);

		// 获取Excel文件对象
		Workbook rwb = Workbook.getWorkbook(inStream);

		// 获取文件的指定工作表 默认的第一个
		Sheet sheet = rwb.getSheet(0);

		// 行数(表头的目录不需要，从1开始)
		for (int i = 0; i < sheet.getRows(); i++) {
			int cols = sheet.getColumns();//列数
			// 创建一个数组 用来存储每一列的值
			String[] str = new String[cols];

			// 列数
			for (int j = 0; j < cols; j++) {
				// 获取第i行，第j列的值
				Cell cell = sheet.getCell(j, i);
				str[j] = cell.getContents();

			}
			// 把刚获取的列存入list
			list.add(str);
		}
		return list;
	}

	/**
	 * 读取excel
	 * 原理：一行一行读取内容，保存到List<String[]>中
	 * @param filePath 需要读取的文件名
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	public static List<String[]> readXls03(String filePath) throws BiffException, IOException {
		File file =new File(filePath);
		return readXls03(file);
	}

	public static void writeXls03(String filePath) {
		String[] title = { "编号", "产品名称", "产品价格", "产品数量", "生产日期", "产地", "是否出口" };
		try {
			// 输出的excel的路径
//			String filePath = "d:\\testJXL.xls";
			
			// 新建立一个jxl文件,即在d盘下生成testJXL.xls
			OutputStream outStream = new FileOutputStream(filePath);
			// 创建Excel工作薄
			WritableWorkbook wwb = Workbook.createWorkbook(outStream);
			// 添加第一个工作表并设置第一个Sheet的名字
			String sheetName="ww2";
			WritableSheet sheet = wwb.createSheet(sheetName, 0);
			
			//作用是指定第i+1行的高度
			sheet.setRowView(0,100*6);//100相当于excel中高度4.95
			//作用是指定第i+1列的宽度
			sheet.setColumnView(0, 10);//10相当于excel中宽度9.3
			
			WritableFont titleFont = new WritableFont(WritableFont.createFont("黑体"),12,WritableFont.BOLD,
					false,UnderlineStyle.NO_UNDERLINE,Colour.LIGHT_BLUE);

			Label label;
			for (int i = 0; i < title.length; i++) {
				// Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
				// 在Label对象的子对象中指明单元格的位置和内容
//				label = new Label(i, 0, title[i]);
				label = new Label(i, 0, title[i], getHeader(titleFont,Colour.YELLOW2));//单元格的背景
				// 将定义好的单元格添加到工作表中
				sheet.addCell(label);
			}
			// 下面是填充数据
			/* jxl.write.Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
			 * 文本：jxl.write.Label label = new jxl.write.Label(1, 1, "金鸽瓜子");
			 * 数字：jxl.write.Number number = new jxl.write.Number(0, 1, 20071001);
			 * 日期：与文本一样
			 * 显示布尔值：jxl.write.Boolean bool = new jxl.write.Boolean(6, 1, true);
			 */
			// 填充产品编号
			jxl.write.Number number = new jxl.write.Number(0, 1, 20071001);
			sheet.addCell(number);
			// 填充产品名称
			label = new Label(1, 1, "金鸽瓜子");
			sheet.addCell(label);
			/*
			 * 定义对于显示金额的公共格式 jxl会自动实现四舍五入 例如 2.456会被格式化为2.46,2.454会被格式化为2.45
			 */
			jxl.write.NumberFormat nf = new jxl.write.NumberFormat("#,###.00");
			jxl.write.WritableCellFormat wcf = new jxl.write.WritableCellFormat(nf);
			// 填充产品价格
			jxl.write.Number nb = new jxl.write.Number(2, 1, 200000.45, wcf);
			sheet.addCell(nb);
			// 填充产品数量
			jxl.write.Number numb = new jxl.write.Number(3, 1, 200);
			sheet.addCell(numb);
			/*
			 * 定义显示日期的公共格式 如:yyyy-MM-dd hh:mm
			 */
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String newdate = sdf.format(new Date());
			// 填充出产日期
			label = new Label(4, 1, newdate);
			sheet.addCell(label);
			// 填充产地
			label = new Label(5, 1, "陕西西安");
			sheet.addCell(label);
			//显示布尔值
			jxl.write.Boolean bool = new jxl.write.Boolean(6, 1, true);
			sheet.addCell(bool);
			/*
			 * 合并单元格 通过writablesheet.mergeCells(int x,int y,int m,int n);来实现的
			 * 表示将从第x+1列，y+1行到m+1列，n+1行合并
			 */
			sheet.mergeCells(0, 3, 2, 3);
			label = new Label(0, 3, "合并了三个单元格");
			sheet.addCell(label);
			/*
			 * 定义公共字体格式 通过获取一个字体的样式来作为模板 首先通过web.getSheet(0)获得第一个sheet
			 * 然后取得第一个sheet的第二列，第一行也就是"产品名称"的字体
			 */
//			CellFormat cf = wwb.getSheet(0).getCell(1, 0).getCellFormat();
			WritableCellFormat wc = new WritableCellFormat();
			// 设置居中
			wc.setAlignment(Alignment.CENTRE);
			// 设置边框线
			wc.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 设置单元格的背景颜色
			wc.setBackground(jxl.format.Colour.RED);
			label = new Label(1, 5, "字体", wc);
			sheet.addCell(label);
			
//			label = new Label(2, 6, "隶书", fontFormat);
//			sheet.addCell(label);
			
			// 写入数据
			wwb.write();
			// 关闭文件
			wwb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 标题栏样式
	 * @param fontcolor 字体颜色
	 * @param bgcolor 单元格背景色
	 * @return
	 */
	public static WritableCellFormat getHeader(WritableFont font,Colour bgcolor) {
//		WritableFont font = new WritableFont(WritableFont.TIMES, 10,WritableFont.BOLD);// 定义字体
		WritableCellFormat format=null;
		try {
//			font.setColour(fontcolor);// 字体颜色
			format = new WritableCellFormat(font);
			format.setAlignment(jxl.format.Alignment.CENTRE);// 左右居中
			format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);// 上下居中
			format.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);// 黑色边框
			format.setBackground(bgcolor);// 背景
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return format;
	}
	
//=====往sheet中插入不同数据=====//
	public void addNumber(WritableSheet sheet,int col,int row,double num) throws Exception {
		jxl.write.Number number =new jxl.write.Number(col,row,num);
		sheet.addCell(number);
	}
	
	public void addText() {
		
	}
	
	
}
