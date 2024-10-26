package com.chipperSage.chipperSage.service;

import com.chipperSage.chipperSage.Repository.UserCohortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCohortServiceImpl implements UserCohortService {
    @Autowired
    private UserCohortRepository userCohortRepository;


    @Override
    public List<Object[]> getUserCohortWithProgram(int programId, int cohortId) {
        return userCohortRepository.findUserCohortWithProgram(programId, cohortId);
    }
    public List<Object[]> getStudentScoresByCohort(int cohortId) {
        return userCohortRepository.findStudentScoresByCohort(cohortId);
    }
    @Override
    public List<Object[]> getStudentProgressByProgram(int programId) {
        return userCohortRepository.findStudentProgressByProgram(programId);
    }
    //lines added by revankar---->
    @Override
    public List<Object[]> getCohortProgressByProgram(int programId) {
        return userCohortRepository.findCohortProgressByProgram(programId); // Ensure you call the correct repository method
    }
    @Override
    public List<Object[]> getInactiveCohortProgressByProgram(int programId) {
        return userCohortRepository.findInactiveCohortProgressByProgram(programId);
    }
    @Override
    public List<Object[]> getCohortProgressByProgramOrg(int programId) {
        return userCohortRepository.findCohortProgressByProgramOrg(programId);
    }
    //lines added by me <-----


}
