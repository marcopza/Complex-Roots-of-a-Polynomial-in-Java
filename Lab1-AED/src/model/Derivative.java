package model;

import org.nfunk.jep.JEP;

public class Derivative {

	private JEP jepDeriv = new JEP();

	public Derivative(String deriv) {

		jepDeriv.addStandardConstants();
		jepDeriv.addStandardFunctions();
		jepDeriv.addVariable("x", 0);
		jepDeriv.parseExpression(deriv);

	}

	public double eval(double x) {

		jepDeriv.addVariable("x", x);
		double r = jepDeriv.getValue();
		if (jepDeriv.hasError()) {
			System.out.println(jepDeriv.getErrorInfo());
		}
		return r;

	}

}
