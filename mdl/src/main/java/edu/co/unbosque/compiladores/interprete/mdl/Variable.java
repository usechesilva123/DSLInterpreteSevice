package edu.co.unbosque.compiladores.interprete.mdl;

public class Variable extends Value {
	
	private String name;
	private int value;	
	
	public Variable(String name) {	
		this.name = name;
		this.value = 0;		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public double interpret() {		
		return this.value;
	}
	
	@Override
	public String toString() {		
		return "[" + this.name + ":" + this.value + "]";
	}

	@Override
	public double interpret(double in) {
		return this.value*in;
	}


}
