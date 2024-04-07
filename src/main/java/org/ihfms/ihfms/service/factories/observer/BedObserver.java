package org.ihfms.ihfms.service.factories.observer;

import java.util.List;

import org.ihfms.ihfms.entity.Bed;

public interface BedObserver {
	void updateBedStatus(Bed bed);
	void addObservers(List<?> observers);
	
	void notifyObservers(Bed bed);
}
