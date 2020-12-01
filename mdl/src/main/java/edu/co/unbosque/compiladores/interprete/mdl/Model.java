package edu.co.unbosque.compiladores.interprete.mdl;

public class Model {
	
	private Layers layers;

	public Model(Layers l) {
//		if(!r.equalsIgnoreCase("Model")) throw new Error("Expecting <\"Model\">");
		this.layers = l;
	}

	public double interpret(double in) {
		return layers.interpret(in);		
	}

}
