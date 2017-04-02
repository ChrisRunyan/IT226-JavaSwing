package edu.ilstu;

import java.awt.event.KeyEvent;

/**
 * This class contains methods to display information on the distance tab.
 * 
 * @author Christopher A Runyan
 */
public class DistanceDisplay {
	static DistanceConverter dConvert=new DistanceConverter();
	
	static String inS=Double.toString(1.0);
	static boolean periodOrNeg=false;
	static int listenerTemp=6;
	static String outKilometer=Double.toString(dConvert.meterToKilometer(1.0));
	static String outCentimeter=Double.toString(dConvert.meterToCentimeter(1.0));
	static String outMile=Double.toString(dConvert.meterToMile(1.0));
	static String outYard=Double.toString(dConvert.meterToYard(1.0));
	static String outInch=Double.toString(dConvert.meterToInch(1.0));
	static String outMeter=Double.toString(1.0);
	
	/**
	 * Displays the distance information on the distance tab.
	 * 
	 * @param listener	value associated with listener currently gathering input
	 * @param e	value associated with key event
	 * @throws NumberFormatException	throws if invalid input entered
	 */
	static void displayDistanceInfo(int listener, KeyEvent e) throws NumberFormatException{
		char inC=' ';
		String tempS="";
		double inD=0;
		double tempMeter=0;
		
		if(listener!=listenerTemp){
			switch(listener){
			case 1: inS=outKilometer;
			break;
			case 2: inS=outCentimeter;
			break;
			case 3: inS=outMile;
			break;
			case 4: inS=outYard;
			break;
			case 5: inS=outInch;
			break;
			case 6: inS=outMeter;
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
		case 1: tempMeter=dConvert.kilometerToMeter(inD);
		break;
		case 2: tempMeter=dConvert.centimeterToMeter(inD);
		break;
		case 3: tempMeter=dConvert.mileToMeter(inD);
		break;
		case 4: tempMeter=dConvert.yardToMeter(inD);
		break;
		case 5: tempMeter=dConvert.inchToMeter(inD);
		break;
		case 6: tempMeter=inD;
		}
		
		outKilometer=Double.toString(dConvert.meterToKilometer(tempMeter));
		outCentimeter=Double.toString(dConvert.meterToCentimeter(tempMeter));
		outMile=Double.toString(dConvert.meterToMile(tempMeter));
		outYard=Double.toString(dConvert.meterToYard(tempMeter));
		outInch=Double.toString(dConvert.meterToInch(tempMeter));
		outMeter=Double.toString(tempMeter);
		
		//print btu to each, don't convert if listener was used
		if(listener==1){
			GUI.centimeterJT.setText(outCentimeter);
			GUI.mileJT.setText(outMile);
			GUI.yardJT.setText(outYard);
			GUI.inchJT.setText(outInch);
			GUI.meterJT.setText(outMeter);
		}
		else if(listener==2){
			GUI.kilometerJT.setText(outKilometer);
			GUI.mileJT.setText(outMile);
			GUI.yardJT.setText(outYard);
			GUI.inchJT.setText(outInch);
			GUI.meterJT.setText(outMeter);
		}
		else if(listener==3){
			GUI.kilometerJT.setText(outKilometer);
			GUI.centimeterJT.setText(outCentimeter);
			GUI.yardJT.setText(outYard);
			GUI.inchJT.setText(outInch);
			GUI.meterJT.setText(outMeter);
		}
		else if(listener==4){
			GUI.kilometerJT.setText(outKilometer);
			GUI.centimeterJT.setText(outCentimeter);
			GUI.mileJT.setText(outMile);
			GUI.inchJT.setText(outInch);
			GUI.meterJT.setText(outMeter);
		}
		else if(listener==5){
			GUI.kilometerJT.setText(outKilometer);
			GUI.centimeterJT.setText(outCentimeter);
			GUI.mileJT.setText(outMile);
			GUI.yardJT.setText(outYard);
			GUI.meterJT.setText(outMeter);
		}
		else if(listener==6){
			GUI.kilometerJT.setText(outKilometer);
			GUI.centimeterJT.setText(outCentimeter);
			GUI.mileJT.setText(outMile);
			GUI.yardJT.setText(outYard);
			GUI.inchJT.setText(outInch);
		}
		
		listenerTemp=listener;
	}
}