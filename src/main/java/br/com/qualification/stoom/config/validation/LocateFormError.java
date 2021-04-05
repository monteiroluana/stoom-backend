package br.com.qualification.stoom.config.validation;

public class LocateFormError {
	private String attribute;
	private String error;
	
	public LocateFormError(String attribute, String error) {
		super();
		this.attribute = attribute;
		this.error = error;
	}

	public String getAttribute() {
		return attribute;
	}

	public String getError() {
		return error;
	}
	
	
	
}
