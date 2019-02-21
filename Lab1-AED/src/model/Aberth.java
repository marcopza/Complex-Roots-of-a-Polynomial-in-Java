package model;

import org.jscience.mathematics.number.Complex;
import org.jscience.mathematics.function.Polynomial;
import org.jscience.mathematics.function.Variable;

public class Aberth {
	private Complex[] roots;
	private Polynomial<Complex> polynomial;
	private Variable<Complex> x;
	private Complex[] complexCoe;
	private Complex[] previous;
	private double epsilon = 1e-50;
	private int maxIterations = 999;
	private int iterations = 0;

	
	public Aberth(Polynomial<Complex> polynomial, Complex[] complexCoe, Variable<Complex> x) {
		this.complexCoe = complexCoe;
		this.polynomial = polynomial;
		this.x = x;
		roots = new Complex[complexCoe.length-1];
		previous = new Complex[complexCoe.length-1];
		Complex guess = Complex.valueOf(0.4, 0.9);
		previous[0] = guess;
		for(int i = 1; i < complexCoe.length-1; i++) {
			previous[i] = previous[i-1].times(guess);
		}
	}

	
	public Complex[] solve() {
		
		boolean finished = false;
		Complex numerator;
		Complex denominator;
		int iterations = 0;
		while(!finished) {
			for(int i = 0; i < previous.length; i++) {
				numerator = Complex.ONE;
				denominator = Complex.ONE;
				for(int j = 0; j < previous.length; j++) {
					if(i != j) {
						numerator = polynomial.evaluate(previous[i]).divide(polynomial.differentiate(x).evaluate(previous[i]));
						denominator = ((Complex.ONE.divide(previous[i].minus(previous[j]))).plus(denominator));
					}
				}
				denominator = Complex.ONE.minus(numerator).times(denominator);
				roots[i] = previous[i].minus(numerator.divide(denominator));
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
	
}
