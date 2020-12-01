package edu.co.unbosque.compiladores.interprete.controller;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.co.unbosque.compiladores.interprete.exception.InterpretException;
import edu.co.unbosque.compiladores.interprete.exception.LexException;
import edu.co.unbosque.compiladores.interprete.exception.ParseException;
import edu.co.unbosque.compiladores.interprete.lexer.Lexer;
import edu.co.unbosque.compiladores.interprete.mdl.Program;
import edu.co.unbosque.compiladores.interprete.model.DataResponse;
import edu.co.unbosque.compiladores.interprete.model.ProgramInstance;
import edu.co.unbosque.compiladores.interprete.parser.parser;

@RestController
public class InterpreterMDLController {

	private static final Logger log = LoggerFactory.getLogger(InterpreterMDLController.class);

	/** SERVICIO PARA ANALISIS LEXICO Y PARSING */
	@RequestMapping(value = "/lexparse", method = RequestMethod.POST)
	public DataResponse lex(@RequestBody String data) {

		Reader reader = new StringReader(data);

		Lexer scanner = new Lexer(reader);  

		@SuppressWarnings("deprecation")
		parser parser = new parser(scanner); 

		try {
			log.info(".:: STARTING LEX-PARSE PROCESS");
			Program programa_axioma = (Program) parser.parse().value;  
			ProgramInstance.getInstance().setProgram(programa_axioma);		
			return new DataResponse(200,"OK",new Date(System.currentTimeMillis()),scanner.tokens);
		}
		catch(Error e) {
			log.error(e.getMessage());
			Exception ex = new LexException("Error de lex cerca de <"+ scanner.yytext() + ">");
			return new DataResponse(400,ex.getMessage(),new Date(System.currentTimeMillis()),scanner.tokens);
		} catch (Exception e) {
			log.error(e.getMessage());
			e = new ParseException("Error de parsing cerca de <"+ scanner.yytext() + ">");
			return new DataResponse(400,e.getMessage(),new Date(System.currentTimeMillis()),scanner.tokens);
		}
	}

	/** SERVICIO PARA INTERPRETE  */
	@RequestMapping(value = "/interpret", method = RequestMethod.POST)
	public DataResponse interpret(@RequestBody List<Double> data) {

		ProgramInstance program = ProgramInstance.getInstance();

		try {
			if(program.getProgram()==null) {
				throw new InterpretException("No hay modelo que interpretar");
			}
			double[] input = new double[data.size()];
			for (int i = 0; i < input.length; i++) {
				input[i] = data.get(i);                // java 1.5+ style 
			}
			log.info(".:: STARTING INTERPRET PROCESS ::.");
			ArrayList<Double> output = program.getProgram().interpret(input); 
			log.info(output+" CHAIN PROCESSED NORMALLY");

			return new DataResponse(200,"OK",new Date(System.currentTimeMillis()),output);
		}
		catch (Exception e) {
			log.error(e.getMessage());
			if (!(e instanceof InterpretException))
				e = new InterpretException(e.getMessage());
			return new DataResponse(400,e.getMessage(),new Date(),null);
		}
		catch (Error e) {
			log.error(e.getMessage());
			Exception ex = new InterpretException("Error de interpretacion: La cantidad de I/O declarados debe ser igual");
			return new DataResponse(400,ex.getMessage(),new Date(),null);
		}
	}


}
