package org.ihfms.ihfms.repositories;

import org.ihfms.ihfms.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
	
	Room findFirstByAvailableBedsGreaterThan(int i);
}
