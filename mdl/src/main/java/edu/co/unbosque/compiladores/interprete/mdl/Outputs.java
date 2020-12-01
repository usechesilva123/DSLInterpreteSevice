package edu.co.unbosque.compiladores.interprete.mdl;

public class Outputs {
	
	private OutputsList outputs;

	public Outputs(OutputsList l) {
//		if(!r.equalsIgnoreCase("Outputs")) throw new Error("Expecting <\"Outputs\">");
		this.outputs = l;
	}

	public int interpret() {
		return outputs.interpret();		
	}

}
