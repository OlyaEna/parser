package com.parser.model.repository;

import com.parser.model.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {

}
