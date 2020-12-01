package edu.co.unbosque.compiladores.interprete.mdl;

public class Params {	
	
	private Params params;
	private Number n;

	public Params(String n, Params p) {
		this.params = p;
		this.n = new Number(Double.parseDouble(n));
	}

	public Params(String n) {
		this.params = null;
		this.n = new Number(Double.parseDouble(n));
	}

	public double interpret(double in) {
		if (params!=null) {
			return params.interpret(in) + n.interpret(in);
		} else {		
		return n.interpret(in);	
		}
	}

}
