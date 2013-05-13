package org.tenbit.reduc;

import javax.swing.JFrame;
import java.awt.Component;
import java.lang.System;

public class Boot extends JFrame {
	
	private int WIDTH = 800;
	private int HEIGHT = 600;

	public Boot() {
		super("Boot"); 
        
        setSize(WIDTH, HEIGHT);
        Reduc rc = new Reduc(this);
        ((Component)rc).setFocusable(true);
        System.out.println("Hello World! (:");
        
        
        getContentPane().add( rc );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true); 
		
	}
	
	public static void main(String[] args) {
		Boot run = new Boot();
	}
}
