package edu.co.unbosque.compiladores.interprete.model;

import java.io.Serializable;

public class Token implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7447111572631088895L;
	private String type;
	private String text;
	private int line;
	private int column;
	/**
	 * @param type
	 * @param text
	 * @param line
	 * @param column
	 */
	public Token(String type, String text, int line, int column) {
		super();
		this.type = type;
		this.text = text;
		this.line = line;
		this.column = column;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the line
	 */
	public int getLine() {
		return line;
	}
	/**
	 * @param line the line to set
	 */
	public void setLine(int line) {
		this.line = line;
	}
	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}
	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

}
