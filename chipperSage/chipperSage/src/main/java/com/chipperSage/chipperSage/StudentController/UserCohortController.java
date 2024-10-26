package com.chipperSage.chipperSage.StudentController;

import com.chipperSage.chipperSage.service.UserCohortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userCohort")
@CrossOrigin
public class UserCohortController {
    @Autowired
    private UserCohortService userCohortService;

    @GetMapping("/findUserCohortWithProgram")
    public List<Object[]> findUserCohortWithProgram(@RequestParam int programId, @RequestParam int cohortId) {
        return userCohortService.getUserCohortWithProgram(programId, cohortId);
    }
    @GetMapping("/getStudentScoresByCohort")
    public List<Object[]> getStudentScoresByCohort(@RequestParam int cohortId) {
        return userCohortService.getStudentScoresByCohort(cohortId);
    }

    @GetMapping("/getStudentProgressByProgram")
    public List<Object[]> getStudentProgressByProgram(@RequestParam int programId) {
        return userCohortService.getStudentProgressByProgram(programId);
    }
    //lines added by revankar
    @GetMapping("/getCohortProgressByProgram")
    public List<Object[]> getCohortProgressByProgram(@RequestParam int programId) {
        return userCohortService.getCohortProgressByProgram(programId);
    }
    @GetMapping("/getInactiveCohortProgressByProgram")
    public List<Object[]> getInactiveCohortProgressByProgram(@RequestParam int programId) {
        return userCohortService.getInactiveCohortProgressByProgram(programId);
    }
    @GetMapping("/getCohortProgressByProgramOrg")
    public List<Object[]> getCohortProgressByProgramOrg(@RequestParam int programId) {
        return userCohortService.getCohortProgressByProgramOrg(programId);
    }
    //lines added by revankar <-------


}
    