package org.tenbit.reduc;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface Observer {

	public void updateKey(KeyEvent keyEvent);
	public void updateMouse(MouseEvent mouseEvent);
	public void updateClick(MouseEvent mouseEvent); 
}
