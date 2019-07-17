package com.alejo.games.core.modelo;

public class ResponseObject {
	public String text;
	public String status;

	public ResponseObject() {
		
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
