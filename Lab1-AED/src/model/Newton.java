package model;

public class Newton {

	public double findRoot(Polynomial f, double x, double e, int n) {
		
		double r = Double.NaN;
		int k = 0;
		while (Math.abs(f.evalPoly(x)) > e && k < n) {
			x = x - (f.evalPoly(x) / f.evalDeriv(x));
			k++;
		}
		if (k < n) {
			r = x;
		}
		return r;
		
	}
	
}
