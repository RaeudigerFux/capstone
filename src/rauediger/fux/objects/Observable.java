package rauediger.fux.objects;

import rauediger.fux.models.Observer;

public interface Observable {
	void attachObserver(Observer observer);
	void detachObserver(Observer observer);
	void notifyAllOberservers();
}
