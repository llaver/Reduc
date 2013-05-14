package org.tenbit.reduc;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

public class Setup implements KeyListener, MouseListener, MouseMotionListener, Observable
{
   private ArrayList<Observer> obsList;

   public Setup() {
      obsList = new ArrayList();
   }

   public void keyPressed(KeyEvent e) {
      notifyObserversKey(e);
   }

   public void keyReleased(KeyEvent e) {
	   //notifyObserversKey(e);
   }
   public void keyTyped(KeyEvent e) {
	   notifyObserversKey(e);
   }
   
   public void mouseClicked(MouseEvent e) {
	   notifyObserversClick(e);
   }
   public void mouseDragged(MouseEvent e) {
	   notifyObserversMouse(e);
   }
   public void mouseMoved(MouseEvent e) {
	   notifyObserversMouse(e);
   }
   public void mouseEntered(MouseEvent e) {
	   notifyObserversMouse(e);
   }
   public void mouseExited(MouseEvent e) {
	   notifyObserversMouse(e);
   }
   public void mousePressed(MouseEvent e) {
	   notifyObserversClick(e);
   }
   public void mouseReleased(MouseEvent e) {
	   notifyObserversMouse(e);
   }

   public void notifyObserversKey(KeyEvent keyEvent)
   {
       for(Observer obs : obsList)
       {
           obs.updateKey(keyEvent);
       }
   }
   
   @Override
   public void notifyObserversMouse(MouseEvent mouseEvent) {
	   for(Observer obs : obsList)
       {
           obs.updateMouse(mouseEvent);
       }
   	
   }
   @Override
   public void notifyObserversClick(MouseEvent mouseEvent) {
	   for(Observer obs : obsList)
       {
           obs.updateMouse(mouseEvent);
       }
   	
   }

   public void addObserver(Observer obs)
   {
       if (obs != null)
          obsList.add(obs);
   }

   public void delObserver(Observer obs)
   {
       if (obs != null)
          obsList.remove(obs);
   }
}