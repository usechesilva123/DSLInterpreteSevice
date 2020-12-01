package edu.co.unbosque.compiladores.interprete.mdl;

public abstract class Value implements MDL{
	
	public abstract double interpret();
	
	public abstract double interpret(double in);

}
