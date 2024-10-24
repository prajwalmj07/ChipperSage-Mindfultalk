package com.chipperSage.chipperSage.Repository;

import com.chipperSage.chipperSage.Model.ProgramSubConcept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramSubConceptRepository extends JpaRepository<ProgramSubConcept, Integer> {
}
