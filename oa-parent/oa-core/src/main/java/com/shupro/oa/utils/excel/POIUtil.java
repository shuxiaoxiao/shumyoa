package com.shupro.oa.utils.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @ClassName: POIUtil
 * @author shuheng
 */
public class POIUtil {
//http://blog.csdn.net/huazhangena/article/details/7587731 详情页面
	/**
	 * 读取excel 原理：一行一行读取内容，保存到List<String[]>中
	 * 
	 * @param filePath
	 *            需要读取的文件名
	 * @return
	 * @throws IOException
	 */
	public static List<String[]> read(String filePath) throws IOException {
		// 前缀prefix，后缀suffix
		String suffix = filePath.substring(filePath.lastIndexOf(".") + 1);
		if ("xls".equals(suffix)) {
			return readXls03(filePath);
		} else if ("xlsx".equals(suffix)) {
			return readXlsx07(filePath);
		}else {
			return null;
		}
	}

	/**
	 * 读取excel 原理：一行一行读取内容，保存到List<String[]>中
	 * 
	 * @param file
	 *            需要读取的文件
	 * @return
	 * @throws IOException
	 */
	public static List<String[]> readXls03(File file) throws IOException {
		// 创建一个list 用来存储读取的内容
		List<String[]> list = new ArrayList<String[]>();
		// 创建输入流
		InputStream inStream = new FileInputStream(file);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inStream);

		// 默认读取第一个sheet
		HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
		// int sheetTotal = hssfWorkbook.getNumberOfSheets();
		// for (int numSheet = 0; numSheet < sheetTotal; numSheet++) {
		// HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
		// if (hssfSheet == null) {
		// continue;
		// }
		// }
		int rownum = sheet.getLastRowNum();// 总行数
		// Read the Row
		for (int i = 0; i < rownum; i++) {
			HSSFRow hssfRow = sheet.getRow(i);
			int colnum = hssfRow.getLastCellNum();// 总列数
			String[] str = new String[colnum];
			if (hssfRow != null) {
				for (int j = 0; j < colnum; j++) {
					HSSFCell cell = hssfRow.getCell(j);
					str[j] = getValue(cell);
				}
				list.add(str);
			}
		}

