package edu.ilstu;

/**
 * This class contains methods to convert one unit of distance to a base unit (meters) and back.
 * 
 * @author Christopher A Runyan
 */
public class DistanceConverter{
	/**
	 * Converts kilometers to meters. 
	 * 
	 * @param kilometers	the number in kilometers to convert to meters
	 * @return				the number of meters in given number of kilometers
	 */
	public double kilometerToMeter(double kilometers){
		return kilometers*1000;
	}
	
	/**
	 * Converts centimeters to meters.
	 * 
	 * @param centimeters	the number in centimeters to convert to meters
	 * @return				the number of meters the given number of centimeters comprises
	 */
	public double centimeterToMeter(double centimeters){
		return centimeters*0.01;	
	}
	
	/**
	 * Converts miles to meters.
	 * 
	 * @param miles			the number in miles to convert to meters
	 * @return				the number of meters in given number of miles
	 */
	public double mileToMeter(double miles){
		return miles*1609.34;	
	}
	
	/**
	 * Converts yards to meters.
	 * 
	 * @param yards			the number in yards to convert to meters
	 * @return				the number of meters in given number of yards
	 */
	public double yardToMeter(double yards){
		return yards*(9.144e-1);	
	}
	
	/**
	 * Converts inches to meters.
	 * 
	 * @param inches		the number in inches to convert to meters
	 * @return				the number of meters the given number of inches comprises
	 */
	public double inchToMeter(double inches){
		return inches*(2.54e-2);	
	}
	
	/**
	 * Converts meters to kilometers.
	 * 
	 * @param meters		the number of meters to convert to kilometers
	 * @return				the number of kilometers the given number of meters comprises
	 */
	public double meterToKilometer(double meters){
		return meters*0.001;	
	}
	
	/**
	 * Converts meters to centimeters.
	 * 	
	 * @param meters		the number of meters to convert to centimeters
	 * @return				the number of centimeters in given number of meters
	 */
	public double meterToCentimeter(double meters){
		return meters*100;	
	}
	
	/**
	 * Converts meters to miles.
	 * 
	 * @param meters		the number of meters to convert to miles
	 * @return				the number of miles the given number of meters comprises
	 */
	public double meterToMile(double meters){
		return meters*(6.2137e-4);	
	}
	
	/**
	 * Converts meters to yards.
	 * 
	 * @param meters		the number of meters to convert to yards
	 * @return				the number of yards to given number of meters comprises
	 */
	public double meterToYard(double meters){
		return meters*1.0936;	
	}
	
	/**
	 * Converts meters to inches.
	 * 
	 * @param meters		the number of meters to convert to inches
	 * @return				the number of inches in given number of meters
	 */
	public double meterToInch(double meters){
		return meters*39.3701;	
	}
}
