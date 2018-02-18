package com.capgemini.java.firstpackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static void main(String[] args) {
//`POI-XSSF - Java API To Access Microsoft Excel Format Files
		String path = "C:\\Users\\Prakash's\\Desktop\\TestExcel.xlsx";
		int index = 0;
		String sheetName = "Sheet1";

		try {
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			// int index = workbook.getSheetIndex(sheetName);
			XSSFSheet sheet = workbook.getSheetAt(index);

			/*
			 * Simply but will give error if cell is blank XSSFCell
			 * cellValue=sheet.getRow(3).getCell(3);
			 * System.out.println(cellValue);
			 */

			XSSFRow row = sheet.getRow(3);
			if (row == null) {
				System.out.println("emptyrow");
				return;
			}

			XSSFCell cell = row.getCell(3);
			if (cell == null) {
				System.out.println("emptycell");
				return;
			}

			System.out.println(cell);

			// setcelldata

			int rowNum = 2;
			int colNum = 2;

		
			row = sheet.createRow(rowNum - 1);

			cell = row.createCell(colNum - 1);

			cell.setCellValue("sdsd");

			FileOutputStream fileOut = new FileOutputStream(path);

			workbook.write(fileOut);

			fileOut.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// fis.close();

	}

}
