package edu.co.unbosque.compiladores.interprete.mdl;

import java.util.ArrayList;

public class Program implements MDL{

	private ModelName name;
	private ModelType type;
	private Inputs inputs;
	private Outputs outputs;
	private Model model;


	/**
	 * @param name
	 * @param type
	 * @param inputs
	 * @param outputs
	 * @param model
	 */
	public Program(ModelName name, ModelType type, Inputs inputs, Outputs outputs, Model model) {
		super();
		this.name = name;
		this.type = type;
		this.inputs = inputs;
		this.outputs = outputs;
		this.model = model;
	}

	public ArrayList<Double> interpret(double[] entries) {
		this.name.interpret();	
		this.type.interpret();	
		if(this.inputs.interpret()==this.outputs.interpret()) {		
			ArrayList<Double> result = new ArrayList<Double>();
			for(int i=0; i<entries.length; i++)
				result.add(this.model.interpret(entries[i]));	
			return result;
		} else {
			throw new Error("La cantidad de I/O debe ser la misma.");
		}
	}

}
