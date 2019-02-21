package model;

import java.util.ArrayList;

import org.jscience.mathematics.function.Polynomial;
import org.jscience.mathematics.function.Term;
import org.jscience.mathematics.function.Variable;
import org.jscience.mathematics.number.Complex;

public class ComplexPolynomial {

	private Polynomial<Complex> polynomial;
	private DurandKerner dk;
	private Complex[] complexCoe;
	
	
	/**
	 * This is the constructor method for the ComplexPolynomial class. 
	 * This method receives an array of double values, said values are the coefficients of the polynomial.
	 * The first number of the array must be the coefficient paired with the variable which indicates the
	 * order of the polynomial.
	 * Using the array, the method then creates a complex polynomial starting with value zero then adding each 
	 * coefficient paired with the desired variable "x" to the e_th power.  
	 * @param coefficients
	 */
	public ComplexPolynomial(double[] coefficients) {
		complexCoe = new Complex[coefficients.length];
		for(int i = 0; i < coefficients.length; i++) {
			complexCoe[i] = Complex.valueOf(coefficients[i], 0);
		}
		Variable<Complex> variable = new Variable.Local<Complex>("x");
		polynomial = Polynomial.valueOf(Complex.ZERO, variable);
		for (int i = 0, e = complexCoe.length - 1; i < complexCoe.length; i++, e--) {
            polynomial = polynomial.plus(Polynomial.valueOf(complexCoe[i], Term.valueOf(variable, e)));
        }
	}
	
	/**
	 * This method initializes a new DurandKerner object.
	 * With this object, the method calls the root_finder method in class DurandKerner, returning the value
	 * it obtains from it. 
	 * @return ArrayList - the ArrayList containing the roots.
	 */
	public Complex[] durandKerner(){
		
		dk = new DurandKerner(polynomial, complexCoe);
		return dk.solve();
		
	}

	public Polynomial<Complex> getPolynomial() {
		return polynomial;
	}
	
}
