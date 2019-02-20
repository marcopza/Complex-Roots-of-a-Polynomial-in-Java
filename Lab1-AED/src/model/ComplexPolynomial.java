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
	
	public ComplexPolynomial(Double[] coefficients) {
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
	
	public ArrayList<Complex> durandKerner(){
		
		dk = new DurandKerner(polynomial, complexCoe);
		return dk.solve();
	}
	
}
