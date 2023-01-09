package com.prospecta.model;

public class DesiredResultDTO {

	private String title;
	private String description;
	public DesiredResultDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DesiredResultDTO(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
