package edu.co.unbosque.compiladores.interprete.model;

import edu.co.unbosque.compiladores.interprete.mdl.Program;

public class ProgramInstance {
	
	/* ÚNICA INSTANCIA DEL PROGRAMA */
	private static ProgramInstance instance;
	private Program program;

	private ProgramInstance() {
		super();
	}

	public static ProgramInstance getInstance() {
		if (instance == null) {
			instance = new ProgramInstance();
		}
		return instance;
	}

	/**
	 * @return the program
	 */
	public Program getProgram() {
		return program;
	}

	/**
	 * @param program the program to set
	 */
	public void setProgram(Program program) {
		this.program = program;
	}

}
