package edu.co.unbosque.compiladores.interprete.model;

import java.io.Serializable;
import java.util.*;

public class DataResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3176488448166027554L;
	private int status;
	private String message;
	private Date date;
	private Object data;
	/**
	 * @param status
	 * @param message
	 * @param date
	 * @param tokens
	 */
	public DataResponse(int status, String message, Date date, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.date = date;
		this.data = data;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the tokens
	 */
	public Object getData() {
		return data;
	}
	/**
	 * @param tokens the tokens to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

}
