package com.chipperSage.chipperSage.Repository;

import com.chipperSage.chipperSage.Model.Concept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptRepository extends JpaRepository<Concept, Integer> {
}
