package com.luchao.util;

import java.text.DecimalFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

/**
 * Utils - JSON
 * 
 * @author FMALL Team
 * @version 2.0
 */
public class POIUtils {
	
	protected static Log log = LogFactory.getLog(POIUtils.class);
	
	public static Cell createCellAndSetValue(XSSFRow row, int column, Object value) {
		if (value == null) return null;
		XSSFCell cell = row.createCell(column);
		cell.setCellValue(value.toString());
		cell.getCellStyle().setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cell.getCellStyle().setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cell.getCellStyle().setBorderRight(HSSFCellStyle.BORDER_THIN);
		cell.getCellStyle().setBorderTop(HSSFCellStyle.BORDER_THIN);
		cell.getCellStyle().setWrapText(true);
		return cell;
	}
	
	public static Cell createCellAndSetValue(Row row, int column, Object value) {
		if (value == null) return null;
		Cell cell = row.createCell(column);
		cell.setCellValue(value.toString());
		/*cell.getCellStyle().setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cell.getCellStyle().setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cell.getCellStyle().setBorderRight(HSSFCellStyle.BORDER_THIN);
		cell.getCellStyle().setBorderTop(HSSFCellStyle.BORDER_THIN);
		cell.getCellStyle().setWrapText(true);*/
		return cell;
	}
	
	public static String getStringCellValue(Cell cell){
		if(null == cell) return "";
		String strCell = "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING:
			strCell = cell.getStringCellValue().trim();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC: 
			DecimalFormat df = new DecimalFormat();
			df.applyPattern("#####.##");
			strCell = df.format(new Double(cell.getNumericCellValue()));
			//strCell = "" + cell.getNumericCellValue();
			break;  
		case HSSFCell.CELL_TYPE_BOOLEAN:  
			strCell = String.valueOf(cell.getBooleanCellValue());  
			break;  
		case HSSFCell.CELL_TYPE_BLANK:  
			strCell = "";  
			break;  
		default:  
			strCell = "";  
			break;
		}
		
		return strCell;
	}
	
	public static String getStringCellValue(Row row,int column) {
		if(row == null) return null;
		Cell cell = row.getCell(column);
		return getStringCellValue(cell);
	}
	

}
