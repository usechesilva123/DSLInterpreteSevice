package edu.co.unbosque.compiladores.interprete.mdl;

public class LayerList {
	
	private LayerList layers;
	private Layer layer;

	public LayerList(LayerList ll, Layer l) {
		this.layers = ll;
		this.layer = l;
	}

	public LayerList(Layer l) {
		this.layers = null;
		this.layer = l;
	}

	public double interpret(double in) {
		if (layers!=null) {
			return layers.interpret(in) * layer.interpret(in);
		} else {		
		return layer.interpret(in);	
		}
	}

}
