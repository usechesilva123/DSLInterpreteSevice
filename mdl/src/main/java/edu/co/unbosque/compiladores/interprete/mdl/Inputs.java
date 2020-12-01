package edu.co.unbosque.compiladores.interprete.mdl;

public class Inputs {
	
	private InputsList inputs;

	public Inputs(InputsList l) {
		this.inputs = l;
	}

	public int interpret() {
		return inputs.interpret();		
		
	}

}
