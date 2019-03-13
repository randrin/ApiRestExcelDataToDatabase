package it.sky.sop.exception;

public class Response {
	
	private String code;
	private String message;
	
	public Response(ResponseCodes errorCode) {
		this.code = errorCode.getCode();
		this.message = errorCode.getMessage();
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	  public String toString() {
	    return code + ": " + message;
	  }
	
	
}
