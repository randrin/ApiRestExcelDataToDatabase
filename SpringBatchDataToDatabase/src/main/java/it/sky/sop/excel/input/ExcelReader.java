package it.sky.sop.excel.input;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import it.sky.sop.excel.export.ExcelBuilder;
import it.sky.sop.excel.export.SheetInterface;
import it.sky.sop.excel.sheet.SheetAllarme;
import it.sky.sop.model.Allarme;
import it.sky.sop.model.AllarmeFile;

@Component
public class ExcelReader {

	@Value("${pathBackupAllarmeFolder}")
	public String pathBackupAllarmeFolder;
	
	public AllarmeFile readExcelAsset(MultipartFile file) throws EncryptedDocumentException, InvalidFormatException, IOException {

		Workbook workbook = WorkbookFactory.create(file.getInputStream());
		Iterator<Sheet> sheetIterator = workbook.sheetIterator();
		AllarmeFile allarmeFile = new AllarmeFile();
		SheetInterface s = new SheetInterface();
		workbook.forEach(sheet -> {
            switch(sheet.getSheetName()){
            
	            case SheetAllarme.SHEET_NAME:
	            	allarmeFile.setAllarme(s.readExcelFile(sheet, new SheetInterface().headerStartDefault, new Allarme()));
	            	break;
            }
        });
		
		return allarmeFile;
	}
	
	public void backUpAsset(AllarmeFile allarmeFile) {
		FileOutputStream fileOut;
		try {
			
			Workbook workbook = ExcelBuilder.buildExcel(allarmeFile);	
			LocalDate localDate = LocalDate.now();
			String filename = allarmeFile.getFileName();
			String path = getPathBackupAllarmeFolder()+ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

			String nameFile = filename + "_" + ZonedDateTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss"));
			
			FileUtils.forceMkdir(new File(path));
			fileOut = new FileOutputStream(path+"\\"+nameFile+".xlsx");
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @return the pathBackupAllarmeFolder
	 */
	public String getPathBackupAllarmeFolder() {
		return pathBackupAllarmeFolder;
	}

	/**
	 * @param pathBackupAllarmeFolder the pathBackupAllarmeFolder to set
	 */
	public void setPathBackupAllarmeFolder(String pathBackupAllarmeFolder) {
		this.pathBackupAllarmeFolder = pathBackupAllarmeFolder;
	}
	
}
