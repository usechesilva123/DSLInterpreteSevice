package edu.co.unbosque.compiladores.interprete.mdl;

public class Layer {
	
	private LayerParams params;

	public Layer(LayerName n, LayerParams p) {
		this.params = p;
	}

	public double interpret(double in) {
		return params.interpret(in);
	}

}
