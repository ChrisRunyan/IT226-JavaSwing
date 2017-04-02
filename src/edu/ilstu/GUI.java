package edu.ilstu;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * Class containing the main method for the Java Swing unit converter created for IT226. Contains methods for
 * creating containers, JFrame objects, and other necessities for a GUI.
 * 
 * @author Christopher A Runyan
 */
@SuppressWarnings("serial")
public class GUI extends JPanel{
	static JTextArea hartreeJT;
	static JTextArea jouleJT;
	static JTextArea kilocalorieJT;
	static JTextArea wattHourJT;
	static JTextArea kilowattHourJT;
	static JTextArea btuJT;
	static JTextArea kilometerJT;
	static JTextArea centimeterJT;
	static JTextArea mileJT;
	static JTextArea yardJT;
	static JTextArea inchJT;
	static JTextArea meterJT;
	
	/**
	 * Creates the tabbed panes for distance and energy.
	 */
	public GUI(){
		super(new GridLayout());
		JTabbedPane tabbedPane=new JTabbedPane();
		
	    tabbedPane.addTab("Distance", this.DistanceContainer());
	    tabbedPane.addTab("Energy", this.EnergyContainer());
	    
	    tabbedPane.setFont(getFont().deriveFont(22.0f));
		add(tabbedPane);
	}
	
	/**
	 * Creates the container for the distance tab.
	 * 
	 * @return	container for the distance tab
	 */
	public Container DistanceContainer(){
		DistanceListener dListenKilometer=new DistanceListener(1);
		DistanceListener dListenCentimeter=new DistanceListener(2);
		DistanceListener dListenMile=new DistanceListener(3);
		DistanceListener dListenYard=new DistanceListener(4);
		DistanceListener dListenInch=new DistanceListener(5);
		DistanceListener dListenMeter=new DistanceListener(6);
		
		Container pane1=new Container();
		pane1.setLayout(new GridLayout(4, 3, 4, 4));
		
		kilometerJT=new JTextArea();
		kilometerJT.setFont(getFont().deriveFont(20.0f));
		kilometerJT.setLineWrap(true);
		kilometerJT.setHighlighter(null);
		kilometerJT.setText(DistanceDisplay.outKilometer);
		kilometerJT.addKeyListener(dListenKilometer);
		
		centimeterJT=new JTextArea();
		centimeterJT.setFont(getFont().deriveFont(20.0f));
		centimeterJT.setLineWrap(true);
		centimeterJT.setHighlighter(null);
		centimeterJT.setText(DistanceDisplay.outCentimeter);
		centimeterJT.addKeyListener(dListenCentimeter);
		
		mileJT=new JTextArea();
		mileJT.setFont(getFont().deriveFont(20.0f));
		mileJT.setLineWrap(true);
		mileJT.setHighlighter(null);
		mileJT.setText(DistanceDisplay.outMile);
		mileJT.addKeyListener(dListenMile);
		
		yardJT=new JTextArea();
		yardJT.setFont(getFont().deriveFont(20.0f));
		yardJT.setLineWrap(true);
		yardJT.setHighlighter(null);
		yardJT.setText(DistanceDisplay.outYard);
		yardJT.addKeyListener(dListenYard);
		
		inchJT=new JTextArea();
		inchJT.setFont(getFont().deriveFont(20.0f));
		inchJT.setLineWrap(true);
		inchJT.setHighlighter(null);
		inchJT.setText(DistanceDisplay.outInch);
		inchJT.addKeyListener(dListenInch);
		
		meterJT=new JTextArea();
		meterJT.setFont(getFont().deriveFont(20.0f));
		meterJT.setLineWrap(true);
		meterJT.setHighlighter(null);
		meterJT.setText(DistanceDisplay.outMeter);
		meterJT.addKeyListener(dListenMeter);
		
		JLabel kilometerL=new JLabel("Kilometers (km)");
		kilometerL.setFont(getFont().deriveFont(20.0f));
		
		JLabel centimeterL=new JLabel("Centimeters (cm)");
		centimeterL.setFont(getFont().deriveFont(20.0f));
		
		JLabel mileL=new JLabel("Miles (mi)");
		mileL.setFont(getFont().deriveFont(20.0f));
		
		JLabel yardL=new JLabel("Yards (yd)");
		yardL.setFont(getFont().deriveFont(20.0f));
		
		JLabel inchesL=new JLabel("Inches (in)");
		inchesL.setFont(getFont().deriveFont(20.0f));
		
		JLabel meterL=new JLabel("Meters (m)");
		meterL.setFont(getFont().deriveFont(20.0f));
	
		
		pane1.add(centimeterJT);
		pane1.add(inchJT);
		pane1.add(kilometerJT);
		pane1.add(centimeterL);
		pane1.add(inchesL);
		pane1.add(kilometerL);
		pane1.add(meterJT);
		pane1.add(mileJT);
		pane1.add(yardJT);
		pane1.add(meterL);
		pane1.add(mileL);
		pane1.add(yardL);
		
		return pane1;
	}
	
