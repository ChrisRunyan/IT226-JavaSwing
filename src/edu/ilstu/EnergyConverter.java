package edu.ilstu;

/**
 * This class contains methods to convert one unit of energy to a base unit (joules) and back.
 * 
 * @author Christopher A Runyan
 */
public class EnergyConverter{
	/**
	 * Converts hartrees to joules.
	 * 
	 * @param hartrees 		the number in hartrees to convert to joules
	 * @return				the number of joules the given number of hartrees comprises
	 */
	public double hartreeToJoule(double hartrees){
		return hartrees*(4.35974417e-18);
	}
	
	/**
	 * Converts BTUs to joules.
	 * 
	 * @param btu			the number in btus to convert to joules
	 * @return				the number of joules in given number of btus
	 */
	public double btuToJoule(double btu){
		return btu*1055.05585262;
	}
	
	/**
	 * Converts kilocalories to joules.
	 * 
	 * @param kilocalories	the number in kilocalories to convert to joules
	 * @return				the number of joules in given number of kilocalories
	 */
	public double kilocalorieToJoule(double kilocalories){
		return kilocalories*4184;
	}
	
	/**
	 * Converts watt hours to joules.
	 * 
	 * @param wattHours		the number in watt hours to convert to joules
	 * @return				the number of joules in given number of watt hours
	 */
	public double wattHourToJoule(double wattHours){
		return wattHours*3600;
	}
	
	/**
	 * Converts killowatt hours to joules.
	 * 
	 * @param kilowattHours	the number in kilowatt hours to convert to joules
	 * @return				the number of joules in given number of kilowatt hours
	 */
	public double kilowattHourToJoule(double kilowattHours){
		return kilowattHours*3600000;
	}
	
	/**
	 * Converts joules to hartrees.
	 * 
	 * @param joules		the number in joules to convert to hartrees
	 * @return				the number of hartrees in given number of joules
	 */
	public double jouleToHartree(double joules){
		return joules*(2.2937125689189e17);
	}
	
	/**
	 * Converts joules to btus.
	 * 
	 * @param joules		the number in joules to convert to btus
	 * @return				the number of btus the given number of joules comprises
	 */
	public double jouleToBTU(double joules){
		return joules/1055.05585262;
	}
	
	/**
	 * Converts joules to kilocalories.
	 * 
	 * @param joules		the number in joules to convert to kilocalories
	 * @return				the number of kilocalories the given number of joules comprises
	 */
	public double jouleToKilocalorie(double joules){
		return joules/4184;
	}
	
	/**
	 * Converts joules to watt hours.
	 * 
	 * @param joules		the number in joules to convert to watt hours
	 * @return				the number of watt hours the given number of joules comprises
	 */
	public double jouleToWattHour(double joules){
		return joules*0.000277778;
	}
	
	/**
	 * Converts joules to kilowatt hours.
	 * 
	 * @param joules		the number in joules to convert to kilowatt hours
	 * @return				the number of kilowatt hours the given number of joules comprises
	 */
	public double jouleToKilowattHour(double joules){
		return joules*(2.777778e-7);
	}
}
