package com.chipperSage.chipperSage.Model;

import jakarta.persistence.*;

@Entity
public class UserSubConceptCompletion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userSubConceptId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

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

    public UserSubConceptCompletion() {
    }

    public int getUserSubConceptId() {
        return userSubConceptId;
    }

    public void setUserSubConceptId(int userSubConceptId) {
        this.userSubConceptId = userSubConceptId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
