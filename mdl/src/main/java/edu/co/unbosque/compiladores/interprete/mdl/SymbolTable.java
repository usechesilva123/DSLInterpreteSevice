package edu.co.unbosque.compiladores.interprete.mdl;

import java.util.ArrayList;

public class SymbolTable {
	
	private ArrayList<Variable> symbolTable;
	
	public SymbolTable() {
		this.symbolTable = new ArrayList<Variable>();
	}
	
	public void enter(Variable e) {		
		Variable v = exists(e.getName());
		if(v == null) {
			this.symbolTable.add(e);
		}
	}
	
	public Variable exists(String n) {
		for(int i = 0; i<symbolTable.size(); i++) {
			if (n.indexOf(symbolTable.get(i).getName()) >= 0) {
				return symbolTable.get(i);
			}
		}
		return null;
	}	
	
	public String toString() {
		String temp = "";
		for(int i = 0; i<symbolTable.size(); i++) {
			temp += i + "." + symbolTable.get(i).toString() + " ";
		}
		return temp;
	}
}
