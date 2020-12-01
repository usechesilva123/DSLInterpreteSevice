package edu.co.unbosque.compiladores.interprete.mdl;

public class LayerParams {
	
	private Params params;

	public LayerParams(Params p) {
		this.params = p;
	}

	public double interpret(double in) {
		return params.interpret(in);
	}

}
