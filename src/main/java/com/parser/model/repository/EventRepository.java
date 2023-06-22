package com.parser.model.repository;

import com.parser.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query(value = "select * from event t where t.tourney_id=:id ", nativeQuery = true)
    List<Event> findAllEventsByTourney(Long id);
}