	/**
	 * Creates the container for the energy tab.
	 * 
	 * @return	the container for the energy tab
	 */
	public Container EnergyContainer(){
		EnergyListener eListenHartree=new EnergyListener(1);
		EnergyListener eListenJoule=new EnergyListener(2);
		EnergyListener eListenKilocalorie=new EnergyListener(3);
		EnergyListener eListenWattHour=new EnergyListener(4);
		EnergyListener eListenKilowattHour=new EnergyListener(5);
		EnergyListener eListenBTU=new EnergyListener(6);
		
		Container pane2=new Container();
		pane2.setLayout(new GridLayout(4, 3, 4, 4));
		
		hartreeJT=new JTextArea();
		hartreeJT.setFont(getFont().deriveFont(20.0f));
		hartreeJT.setLineWrap(true);
		hartreeJT.setHighlighter(null);
		hartreeJT.setText(EnergyDisplay.outHartree);
		hartreeJT.addKeyListener(eListenHartree);
		
		jouleJT=new JTextArea();
		jouleJT.setFont(getFont().deriveFont(20.0f));
		jouleJT.setLineWrap(true);
		jouleJT.setHighlighter(null);
		jouleJT.setText(EnergyDisplay.outJoule);
		jouleJT.addKeyListener(eListenJoule);
		
		kilocalorieJT=new JTextArea();
		kilocalorieJT.setFont(getFont().deriveFont(20.0f));
		kilocalorieJT.setLineWrap(true);
		kilocalorieJT.setHighlighter(null);
		kilocalorieJT.setText(EnergyDisplay.outKilocalorie);
		kilocalorieJT.addKeyListener(eListenKilocalorie);
		
		wattHourJT=new JTextArea();
		wattHourJT.setFont(getFont().deriveFont(20.0f));
		wattHourJT.setLineWrap(true);
		wattHourJT.setHighlighter(null);
		wattHourJT.setText(EnergyDisplay.outWattHour);
		wattHourJT.addKeyListener(eListenWattHour);
		
		kilowattHourJT=new JTextArea();
		kilowattHourJT.setFont(getFont().deriveFont(20.0f));
		kilowattHourJT.setLineWrap(true);
		kilowattHourJT.setHighlighter(null);
		kilowattHourJT.setText(EnergyDisplay.outKilowattHour);
		kilowattHourJT.addKeyListener(eListenKilowattHour);
		
		btuJT=new JTextArea();
		btuJT.setFont(getFont().deriveFont(20.0f));
		btuJT.setLineWrap(true);
		btuJT.setHighlighter(null);
		btuJT.setText(EnergyDisplay.outBTU);
		btuJT.addKeyListener(eListenBTU);
		
		JLabel hartreeL=new JLabel("Hartrees (Ha)");
		hartreeL.setFont(getFont().deriveFont(20.0f));
		
		JLabel jouleL=new JLabel("Joules (J)");
		jouleL.setFont(getFont().deriveFont(20.0f));
		
		JLabel kilocalorieL=new JLabel("Kilocalories (Cal)");
		kilocalorieL.setFont(getFont().deriveFont(20.0f));
		
		JLabel wattHourL=new JLabel("Watt Hours (Wh)");
		wattHourL.setFont(getFont().deriveFont(20.0f));
		
		JLabel kilowattHourL=new JLabel("Kilowatt Hours (kWh)");
		kilowattHourL.setFont(getFont().deriveFont(20.0f));
		
		JLabel btuL=new JLabel("British Thermal Units (BTU)");
		btuL.setFont(getFont().deriveFont(20.0f));
	
		pane2.add(btuJT);
		pane2.add(hartreeJT);
		pane2.add(jouleJT);
		pane2.add(btuL);
		pane2.add(hartreeL);
		pane2.add(jouleL);
		pane2.add(kilocalorieJT);
		pane2.add(kilowattHourJT);
		pane2.add(wattHourJT);
		pane2.add(kilocalorieL);
		pane2.add(kilowattHourL);
		pane2.add(wattHourL);
		
		return pane2;
	}
	
	public static void main(String[] args){
		JFrame frame=new JFrame("Unit Converter");
		
		frame.getContentPane().add(new GUI(), BorderLayout.CENTER);
		frame.setSize(800, 215);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		OptionDisplay.displayWelcomeMessage();
	}
}
