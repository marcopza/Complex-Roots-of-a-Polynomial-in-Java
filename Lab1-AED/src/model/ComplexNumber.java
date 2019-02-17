package model;

/**
 * This was done in order to facilitate the usage of complex numbers as to find all roots of the specified 
 * polynomial, real and complex. 
 */

public class ComplexNumber {

	private double real;
	private double imaginary;
	private String joinedForm;
	
	public ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
		if(imaginary >= 0) {
			joinedForm = real + "+" + imaginary + "i";
		}else {
			joinedForm = real + "" + imaginary + "i";
		}
		
	}
	
	public ComplexNumber(double real) {
		this.real = real;
		this.imaginary = 0;
		joinedForm = real + "+" + imaginary + "i";
	}
	
	public String getJoinedForm() {
		return joinedForm;
	}
	
	public ComplexNumber add(ComplexNumber z) {
		return new ComplexNumber(this.real + z.real, this.imaginary + z.imaginary);
	}
	
	public ComplexNumber subtract(ComplexNumber z) {
		return new ComplexNumber(this.real - z.real, this.imaginary - z.imaginary);
	}
	
	public ComplexNumber multiply(ComplexNumber z) {
		double r = (this.real * z.real) - (this.imaginary * z.imaginary);
		double i = (this.real * z.imaginary) + (this.imaginary * z.real);
		return new ComplexNumber(r, i);
	}
	
	public ComplexNumber divide(ComplexNumber z) {
		double r = ((this.real * z.real)+(this.imaginary * z.imaginary)) / (Math.pow(z.real, 2) + Math.pow(z.imaginary, 2));
		double i = ((this.imaginary * z.real)-(this.real * z.imaginary)) / (Math.pow(z.real, 2) + Math.pow(z.imaginary, 2));
		return new ComplexNumber(r, i);
	}
	
	public static ComplexNumber pow(ComplexNumber z, int power)
	{
		ComplexNumber output = new ComplexNumber(z.real,z.imaginary);
		for(int i = 1; i < power; i++)
		{
			double r = output.real*z.real - output.imaginary*z.imaginary;
			double im = output.real*z.imaginary + output.imaginary*z.real;
			output = new ComplexNumber(r,im);
		}
		return output;
	}
}
