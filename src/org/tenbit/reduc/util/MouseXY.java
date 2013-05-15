package org.tenbit.reduc.util;

import java.awt.event.*;

public class MouseXY {
	private MouseEvent mouse;
	private int x;
	private int y;
	
	public MouseXY() {
		x = -1;
		y = -1;
	}
	
	public MouseXY(MouseEvent e) {
		mouse = e;
		x = mouse.getX();
		y = mouse.getY();
	}
	//Returns the X coordinate of the mouse
	public int getX() {
		return x;
	}
	//Returns the Y coordinate of the mouse
	public int getY() {
		return y;		
	}

}
