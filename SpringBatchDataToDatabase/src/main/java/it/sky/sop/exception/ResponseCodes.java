package it.sky.sop.exception;

public enum ResponseCodes {
	
	//Italian response code for FE
	OK_INSERT_USER("OK","User added to DB"),
	OK_DELETE_USER("OK","User deleted from DB"),
	OK_MODIFY_USER("OK","User modified"),
	OK_INSERT_EMAIL("OK","Email added to DB"),
	OK_MODIFY_EMAIL("OK","Email modified"),
	OK_DELETE_EMAIL("OK","Email deleted from DB"),
	
	OK_EXCEL_FILE_NOT_EXIST("OK","Monitoring card does not exist. Adding new"),
	OK_INSERT_MONITORING_CARD("OK","Monitoring card inserted on DB"),
	OK_CHECK_MONITORING_CARD("OK","Check passed"),
	OK_INSERT_SKYDE("OK","SkyDE inserted on DB"),
	
	ERROR_GENERIC("ERR0001",""),
	ERROR_USER_NO_PERMISSION("ERR0002","User without permissions. Contact your administrator"),
	ERROR_USER_NOT_FOUND("ERR0003","User or Password not found on LDAP"),
	ERROR_GET_USERS_DB("ERR0004","Error getting users on DB"),
	ERROR_SET_USER_DB("ERR0005","Error on insert user on DB"),
	ERROR_DELETE_USER_DB("ERR0006","Error on delete user on DB"),
	ERROR_MODIFY_USER_DB("ERR0007","Error on modify user on DB"),
	ERROR_PARSE_OBJECT("ERR0008","Error on parsing JSON Data"),
	ERROR_INVALID_INPUT("ERR0009","Invalid Parameters"),
	ERROR_GET_EMAILS_DB("ERR0010","Error getting email on DB"),
	ERROR_SET_EMAIL_DB("ERR0011","Error on insert email on DB"),
	ERROR_GET_ASSETS_DB("ERR0012","Error getting assets on DB"),
	
	
	ERROR_EXCEL_CONCURRENCY_EXPORT("ERR0012","To many process for export excel..Wait many second"),
	
	
	//excel Import 
	ERROR_EXCEL_FILE_IMPORT_MISSING("ERR0013","Seleziona un file da aggiungere"),

	ERROR_EXCEL_ID_NULL("ERR0014","Campo 'Id Scheda Monitoraggio' vuoto."),
	ERROR_EXCEL_SHEET_NULL("ERR0015","Sheet 'Informazioni Scheda' non presente"),
	ERROR_EXCEL_FIELD_TITLE_NULL("ERR0016","Campo 'Titolo Scheda' vuoto"),
	ERROR_EXCEL_FIELD_VERSION_NULL("ERR0017","Campo 'Versione' vuoto"),
	ERROR_EXCEL_ID_NOT_NULL("ERR0018","Campo 'Id Scheda Monitoraggio' non vuoto"),
	ERROR_EXCEL_FILENAME_NO_MATCH("ERR0019","Campo 'Nome Scheda' e il nome del file excel non corrispondono"),
	ERROR_PARSING_EMAIL("ERR0020","Error parsing emails from DB"),
	ERROR_CALLER_MISSING("ERR0021","Caller is missing"),
	
	
	WARN_EXCEL_MONITORING_CARD_EXIST("WARN0001","Esiste già una scheda di monitoraggio con questo nome sul DB. Vuoi continuare l'inserimento?");
	
	
	private String code;
	private String message;
	
	ResponseCodes(String code, String message){
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public ResponseCodes setCode(String code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ResponseCodes setMessage(String message) {
		this.message = message;
		return this;
	}
	
	public String toString() {
		return this.getCode() + "-> Message: " + this.getMessage();
	}
}
