package org.ihfms.ihfms.service.factories.observer;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.ihfms.ihfms.entity.Bed;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BedObserverImpl implements BedObserver{
	
	@Override
	public void updateBedStatus(Bed bed) {
	
	}
	
	@Override
	public void addObservers(List<?> observers) {
	
	}
	
	@Override
	public void notifyObservers(Bed bed) {
//		recordsDepartmentObserver.updateBedStatus(bed);
//		financeDepartmentObserver.updateBedStatus(bed);
	}
}
