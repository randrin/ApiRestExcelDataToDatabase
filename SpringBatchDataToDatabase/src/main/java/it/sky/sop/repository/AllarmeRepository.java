package it.sky.sop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.sky.sop.model.Allarme;

@Repository
public interface AllarmeRepository extends JpaRepository<Allarme, Long>{

}
