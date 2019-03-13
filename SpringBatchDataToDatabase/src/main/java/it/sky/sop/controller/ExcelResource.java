package it.sky.sop.controller;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import it.sky.sop.excel.input.ExcelReader;
import it.sky.sop.exception.Response;
import it.sky.sop.exception.ResponseCodes;
import it.sky.sop.model.Allarme;
import it.sky.sop.model.AllarmeFile;
import it.sky.sop.repository.AllarmeFileRepository;
import it.sky.sop.repository.AllarmeRepository;

@RestController
@CrossOrigin
@RequestMapping("/excel")
public class ExcelResource {

	public static final Logger logger = LoggerFactory.getLogger(ExcelResource.class);
	
	@Autowired
	AllarmeRepository allarmeRepository;
	
	@Autowired
	AllarmeFileRepository allarmeFileRepository;
	
	@Autowired
	ExcelReader excelReader;
	
	@PostMapping("/importAllarme")
	public ResponseEntity<Object> importAssetFile (@RequestHeader(value = "caller") String caller,@RequestParam(value = "file") MultipartFile file) throws EncryptedDocumentException, InvalidFormatException, IOException {
		if (file == null) {
			return new ResponseEntity<Object>(new Response(ResponseCodes.ERROR_EXCEL_FILE_IMPORT_MISSING), HttpStatus.OK);
		}
		
		logger.info("Trying to import file Allarme Sop: " + file.getOriginalFilename());
		AllarmeFile allarmeFile = excelReader.readExcelAsset(file);
		
		allarmeFile.setFileName(file.getOriginalFilename());
		allarmeFile.setLastEditDate(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		allarmeFile.setLastEditOwner(caller);
		
		AllarmeFile allarmeBackUp = null;
		List<AllarmeFile> allarmeList = allarmeFileRepository.findAll();
		
		if (allarmeList != null && allarmeList.size() > 0) {
			allarmeBackUp = allarmeList.get(0);
			allarmeBackUp.setAllarme(allarmeRepository.findAll());
		}
		
		if (allarmeBackUp != null) {
			excelReader.backUpAsset(allarmeBackUp);
		}
		
		logger.info("Start deleting Allarmes File");
		allarmeFileRepository.deleteAll();
		allarmeRepository.deleteAll();
		logger.info("End deleting Allarmes File");
		
		logger.info("Start saving Allarmes files");
		allarmeFileRepository.saveAndFlush(allarmeFile);
		allarmeRepository.saveAll(allarmeFile.getAllarme());
		logger.info("End saving Allarmes files");
		
		return new ResponseEntity<Object>(allarmeFile, HttpStatus.OK);
		
	}
}
