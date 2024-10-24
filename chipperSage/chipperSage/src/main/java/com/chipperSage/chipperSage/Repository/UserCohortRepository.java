package com.chipperSage.chipperSage.Repository;

import com.chipperSage.chipperSage.Model.UserCohort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCohortRepository extends JpaRepository<UserCohort, Integer> {
    @Query("SELECT uc.user.id, c.cohortName, c.cohortStartDate, c.cohortEndDate, cp.program.id " +
            "FROM UserCohort uc " +
            "JOIN Cohort c ON uc.cohort.cohortId = c.cohortId " +
            "JOIN CohortProgram cp ON c.cohortId = cp.cohort.cohortId " +
            "WHERE cp.program.id = :programId " +
            "AND uc.cohort.cohortId = :cohortId")
    List<Object[]>findUserCohortWithProgram(@Param("programId") int programId, @Param("cohortId") int cohortId);

    @Query("SELECT u.id, u.userName, c.cohortName, sc.subConceptDesc, ua.attemptScore " +
            "FROM User u " +
            "JOIN UserCohort uc ON u.id = uc.user.id " +
            "JOIN Cohort c ON uc.cohort.cohortId = c.cohortId " +
            "JOIN CohortProgram cp ON c.cohortId = cp.cohort.cohortId " +
            "JOIN UserAttempts ua ON u.id = ua.user.id " +
            "JOIN SubConcept sc ON ua.subConcept.subConceptId = sc.subConceptId " +
            "WHERE c.cohortId = :cohortId")
    List<Object[]> findStudentScoresByCohort(@Param("cohortId") int cohortId);
    @Query("SELECT u.id, u.userName, p.programName, " +
            "COUNT(usc.subConcept.subConceptId) AS completedSubConcepts, " +
            "COUNT(sc.subConceptId) AS totalSubConcepts, " +
            "(COUNT(usc.subConcept.subConceptId) / COUNT(sc.subConceptId)) * 100 AS progressPercentage " +
            "FROM User u " +
            "JOIN UserCohort uc ON u.id = uc.user.id " +
            "JOIN CohortProgram cp ON uc.cohort.cohortId = cp.cohort.cohortId " +
            "JOIN Program p ON cp.program.programId = p.programId " +
            "JOIN ProgramSubConcept ps ON p.programId = ps.program.programId " +
            "JOIN SubConcept sc ON ps.subConcept.subConceptId = sc.subConceptId " +
            "LEFT JOIN UserSubConceptCompletion usc ON u.id = usc.user.id AND usc.subConcept.subConceptId = sc.subConceptId " +
            "WHERE p.programId = :programId " +
            "GROUP BY u.id, p.programName")
    List<Object[]> findStudentProgressByProgram(@Param("programId") int programId);


}
