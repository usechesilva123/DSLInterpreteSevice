package edu.co.unbosque.compiladores.interprete.mdl;

public class Number extends Value {
	
	private double N; 

	public Number(Double n) {
		try {
			this.N = n;
		} catch (NumberFormatException e) {
			this.N = -1;
		}		
	}

	public String toString() {
		return ("" + this.N);
	}
	
	public double interpret(double in) {
		return this.N * in;
	}

	@Override
	public double interpret() {
		return this.N;
	}

}
