package emailWithExcel;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelCreation {
	public void create() {
		try {
			Workbook wb = new HSSFWorkbook();
			Sheet sheet = wb.createSheet();
			HSSFRow row = (HSSFRow) sheet.createRow(1);
			row.createCell(0).setCellValue("Excel Creation Sucssfully Executed");
			FileOutputStream file = new FileOutputStream("ExcelCreation.xlsx");
			wb.write(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
