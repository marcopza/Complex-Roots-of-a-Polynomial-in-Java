package model;

import org.jscience.mathematics.number.Complex;

import java.util.ArrayList;

import org.jscience.mathematics.function.Polynomial;;

public class DurandKerner {

	private ArrayList<Complex> roots;
	private Polynomial<Complex> polynomial;
	private double epsilon = 1e-15;
	private int maxIterations = 999;
	
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
