package com.parser.model.repository;

import com.parser.model.entity.Tourney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourneyRepository extends JpaRepository<Tourney, Long> {
}
