package edu.co.unbosque.compiladores.interprete.mdl;

public class InputsList {
	
	private InputsList inList;
	private Input in;

	public InputsList(InputsList l, Input i) {
		this.inList = l;
		this.in = i;
	}

	public InputsList(Input i) {
		this.inList = null;
		this.in = i;
	}

	public int interpret() {
		if (inList!=null) {
			return inList.interpret() + in.interpret();
		} else {		
		return in.interpret();	
		}
	}

}
