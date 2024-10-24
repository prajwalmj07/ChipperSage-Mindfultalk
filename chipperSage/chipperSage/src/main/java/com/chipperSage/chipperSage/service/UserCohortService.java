package com.chipperSage.chipperSage.service;

import java.util.List;

public interface UserCohortService {
    List<Object[]> getUserCohortWithProgram(int programId, int cohortId);
    List<Object[]> getStudentScoresByCohort(int cohortId);
    List<Object[]> getStudentProgressByProgram(int programId);

}
