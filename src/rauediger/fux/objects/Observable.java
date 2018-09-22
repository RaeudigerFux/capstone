package rauediger.fux.objects;

import rauediger.fux.models.Observer;
import rauediger.fux.starter.Game.EVENTS;

public interface Observable {

	void attachObserver(Observer observer);

	void detachObserver(Observer observer);

	void notifyAllOberservers(Enum<EVENTS> event);
}
