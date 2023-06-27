package com.parser.model.repository;

import com.parser.model.entity.Tourney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TourneyRepository extends JpaRepository<Tourney, Long> {
    @Query(value = "select * from tourney t where t.information_id=(select max(information_id) from tourney)", nativeQuery = true)
    List<Tourney> findByTheLastInsert();

    @Query(value = "select * from tourney t where  t.information_id=(select max(information_id) from tourney) and t.sport_id=:id ", nativeQuery = true)
    List<Tourney> findTourneyBySportId(Long id);
    @Query(value = "select * from tourney t where t.sport_id=( SELECT sport_id FROM tourney w where w.id=:id) and information_id=(select max(information_id) from tourney)", nativeQuery = true)
    List<Tourney> findTourneysById(Long id);


}
