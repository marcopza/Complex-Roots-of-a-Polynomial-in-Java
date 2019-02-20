package model;

import org.jscience.mathematics.number.Complex;
import java.util.ArrayList;
import org.jscience.mathematics.function.Polynomial;;

public class DurandKerner {

	private ArrayList<Complex> roots;
	private Polynomial<Complex> polynomial;
	private double epsilon = 1e-15;
	private int maxIterations = 999;
	

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
		this.polynomial = polynomial;
		for(int i = 0; i < complexCoe.length-1; i++) {
			if(i == 0) {
				roots.add(Complex.valueOf(-0.65, 0.72));
			}else {
				roots.add(Complex.valueOf(0.5, 0.9).pow(i));
			}
		}
	}

	/**
	 * This method finds the roots of the polynomial by the Durand Kerner method.
	 * The method stops once the absolute value of the results changes less than the epsilon defined.
	 * The method could also stop if it takes more than 999 iterations.
	 * @return ArrayList - the ArrayList containing the complex roots of the polynomial.
	 */
	public ArrayList<Complex> solve() {
		
		ArrayList<Complex> previous = roots;
		boolean finished = false;
		Complex divisor;
		Complex result;
		int iterations = 0;
		while(!finished) {
			for(int i = 0; i < roots.size(); i++) {
				divisor = Complex.ONE;
				for(int j = 0; j < previous.size(); j++) {
					if(i != j) {
						divisor = roots.get(i).minus(previous.get(j)).times(divisor);
					}
				}
				result = polynomial.evaluate(roots.get(i)).divide(divisor);
				roots.set(i, result);
			}
			iterations++;
			for(int i = 0; i < roots.size(); i++) {
				if((Math.abs(roots.get(i).minus(previous.get(i)).getReal()) < epsilon &&
						Math.abs(roots.get(i).minus(previous.get(i)).getImaginary()) < epsilon) ||
						!(iterations < maxIterations)) {
					finished = true;
				}
			}
		}
		return roots;
		
	}
	
}
