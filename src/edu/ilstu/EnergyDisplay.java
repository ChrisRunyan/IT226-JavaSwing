package edu.ilstu;

import java.awt.event.KeyEvent;

/**
 * This class contains methods to display information on the energy tab.
 * 
 * @author Christopher A Runyan
 */
public class EnergyDisplay {
	static EnergyConverter eConvert=new EnergyConverter();
	
	static String inS=Double.toString(1.0);
	static boolean periodOrNeg=false;
	static int listenerTemp=2;
	static String outHartree=Double.toString(eConvert.jouleToHartree(1.0));
	static String outJoule=Double.toString(1.0);
	static String outKilocalorie=Double.toString(eConvert.jouleToKilocalorie(1.0));
	static String outWattHour=Double.toString(eConvert.jouleToWattHour(1.0));
	static String outKilowattHour=Double.toString(eConvert.jouleToKilowattHour(1.0));
	static String outBTU=Double.toString(eConvert.jouleToBTU(1.0));
	
	/**
	 * Displays the energy information on the energy tab.
	 * 
	 * @param listener	value associated with listener currently gathering input
	 * @param e	value associated with key event
	 * @throws NumberFormatException	throws if invalid input entered
	 */
	static void displayEnergyInfo(int listener, KeyEvent e) throws NumberFormatException{
		char inC=' ';
		String tempS="";
		double tempJoule=0;
		double inD=0;
		
		if(listener!=listenerTemp){
			switch(listener){
			case 1: inS=outHartree;
			break;
			case 2: inS=outJoule;
			break;
			case 3: inS=outKilocalorie;
			break;
			case 4: inS=outWattHour;
			break;
			case 5: inS=outKilowattHour;
			break;
			case 6: inS=outBTU;
			}
		}
		
		if((int)e.getKeyChar()==8)
	    {  
			//if backspace, reduce inS by one, if possible, otherwise do nothing
	        if(inS.length()>0){
	        	if(inS.charAt(inS.length()-1)=='-'||inS.charAt(inS.length()-1)=='.'){
	        		periodOrNeg=false;
	        	}
	        	inS=inS.substring(0, inS.length()-1);
	        }
	        if(inS.length()>0){
	        	if(inS.charAt(inS.length()-1)=='-'||inS.charAt(inS.length()-1)=='.'){
	        		periodOrNeg=true;
	        	}
	        }
	    }
		else{
			inC=e.getKeyChar();
			
			if(inC=='.'||inC=='-'){
				periodOrNeg=true;
			}
			else{
				periodOrNeg=false;
			}
		
			//try to add newest character to whole String
			try{
				tempS=Character.toString(inC);
				inS+=tempS;
			}
			catch(NumberFormatException f){
				OptionDisplay.displayCriticalErrorMessage();
				System.exit(1);
			}
		}
		
		//try to parse to double
		if(inS.length()>0&&periodOrNeg==false){
			try{
				inD=Double.parseDouble(inS);
			}
			catch(NumberFormatException f){
				if(inS.charAt(inS.length()-1)!='e'){
					boolean containsPeriodOrNeg=false;
					for(int i=0; i<inS.length(); i++){
						if(inS.charAt(i)=='.'||inS.charAt(i)=='-'){
							containsPeriodOrNeg=true;
						}
					}
					if(containsPeriodOrNeg){
						if(inS.charAt(inS.length()-1)!='e'&&inS.charAt(inS.length()-1)!='E'){
							OptionDisplay.displayInvalidEntryError();
						}
					}
					else{
						OptionDisplay.displayInvalidEntryError();
					}
				}
			}
		}
		else{
			int periodCounter=0;
			int negCounter=0;
			if(inS.length()>0&&periodOrNeg==true){
				for(int i=0; i<inS.length(); i++){
					if(inS.charAt(i)=='.'){
						periodCounter++;
					}
					if(inS.charAt(i)=='-'){
						negCounter++;
					}
				}
				if(periodCounter>1||negCounter>1){
					OptionDisplay.displayInvalidEntryError();
				}
				if(periodCounter==1&&negCounter==1){
					if(inS.charAt(inS.length()-1)=='-'){
						if(inS.length()>1){
							if(inS.charAt(inS.length()-2)!='e'&&inS.charAt(inS.length()-2)!='E'){
								OptionDisplay.displayInvalidEntryError();
							}
						}
						else{
							OptionDisplay.displayInvalidEntryError();
						}
					}
				}
			}
		}
		
		//based on listener, convert to btu
		switch(listener){
		case 1: tempJoule=eConvert.hartreeToJoule(inD);
		break;
		case 2: tempJoule=inD;
		break;
		case 3: tempJoule=eConvert.kilocalorieToJoule(inD);
		break;
		case 4: tempJoule=eConvert.wattHourToJoule(inD);
		break;
		case 5: tempJoule=eConvert.kilowattHourToJoule(inD);
		break;
		case 6: tempJoule=eConvert.btuToJoule(inD);
		}
		
		outHartree=Double.toString(eConvert.jouleToHartree(tempJoule));
		outJoule=Double.toString(tempJoule);
		outKilocalorie=Double.toString(eConvert.jouleToKilocalorie(tempJoule));
		outWattHour=Double.toString(eConvert.jouleToWattHour(tempJoule));
		outKilowattHour=Double.toString(eConvert.jouleToKilowattHour(tempJoule));
		outBTU=Double.toString(eConvert.jouleToBTU(tempJoule));
		
		//print btu to each, don't convert if listener was used
		if(listener==1){
			GUI.jouleJT.setText(outJoule);
			GUI.kilocalorieJT.setText(outKilocalorie);
			GUI.wattHourJT.setText(outWattHour);
			GUI.kilowattHourJT.setText(outKilowattHour);
			GUI.btuJT.setText(outBTU);
		}
		else if(listener==2){
			GUI.hartreeJT.setText(outHartree);
			GUI.kilocalorieJT.setText(outKilocalorie);
			GUI.wattHourJT.setText(outWattHour);
			GUI.kilowattHourJT.setText(outKilowattHour);
			GUI.btuJT.setText(outBTU);
		}
		else if(listener==3){
			GUI.hartreeJT.setText(outHartree);
			GUI.jouleJT.setText(outJoule);
			GUI.wattHourJT.setText(outWattHour);
			GUI.kilowattHourJT.setText(outKilowattHour);
			GUI.btuJT.setText(outBTU);
		}
		else if(listener==4){
			GUI.hartreeJT.setText(outHartree);
			GUI.jouleJT.setText(outJoule);
			GUI.kilocalorieJT.setText(outKilocalorie);
			GUI.kilowattHourJT.setText(outKilowattHour);
			GUI.btuJT.setText(outBTU);
		}
		else if(listener==5){
			GUI.hartreeJT.setText(outHartree);
			GUI.jouleJT.setText(outJoule);
			GUI.kilocalorieJT.setText(outKilocalorie);
			GUI.wattHourJT.setText(outWattHour);
			GUI.btuJT.setText(outBTU);
		}
		else if(listener==6){
			GUI.hartreeJT.setText(outHartree);
			GUI.jouleJT.setText(outJoule);
			GUI.kilocalorieJT.setText(outKilocalorie);
			GUI.wattHourJT.setText(outWattHour);
			GUI.kilowattHourJT.setText(outKilowattHour);
		}
		
		listenerTemp=listener;
	}		
}