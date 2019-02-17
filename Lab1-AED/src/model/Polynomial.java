package model;

import org.nfunk.jep.JEP;

public class Polynomial {

	//polynomial parser
	private JEP jepPoly = new JEP();
	private Derivative deriv;
	
	public Polynomial(String poly, String deriv) {
		
		jepPoly.addStandardConstants();
		jepPoly.addStandardFunctions();
		jepPoly.parseExpression(poly);
		this.deriv = new Derivative(deriv);
		
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
