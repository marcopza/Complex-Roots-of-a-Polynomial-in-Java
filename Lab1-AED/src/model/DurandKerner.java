package model;

import java.util.ArrayList;

public class DurandKerner {

	private ArrayList<String> roots;
	private ArrayList<ComplexNumber> previous;
	private ArrayList<ComplexNumber> current;
	private ArrayList<ComplexNumber> coefficients;
	private double epsilon = 1e-15;
	
	public DurandKerner(ArrayList<ComplexNumber> coefficients) {
		this.coefficients = coefficients;
		ComplexNumber toAdd1 = new ComplexNumber(0.4, 0.9);
		for (int i = 0; i < coefficients.size() - 1; i++) {
			if(i == 0) {
				previous.add(new ComplexNumber(1));
			}
			else {
				previous.add(toAdd1);
				
			}
		}
	}
	
	public ArrayList<String> findRoots(){
		boolean keepGoing = true;
		ComplexNumber divisor;
		while(keepGoing) {
			for(int i = 0; i < current.size(); i++) {
				for(int j = 0; j < previous.size(); j++) {
					divisor = new ComplexNumber(1);
					if(i != j) {
						divisor = divisor.multiply((current.get(i).subtract(previous.get(j))));
					}
				}
				
			}
			
//			if() {
//				
//			}
		}
		
		for(ComplexNumber c : current) {
			roots.add(c.getJoinedForm());
		}
		return roots;
	}
	
}
