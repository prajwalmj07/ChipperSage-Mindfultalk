package com.chipperSage.chipperSage.Model;

import jakarta.persistence.*;

@Entity
public class ProgramSubConcept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int programSubConceptId;

    @ManyToOne
    @JoinColumn(name = "programId")
    private Program program;

    @ManyToOne
    @JoinColumn(name = "stageId")
    private Stage stage;

    @ManyToOne
    @JoinColumn(name = "unitId")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "subConceptId")
    private SubConcept subConcept;

    private int subConceptMaxScore;

    public ProgramSubConcept() {
    }

    public int getProgramSubConceptId() {
        return programSubConceptId;
    }

    public void setProgramSubConceptId(int programSubConceptId) {
        this.programSubConceptId = programSubConceptId;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public SubConcept getSubConcept() {
        return subConcept;
    }

    public void setSubConcept(SubConcept subConcept) {
        this.subConcept = subConcept;
    }

    public int getSubConceptMaxScore() {
        return subConceptMaxScore;
    }

    public void setSubConceptMaxScore(int subConceptMaxScore) {
        this.subConceptMaxScore = subConceptMaxScore;
    }
}
