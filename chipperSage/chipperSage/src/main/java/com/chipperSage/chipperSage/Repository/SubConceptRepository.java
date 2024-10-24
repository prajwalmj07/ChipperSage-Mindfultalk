package com.chipperSage.chipperSage.Repository;

import com.chipperSage.chipperSage.Model.SubConcept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubConceptRepository extends JpaRepository<SubConcept, Integer> {
}
