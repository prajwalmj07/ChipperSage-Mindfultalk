package com.chipperSage.chipperSage.Repository;

import com.chipperSage.chipperSage.Model.CohortProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CohortProgramRepository extends JpaRepository<CohortProgram, Integer> {
}
