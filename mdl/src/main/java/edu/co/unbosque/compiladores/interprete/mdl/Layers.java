package edu.co.unbosque.compiladores.interprete.mdl;

public class Layers {
	
	private LayerList layList;

	public Layers(LayerList l) {
		this.layList = l;
	}

	public double interpret(double in) {
		return layList.interpret(in);
	}

}
