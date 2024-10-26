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
    //lines added by revankar
    @Query(value = "SELECT c.cohort_name, u.user_id, u.user_name, " +
            "COUNT(usc.sub_concept_id) AS completed_sub_concepts, " +
            "COUNT(sc.sub_concept_id) AS total_sub_concepts, " +
            "(COUNT(usc.sub_concept_id) / COUNT(sc.sub_concept_id)) * 100 AS progress_percentage, " +
            "CASE WHEN MAX(us.session_end_timestamp) >= NOW() - INTERVAL 1 MONTH THEN 'Active' ELSE 'Inactive' END AS user_status " +
            "FROM user u " +
            "JOIN user_cohort uc ON u.user_id = uc.user_id " +
            "JOIN cohort c ON uc.cohort_id = c.cohort_id " +
            "JOIN cohort_program cp ON c.cohort_id = cp.cohort_id " +
            "JOIN program p ON cp.program_id = p.program_id " +
            "JOIN program_sub_concept ps ON p.program_id = ps.program_id " +
            "JOIN sub_concept sc ON ps.sub_concept_id = sc.sub_concept_id " +
            "LEFT JOIN user_sub_concept_completion usc ON u.user_id = usc.user_id AND usc.sub_concept_id = sc.sub_concept_id " +
            "LEFT JOIN user_session us ON u.user_id = us.user_id " +
            "WHERE p.program_id = :programId " +
            "GROUP BY c.cohort_name, u.user_id " +
            "HAVING user_status = 'Active'", nativeQuery = true)
    List<Object[]> findCohortProgressByProgram(@Param("programId") int programId);

    @Query(value = "SELECT c.cohort_name, u.user_id, u.user_name, " +
            "COUNT(usc.sub_concept_id) AS completed_sub_concepts, " +
            "COUNT(sc.sub_concept_id) AS total_sub_concepts, " +
            "(COUNT(usc.sub_concept_id) * 1.0 / COUNT(sc.sub_concept_id)) * 100 AS progress_percentage, " +
            "'Inactive' AS user_status " +
            "FROM user u " +
            "JOIN user_cohort uc ON u.user_id = uc.user_id " +
            "JOIN cohort c ON uc.cohort_id = c.cohort_id " +
            "JOIN cohort_program cp ON c.cohort_id = cp.cohort_id " +
            "JOIN program p ON cp.program_id = p.program_id " +
            "JOIN program_subconcept ps ON p.program_id = ps.program_id " +
            "JOIN sub_concept sc ON ps.sub_concept_id = sc.sub_concept_id " +
            "LEFT JOIN user_subconcept_completion usc ON u.user_id = usc.user_id AND usc.sub_concept_id = sc.sub_concept_id " +
            "LEFT JOIN user_session us ON u.user_id = us.user_id " +
            "WHERE p.program_id = :programId " +
            "GROUP BY c.cohort_name, u.user_id, u.user_name " +
            "HAVING MAX(us.session_end_timestamp) < CURRENT_DATE - INTERVAL 30 DAY OR MAX(us.session_end_timestamp) IS NULL",
            nativeQuery = true)
    List<Object[]> findInactiveCohortProgressByProgram(@Param("programId") int programId);

    @Query(value = "SELECT c.cohort_name, u.user_id, u.user_name, " +
            "COUNT(usc.sub_concept_id) AS completed_sub_concepts, " +
            "COUNT(sc.sub_concept_id) AS total_sub_concepts, " +
            "(COUNT(usc.sub_concept_id) * 100.0 / COUNT(sc.sub_concept_id)) AS completion_percentage " +
            "FROM user u " +
            "JOIN user_cohort uc ON u.user_id = uc.user_id " +
            "JOIN cohort c ON uc.cohort_id = c.cohort_id " +
            "JOIN cohort_program cp ON c.cohort_id = cp.cohort_id " +
            "JOIN program p ON cp.program_id = p.program_id " +
            "JOIN program_subconcept ps ON p.program_id = ps.program_id " +
            "JOIN sub_concept sc ON ps.sub_concept_id = sc.sub_concept_id " +
            "LEFT JOIN user_subconcept_completion usc ON u.user_id = usc.user_id AND usc.sub_concept_id = sc.sub_concept_id " +
            "WHERE p.program_id = :programId " +
            "GROUP BY c.cohort_name, u.user_id " +
            "ORDER BY c.cohort_name, u.user_id",
            nativeQuery = true)
    List<Object[]> findCohortProgressByProgramOrg(@Param("programId") int programId);
    //lines added by revankar

}
