package org.tenbit.reduc.util;

import java.lang.Object.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.*;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import org.tenbit.reduc.Observer;

import java.awt.Component;
import java.awt.Font;

public class MousePos extends MouseInputAdapter implements Observer {
	private MouseXY mMove = new MouseXY();
	private MouseXY mDrag = new MouseXY();
	private boolean isOn;
	private boolean firstPos = false; //for when the old position is first set to the new position
	public static boolean isPressed = false;
	public static int x = -1;
	public static int y = -1;
	private int oX = -1; //Old Cursor x coordinate for painting cursor
	private int oY = -1; //Old Cursor x coordinate for painting cursor
	
	
	public MousePos() {
		
	}
	public void paint(Graphics window) {
		Graphics g = window;
		Graphics2D g2 = (Graphics2D) g;
		g2.clearRect(30, 3, 30, 15);
		g2.clearRect(80, 3, 30, 15);
		//g2.clearRect(100, 15, 30, 15);
		//g2.drawImage(MenuImages.backImg, 0, 0, 800, 600, 0, 0, 1200, 800, null);
		g2.setColor(Color.RED);
		g2.drawString("X: ", 15, 15);
		g2.drawString(Integer.toString(x), 35, 15);
		g2.drawString("Y: ", 65, 15);
		g2.drawString(Integer.toString(y), 85, 15);
		}
	@Override
	public void mouseMoved(MouseEvent e) {
		if(e != null) {
			//mDrag = new MouseXY(e);
			x = e.getX();
			y = e.getY();
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(e != null) {
		mMove = new MouseXY(e);
		x = mMove.getX();
		y = mMove.getY(); 
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		isPressed = true;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e != null) {
		mMove = new MouseXY(e);
		x = mMove.getX();
		y = mMove.getY();
		if(!firstPos) {
			oX = x;
			oY = y;
			firstPos = true;
		}
		} else {
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		isPressed = false;
	}
	@Override
	public void updateKey(KeyEvent keyEvent) {
		
	}
	@Override
	public void updateMouse(MouseEvent mouseEvent) {
		mouseMoved(mouseEvent);
	}
	@Override
	public void updateClick(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}
}
