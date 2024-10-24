package com.chipperSage.chipperSage.Repository;

import com.chipperSage.chipperSage.Model.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
}
