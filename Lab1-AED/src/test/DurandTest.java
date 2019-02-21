package test;

import static org.junit.jupiter.api.Assertions.*;

import org.jscience.mathematics.number.Complex;
import org.junit.jupiter.api.Test;

import model.ComplexPolynomial;

class DurandTest {

	private Complex[] results;
	private ComplexPolynomial poly;

	private void setUpScene1() {
		double[] coefficients = { 1, -3, 3, -5 };
		poly = new ComplexPolynomial(coefficients);
	}

	@Test
	void solveTest() {
		setUpScene1();
		results = poly.durandKerner();
		for (Complex c : results) {
			assertTrue((poly.getPolynomial().evaluate(c)).doubleValue() < 1e-10);
		}

	}

}
