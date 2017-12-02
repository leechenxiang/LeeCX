package com.itzixi.common.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExportExcelUtils {
	
	private String title; // 导出表格的表名

	private String[] rowName;// 导出表格的列名

	private List<Object[]> dataList = new ArrayList<Object[]>(); // 对象数组的List集合

	private HttpServletResponse response;

	// 传入要导入的数据
	public ExportExcelUtils(String title, String[] rowName, List<Object[]> dataList, HttpServletResponse response) {
		this.title = title;
		this.rowName = rowName;
		this.dataList = dataList;
		this.response = response;
	}

	// 导出数据
	public void exportData() {
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个excel对象
			HSSFSheet sheet = workbook.createSheet(title); // 创建表格
			// 产生表格标题行
			HSSFRow rowm = sheet.createRow(0); // 行
			HSSFCell cellTiltle = rowm.createCell(0); // 单元格

			// sheet样式定义
			HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook); // 头样式
			HSSFCellStyle style = this.getStyle(workbook); // 单元格样式
			/**
			 * 参数说明 从0开始 第一行 第一列 都是从角标0开始 行 列 行列 (0,0,0,5) 合并第一行 第一列 到第一行 第六列
			 * 起始行，起始列，结束行，结束列
			 * 
			 * new Region() 这个方法使过时的
			 */
			// 合并第一行的所有列
			sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 0, (short) (rowName.length - 1)));
			cellTiltle.setCellStyle(columnTopStyle);
			cellTiltle.setCellValue(title);

			int columnNum = rowName.length; // 表格列的长度
			HSSFRow rowRowName = sheet.createRow(1); // 在第二行创建行
			HSSFCellStyle cells = workbook.createCellStyle();
			cells.setBottomBorderColor(HSSFColor.BLACK.index);
			rowRowName.setRowStyle(cells);
			
			// 循环 将列名放进去
			for (int i = 0; i < columnNum; i++) {
				HSSFCell cellRowName = rowRowName.createCell((int) i);
				cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING); // 单元格类型

				HSSFRichTextString text = new HSSFRichTextString(rowName[i]); // 得到列的值
				cellRowName.setCellValue(text); // 设置列的值
				cellRowName.setCellStyle(columnTopStyle); // 样式
			}
			
			// 将查询到的数据设置到对应的单元格中
			for (int i = 0; i < dataList.size(); i++) {
				Object[] obj = dataList.get(i);// 遍历每个对象
				HSSFRow row = sheet.createRow(i + 2);// 创建所需的行数
				for (int j = 0; j < obj.length; j++) {
					HSSFCell cell = null; // 设置单元格的数据类型
					if (j == 0) {
						// 第一列设置为序号
						cell = row.createCell(j, HSSFCell.CELL_TYPE_NUMERIC);
						cell.setCellValue(i + 1);
					} else {
						cell = row.createCell(j, HSSFCell.CELL_TYPE_STRING);
						if (!"".equals(obj[j]) && obj[j] != null) {
							cell.setCellValue(obj[j].toString()); // 设置单元格的值
						} else {
							cell.setCellValue("  ");
						}
					}
					cell.setCellStyle(style); // 样式
				}
			}
			
			// 让列宽随着导出的列长自动适应
			for (int i = 0; i < columnNum; i++) {
				sheet.autoSizeColumn((short) i);
			}
//			sheet.autoSizeColumn((short) 0); // 调整第一列宽度
//			sheet.autoSizeColumn((short) 1); // 调整第二列宽度
//			sheet.autoSizeColumn((short) 2); // 调整第三列宽度
//			sheet.autoSizeColumn((short) 3); // 调整第四列宽度
//			sheet.autoSizeColumn((short) 4); // 调整第五列宽度
//			sheet.autoSizeColumn((short) 5); // 调整第六列宽度
//			sheet.autoSizeColumn((short) 6); // 调整第六列宽度
//			sheet.autoSizeColumn((short) 7); // 调整第六列宽度
//			sheet.autoSizeColumn((short) 8); // 调整第六列宽度
//			sheet.autoSizeColumn((short) 9); // 调整第六列宽度
//			sheet.autoSizeColumn((short) 10); // 调整第六列宽度
//			sheet.autoSizeColumn((short) 11); // 调整第六列宽度
//			sheet.autoSizeColumn((short) 12); // 调整第六列宽度
//			sheet.autoSizeColumn((short) 13); // 调整第六列宽度

			if (workbook != null) {
				try {
					// excel 表文件名
					String fileName = title + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
					String fileNameFinal = URLEncoder.encode(fileName, "UTF-8");
					String headStr = "attachment; filename=\"" + fileNameFinal + "\"";
					response.setContentType("APPLICATION/OCTET-STREAM");
					response.setHeader("Content-Disposition", headStr);
					OutputStream out = response.getOutputStream();
					workbook.write(out);
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {

		// 设置字体
		HSSFFont font = workbook.createFont();
		// 设置字体大小
		font.setFontHeightInPoints((short) 11);
		// 字体加粗
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 设置字体名字
		font.setFontName("Courier New");
		// 设置样式;
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置底边框;
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// 设置底边框颜色;
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		// 设置左边框;
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// 设置左边框颜色;
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		// 设置右边框;
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// 设置右边框颜色;
		style.setRightBorderColor(HSSFColor.BLACK.index);
		// 设置顶边框;
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// 设置顶边框颜色;
		style.setTopBorderColor(HSSFColor.BLACK.index);
		// 在样式用应用设置的字体;
		style.setFont(font);
		// 设置自动换行;
		style.setWrapText(false);
		// 设置水平对齐的样式为居中对齐;
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 设置垂直对齐的样式为居中对齐;
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		return style;

	}

	public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
		// 设置字体
		HSSFFont font = workbook.createFont();
		// 设置字体大小
		// font.setFontHeightInPoints((short)10);
		// 字体加粗
		// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 设置字体名字
		font.setFontName("Courier New");
		// 设置样式;
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置底边框;
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// 设置底边框颜色;
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		// 设置左边框;
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// 设置左边框颜色;
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		// 设置右边框;
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// 设置右边框颜色;
		style.setRightBorderColor(HSSFColor.BLACK.index);
		// 设置顶边框;
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// 设置顶边框颜色;
		style.setTopBorderColor(HSSFColor.BLACK.index);
		// 在样式用应用设置的字体;
		style.setFont(font);
		// 设置自动换行;
		style.setWrapText(false);
		// 设置水平对齐的样式为左对齐;
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		// 设置垂直对齐的样式为居中对齐;
//		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		return style;
	}
}
