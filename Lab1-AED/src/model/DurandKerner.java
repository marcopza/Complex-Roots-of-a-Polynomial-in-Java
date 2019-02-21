package model;

import org.jscience.mathematics.number.Complex;
import java.util.ArrayList;
import org.jscience.mathematics.function.Polynomial;

public class DurandKerner {

	private Complex[] roots;
	private Polynomial<Complex> polynomial;
	private Complex[] complexCoe;
	private Complex[] previous;
	private double epsilon = 1e-50;
	private int maxIterations = 999;
	private int iterations = 0;

	/**
	 * This is the constructor method of DurandKerner.
	 * What this does is add defined complex numbers different from one another
	 * This is done one time less than the number of complex coefficients of the complex polynomial.
	 * The coefficients array is only used as reference as it serves no real use.
	 * The evaluation is done with help from the JScience library.
	 * @param polynomial - the complex polynomial whose roots we want.
	 * @param complexCoe - the coefficients of the polynomial.
	 */
	public DurandKerner(Polynomial<Complex> polynomial, Complex[] complexCoe) {
		this.complexCoe = complexCoe;
		this.polynomial = polynomial;
		roots = new Complex[complexCoe.length-1];
		previous = new Complex[complexCoe.length-1];
		Complex guess = Complex.valueOf(0.4, 0.9);
		previous[0] = Complex.ONE;
		for(int i = 1; i < complexCoe.length-1; i++) {
			previous[i] = previous[i-1].times(guess);
		}
	}

	/**
	 * This method finds the roots of the polynomial by the Durand Kerner method.
	 * The method stops once the absolute value of the results changes less than the epsilon defined.
	 * The method could also stop if it takes more than 999 iterations.
	 * @return ArrayList - the ArrayList containing the complex roots of the polynomial.
	 */
	public Complex[] solve() {
		
		boolean finished = false;
		Complex result;
		int iterations = 0;
		while(!finished) {
			for(int i = 0; i < previous.length; i++) {
				result = Complex.ONE;
				for(int j = 0; j < previous.length; j++) {
					if(i != j) {
						result = previous[i].minus(previous[j]).times(result);
					}
				}
				roots[i] = previous[i].minus(evaluate(complexCoe, previous[i]).divide(result));
			}
			for(int i = 0; i < roots.length; i++) {
				if((Math.abs(roots[i].minus(previous[i]).getReal()) < epsilon &&
						Math.abs(roots[i].minus(previous[i]).getImaginary()) < epsilon) ||
						!(iterations < maxIterations)) {
					finished = true;
				}
			}
			iterations++;
			System.arraycopy(roots, 0, previous, 0, roots.length);
		}
		return roots;
		
	}
	
	
	/**
	 * This method uses Horner's method to evaluate a polynomial.
	 * More info can be found in: https://en.wikipedia.org/wiki/Horner%27s_method.
	 * @param cc - complex coefficients of the polynomial.
	 * @param x - the complex number to be evaluated in the function.
	 * @return the complex number resulting from evaluating the polynomial.
	 */
	public Complex evaluate(Complex[] cc, Complex x) {
		Complex result = cc[0];
        for (int i = 1; i < cc.length; i++) {
           result = result.times(x).plus(cc[i]);
        }
        return result;
	}
	
}
