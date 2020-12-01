package edu.co.unbosque.compiladores.interprete.mdl;


public class OutputsList {

	private OutputsList outList;
	private Output out;

	public OutputsList(OutputsList l, Output o) {
		this.outList = l;
		this.out = o;
	}

	public OutputsList(Output o) {
		this.outList= null;
		this.out = o;
	}

	public int interpret() {
		if (outList!=null) {
			return outList.interpret() + out.interpret();
		} else {		
		return out.interpret();	
		}
	}

}
