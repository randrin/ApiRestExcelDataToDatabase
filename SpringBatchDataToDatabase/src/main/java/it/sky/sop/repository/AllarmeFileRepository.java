package it.sky.sop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.sky.sop.model.AllarmeFile;

@Repository
public interface AllarmeFileRepository extends JpaRepository<AllarmeFile, Long> {

}
