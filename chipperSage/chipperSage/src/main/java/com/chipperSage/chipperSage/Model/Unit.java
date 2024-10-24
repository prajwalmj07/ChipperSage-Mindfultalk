package com.chipperSage.chipperSage.Model;

import jakarta.persistence.*;

@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unitId;

    @ManyToOne
    @JoinColumn(name = "programId")
    private Program program;

    @ManyToOne
    @JoinColumn(name = "stageId")
    private Stage stage;

    private String unitName;
    private String unitDesc;

    public Unit() {
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }
}
