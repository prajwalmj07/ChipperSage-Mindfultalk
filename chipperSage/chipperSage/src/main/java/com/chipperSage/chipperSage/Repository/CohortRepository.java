package com.chipperSage.chipperSage.Repository;

import com.chipperSage.chipperSage.Model.Cohort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CohortRepository extends JpaRepository<Cohort, Integer> {
}
