package model;

import org.nfunk.jep.JEP;

public class Derivative {

	private JEP jepDeriv = new JEP();
	
	public Derivative(String deriv) {
		
		jepDeriv.addStandardConstants();
		jepDeriv.addStandardFunctions();
		jepDeriv.parseExpression(deriv);
		
	}
	
	public double eval(double x) {
		
		jepDeriv.addVariable("x", x);
		double r = jepDeriv.getValue();
		return r;
		
	}
	
}
