package model;

import org.nfunk.jep.JEP;

import ast.Operation;
import tokenizer.AbstractTreeBuilder;
import tokenizer.TokenizerException;

public class Polynomial {

	//polynomial parser
	private JEP jepPoly = new JEP();
	private Derivative deriv;
	
	public Polynomial(String poly, String deriv) throws TokenizerException {
		
		jepPoly.addStandardConstants();
		jepPoly.addStandardFunctions();
		jepPoly.parseExpression(poly);
		
	}
	
	public double evalPoly(double x) {
		
		jepPoly.addVariable("x", x);
		double r = jepPoly.getValue();
		if (jepPoly.hasError()) {
			System.out.println(jepPoly.getErrorInfo());
		}
		return r;
		
	}
	
	public double evalDeriv(double x) {
		
		return deriv.eval(x);
		
	}
	
}
