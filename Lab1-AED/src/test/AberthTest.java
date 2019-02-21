package test;

import static org.junit.jupiter.api.Assertions.*;
import org.jscience.mathematics.number.Complex;
import org.junit.jupiter.api.Test;

import model.ComplexPolynomial;

class AberthTest {

	
	public static void main(String[] args) {
		double[] coefficients = {1, -3, 3, -5};
		Complex[] results;
		ComplexPolynomial poly = new ComplexPolynomial(coefficients);
		results = poly.aberth();
		for(Complex c : results) {
			System.out.println(c.toText());
			System.out.println(poly.getPolynomial().evaluate(c));
		}
	}

}