		return list;
	}

	/**
	 * 读取excel 原理：一行一行读取内容，保存到List<String[]>中
	 * 
	 * @param filePath
	 *            需要读取的文件名
	 * @return
	 * @throws IOException
	 */
	public static List<String[]> readXls03(String filePath) throws IOException {
		File file = new File(filePath);
		return readXls03(file);
	}

	/**
	 * 读取excel 原理：一行一行读取内容，保存到List<String[]>中
	 * 
	 * @param file
	 *            需要读取的文件
	 * @return
	 * @throws IOException
	 */
	public static List<String[]> readXlsx07(File file) throws IOException {
		// 创建一个list 用来存储读取的内容
		List<String[]> list = new ArrayList<String[]>();
		// 创建输入流
		InputStream inStream = new FileInputStream(file);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inStream);

		// 默认读取第一个sheet
		XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
		// int sheetTotal = xssfWorkbook.getNumberOfSheets();
		// for (int numSheet = 0; numSheet < sheetTotal; numSheet++) {
		// HSSFSheet hssfSheet = xssfWorkbook.getSheetAt(numSheet);
		// if (hssfSheet == null) {
		// continue;
		// }
		// }
		int rownum = sheet.getLastRowNum();// 总行数
		// Read the Row
		for (int i = 0; i < rownum; i++) {
			XSSFRow xssfRow = sheet.getRow(i);
			int colnum = xssfRow.getLastCellNum();// 总列数
			String[] str = new String[colnum];
			if (xssfRow != null) {
				for (int j = 0; j < colnum; j++) {
					XSSFCell cell = xssfRow.getCell(j);
					str[j] = getValue(cell);
				}
				list.add(str);
			}
		}

		return list;
	}

	/**
	 * 读取excel 原理：一行一行读取内容，保存到List<String[]>中
	 * 
	 * @param filePath
	 *            需要读取的文件名
	 * @return
	 * @throws IOException
	 */
	public static List<String[]> readXlsx07(String filePath) throws IOException {
		File file = new File(filePath);
		return readXlsx07(file);
	}

	/**
	 * 获取单元格内容（xls03）
	 * 
	 * @param hssfCell
	 * @return
	 */
	private static String getValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}

	/**
	 * 获取单元格内容（xlsx07）
	 * 
	 * @param xssfRow
	 * @return
	 */
	private static String getValue(XSSFCell xssfRow) {
		if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
			return String.valueOf(xssfRow.getBooleanCellValue());
		} else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
			return String.valueOf(xssfRow.getNumericCellValue());
		} else {
			return String.valueOf(xssfRow.getStringCellValue());
		}
	}

	public void name(HSSFWorkbook workbook) {
		// 产生Excel表头
		HSSFSheet sheet = workbook.createSheet("治安信息资源共享申请表");
		// 设置excel每列宽度,参考 ："2012-08-10"的宽度为2500
		sheet.setColumnWidth(0, 2500 * 2);
		sheet.setColumnWidth(1, 2500 * 6);

		// 合并第一行第1列 到 第一行第2列(firstRow,lastRow,firstCol,lastCol)
		sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 0, (short) 1));
		// 合并第二行第1列 到 第二行第2列
		sheet.addMergedRegion(new CellRangeAddress(1, (short) 1, 0, (short) 1));

		// 创建单元格样式
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		// 文字水平居中
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 文字垂直居中
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// cellStyle.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		// 设置自动换行
		cellStyle.setWrapText(true);

		// 设置边框
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框

		HSSFRow header1 = sheet.createRow(0); // 第1行
		// header1.createCell((short) 0).setCellValue(applyRes.getTitle());
		header1.setHeight((short) 800);// 设定行的高度

		HSSFRow header2 = sheet.createRow(1); // 第2行
		header2.setHeight((short) 500);// 设定行的高度
		// header2.createCell((short) 0).setCellValue("申请时间：\t"+
		// applyRes.getApplyDate()+"\t\t");

		HSSFRow header3 = sheet.createRow(2); // 第3行
		header3.createCell((short) 0).setCellValue("申请部门");
		// header3.createCell((short) 1).setCellValue(applyRes.getDeptname());
		header3.setHeight((short) 500);// 设定行的高度

		HSSFRow header4 = sheet.createRow(3); // 第4行
		header4.createCell((short) 0).setCellValue("申请人姓名");
		// header4.createCell((short) 1).setCellValue(applyRes.getUsername());
		header4.setHeight((short) 500);// 设定行的高度

		HSSFRow header5 = sheet.createRow(4); // 第5行
		header5.createCell((short) 0).setCellValue("身份证号码");
		// header5.createCell((short) 1).setCellValue(applyRes.getAccount());
		header5.setHeight((short) 500);// 设定行的高度

	}

	/**
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	public static void writeXls03(String filePath) throws IOException {
		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("成绩表");
		// 设置缺省列宽8.5,行高为设置的30
		sheet.setDefaultRowHeightInPoints(30);
		
		// 设置指定列的列宽，256 * 50这种写法是因为width参数单位是单个字符的256分之一
		sheet.setColumnWidth(0, 256 * 15);// 设置第一列的宽度为15
		sheet.setColumnWidth(1, 256 * 10);// 设置第一列的宽度为10
		
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));

		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
//		row1.setHeightInPoints(50);// 设定行的高度,会使设置的默认行高失效（其他行受到了影响，其他行也设置该属性)
		
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue("学员考试成绩一览表");

		// 在sheet里创建第二行
		HSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		row2.createCell(0).setCellValue("姓名");
		row2.createCell(1).setCellValue("班级");
		row2.createCell(2).setCellValue("笔试成绩");
		row2.createCell(3).setCellValue("机试成绩");
		
		row2.setRowStyle(setCellStyle(wb));
		
		// 在sheet里创建第三行
		HSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("李明");
		row3.createCell(1).setCellValue("As178");
		row3.createCell(2).setCellValue(87);
		row3.createCell(3).setCellValue(78);

		// 输出Excel文件
		// OutputStream output=response.getOutputStream();
		// response.reset();
		// response.setHeader("Content-disposition",
		// "attachment; filename=details.xls");
		// response.setContentType("application/msexcel");
		OutputStream outStream = new FileOutputStream(filePath);
		wb.write(outStream);
		outStream.close();

	}
	
	/**
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	public static void writeXlsx07(String filePath) throws IOException {
		// 创建HSSFWorkbook对象(excel的文档对象)
		XSSFWorkbook wb = new XSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		XSSFSheet sheet = wb.createSheet("成绩表07");
		// 设置缺省列宽8.5,行高为设置的30
		sheet.setDefaultRowHeightInPoints(30);

		// 设置指定列的列宽，256 * 50这种写法是因为width参数单位是单个字符的256分之一
		sheet.setColumnWidth(0, 256 * 15);// 设置第一列的宽度为15
		sheet.setColumnWidth(1, 256 * 10);// 设置第一列的宽度为10

		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));

		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		XSSFRow row1 = sheet.createRow(0);
		// row1.setHeightInPoints(50);// 设定行的高度,会使设置的默认行高失效（其他行受到了影响，其他行也设置该属性)

		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		XSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue("学员考试成绩一览表");

		// 在sheet里创建第二行
		XSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		row2.createCell(0).setCellValue("姓名");
		row2.createCell(1).setCellValue("班级");
		row2.createCell(2).setCellValue("笔试成绩");
		row2.createCell(3).setCellValue("机试成绩");

		// row2.setRowStyle(setCellStyle(wb));

		// 在sheet里创建第三行
		XSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("李明");
		row3.createCell(1).setCellValue("As178");
		row3.createCell(2).setCellValue(87);
		row3.createCell(3).setCellValue(78);

		// 输出Excel文件
		// OutputStream output=response.getOutputStream();
		// response.reset();
		// response.setHeader("Content-disposition",
		// "attachment; filename=details.xls");
		// response.setContentType("application/msexcel");
		OutputStream outStream = new FileOutputStream(filePath);
		wb.write(outStream);
		outStream.close();

	}

	public static HSSFCellStyle setCellStyle(HSSFWorkbook wb) {
//		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建单元格样式
		HSSFCellStyle cellStyle = wb.createCellStyle();
		// 文字水平居中
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 文字垂直居中
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 设置自动换行
		cellStyle.setWrapText(true);

		/*
		 * 设置单元格的填充方式，以及前景颜色和背景颜色 
		 * 1.如果需要前景颜色或背景颜色，一定要指定填充方式，两者顺序无所谓;
		 * 2.如果同时存在前景颜色和背景颜色，前景颜色的设置要写在前面;
		 * 3.前景颜色不是字体颜色。
		 */
		// 设置填充方式(填充图案)
		cellStyle.setFillPattern(HSSFCellStyle.DIAMONDS);
		// 设置前景色
		cellStyle.setFillForegroundColor(HSSFColor.RED.index);
		// 设置背景颜色
		cellStyle.setFillBackgroundColor(HSSFColor.LIGHT_YELLOW.index);

		// 设置边框
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
		cellStyle.setBottomBorderColor(HSSFColor.DARK_RED.index);// 下边框颜色
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		return cellStyle;
	}
