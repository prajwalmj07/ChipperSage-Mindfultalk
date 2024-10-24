package com.chipperSage.chipperSage.Model;

import jakarta.persistence.*;

@Entity
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stageId;

    @ManyToOne
    @JoinColumn(name = "programId")
    private Program program;

    private String stageName;
    private String stageDesc;

    public Stage() {
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getStageDesc() {
        return stageDesc;
    }

    public void setStageDesc(String stageDesc) {
        this.stageDesc = stageDesc;
    }
}
