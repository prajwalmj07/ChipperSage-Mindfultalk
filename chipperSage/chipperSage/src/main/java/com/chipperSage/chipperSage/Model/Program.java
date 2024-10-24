package com.chipperSage.chipperSage.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int programId;
    private String programName;
    private String programDesc;
    private String units;
    private String stages;

    public Program() {
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getStages() {
        return stages;
    }

    public void setStages(String stages) {
        this.stages = stages;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getProgramDesc() {
        return programDesc;
    }

    public void setProgramDesc(String programDesc) {
        this.programDesc = programDesc;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
}
