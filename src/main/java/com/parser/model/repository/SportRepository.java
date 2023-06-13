package com.parser.model.repository;

import com.parser.model.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {
//    @Query(value = "select s.name from Sport s")
//    List<String> findAllSportNames();

    Boolean existsSportByName(String name);
}
