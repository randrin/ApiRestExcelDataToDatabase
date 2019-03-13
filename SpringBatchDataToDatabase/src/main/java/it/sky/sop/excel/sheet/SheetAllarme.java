package it.sky.sop.excel.sheet;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import it.sky.sop.excel.export.ExcelObjectList;
import it.sky.sop.excel.export.SheetInterface;
import it.sky.sop.model.Allarme;

public class SheetAllarme extends SheetInterface {

	public static final String SHEET_NAME = "CFIA-SOP-v03";
	private final String TITLE = "CFIA-SOP-v03";
	private final short indexColorFont = IndexedColors.BLACK.getIndex();
	private final short indexColorBackground = IndexedColors.YELLOW.getIndex();
	
	private Class classForMethod = Allarme.class;
	private Workbook workbook;
	private List<Allarme> allarmes;
	private CellStyle dataCellStyle;
	private ArrayList<ExcelObjectList> excelObjectList;
	
	private int titleStart = 1;
	private int headerStart = 3;

	public SheetAllarme() {super();}

	public SheetAllarme(Workbook workbook, List<Allarme> allarme) {
		this.workbook = workbook;
		this.allarmes = allarme;
	}
	
	public void createSheet() {
		Sheet sheet = workbook.createSheet(SHEET_NAME);
		excelObjectList = getAllGetterMethod(classForMethod);
		createSheetData(workbook, sheet, excelObjectList, TITLE, indexColorFont, indexColorBackground, titleStart, headerStart);
		startingPopulate(sheet);
	}

	public void startingPopulate(Sheet sheet) {
		int rowStart = rowNumDataCelStart;
		dataCellStyle = workbook.createCellStyle();
		borderCell(dataCellStyle);
		
		for(Allarme al : allarmes) {
			populateCell(sheet, excelObjectList, al, rowStart, dataCellStyle);
			rowStart++;
		}
		autoSize(sheet, excelObjectList.size());
	}
	
}