//	
//	public static XSSFCellStyle setCellStyle(XSSFWorkbook wb ) {
////		HSSFWorkbook wb = new HSSFWorkbook();
//		// 创建单元格样式
//		XSSFCellStyle cellStyle = wb.createCellStyle();
//		// 文字水平居中
//		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
//		// 文字垂直居中
//		cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
//		// 设置自动换行
//		cellStyle.setWrapText(true);
//		
//		/*
//		 * 设置单元格的填充方式，以及前景颜色和背景颜色 
//		 * 1.如果需要前景颜色或背景颜色，一定要指定填充方式，两者顺序无所谓;
//		 * 2.如果同时存在前景颜色和背景颜色，前景颜色的设置要写在前面;
//		 * 3.前景颜色不是字体颜色。
//		 */
//		// 设置填充方式(填充图案)
//		cellStyle.setFillPattern(XSSFCellStyle.DIAMONDS);
//		// 设置前景色
//		cellStyle.setFillForegroundColor(HSSFColor.RED.index);
//		// 设置背景颜色
//		cellStyle.setFillBackgroundColor(HSSFColor.LIGHT_YELLOW.index);
//		
//		// 设置边框
//		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
//		cellStyle.setBottomBorderColor(HSSFColor.DARK_RED.index);// 下边框颜色
//		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
//		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
//		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
//		return cellStyle;
//	}

}
