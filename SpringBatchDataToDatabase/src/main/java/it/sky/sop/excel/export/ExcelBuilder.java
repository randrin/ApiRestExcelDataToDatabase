package it.sky.sop.excel.export;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import it.sky.sop.excel.sheet.SheetAllarme;
import it.sky.sop.model.AllarmeFile;
import it.sky.sop.model.ModelEntity;

public class ExcelBuilder {

	public static Workbook buildExcel(ModelEntity object) {

		ExcelBuilder excelBuilder = new ExcelBuilder();

		if (object instanceof AllarmeFile) {
			System.out.println("allarme excel");
			return excelBuilder.startBuildAllarme((AllarmeFile) object);
		}
		return null;
	}

	private Workbook startBuildAllarme(AllarmeFile allarmeFile) {
		Workbook workbook = new XSSFWorkbook();
		
		SheetAllarme sheetAllarme = new SheetAllarme(workbook, allarmeFile.getAllarme());
		sheetAllarme.createSheet();
		return workbook;
	}
}
