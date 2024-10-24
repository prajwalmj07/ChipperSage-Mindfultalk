package com.chipperSage.chipperSage.Model;

import jakarta.persistence.*;

@Entity
public class CohortProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cohortProgramId;

    @ManyToOne
    @JoinColumn(name = "cohortId")
    private Cohort cohort;

    @ManyToOne
    @JoinColumn(name = "programId")
    private Program program;

    public CohortProgram() {
    }

    public int getCohortProgramId() {
        return cohortProgramId;
    }

    public void setCohortProgramId(int cohortProgramId) {
        this.cohortProgramId = cohortProgramId;
    }

    public Cohort getCohort() {
        return cohort;
    }

    public void setCohort(Cohort cohort) {
        this.cohort = cohort;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
