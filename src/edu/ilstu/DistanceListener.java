package edu.ilstu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Listener for the distance tab.
 * 
 * @author Christopher A Runyan
 */
public class DistanceListener implements KeyListener{
	int listener;
		
	/**
	 * Custom constructor that accepts an integer value associated with a specific listener object.
	 * 
	 * @param listener	integer value associated with a specific listener object
	 */
	public DistanceListener(int listener){
		this.listener=listener;
	}
		
	/**
	 * Empty method for key pressed event.
	 */
	@Override
	public void keyPressed(KeyEvent e) {}

	/**
	 * Empty method for key released event.
	 */
	@Override
	public void keyReleased(KeyEvent e) {}

	/**
	 * Method for key typed event refreshing the information on the distance tab.
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		DistanceDisplay.displayDistanceInfo(listener, e);
	}
}