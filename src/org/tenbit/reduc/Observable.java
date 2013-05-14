package org.tenbit.reduc;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface Observable {

	public void notifyObserversKey(KeyEvent keyevent);
	public void notifyObserversMouse(MouseEvent mouseEvent);
	void notifyObserversClick(MouseEvent mouseEvent);

}
