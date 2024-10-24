package com.chipperSage.chipperSage.Model;

import jakarta.persistence.*;

@Entity
public class Concept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int conceptId;


    @ManyToOne
    @JoinColumn(name = "contentMasterId")
    private ContentMaster contentMaster;

    private String conceptName;
    private String conceptDesc;
    private String conceptSkill1;
    private String conceptSkill2;
    public Concept() {
    }

    public int getConceptId() {
        return conceptId;
    }

    public void setConceptId(int conceptId) {
        this.conceptId = conceptId;
    }

    public ContentMaster getContentMaster() {
        return contentMaster;
    }

    public void setContentMaster(ContentMaster contentMaster) {
        this.contentMaster = contentMaster;
    }

    public String getConceptName() {
        return conceptName;
    }

    public void setConceptName(String conceptName) {
        this.conceptName = conceptName;
    }

    public String getConceptDesc() {
        return conceptDesc;
    }

    public void setConceptDesc(String conceptDesc) {
        this.conceptDesc = conceptDesc;
    }

    public String getConceptSkill1() {
        return conceptSkill1;
    }

    public void setConceptSkill1(String conceptSkill1) {
        this.conceptSkill1 = conceptSkill1;
    }

    public String getConceptSkill2() {
        return conceptSkill2;
    }

    public void setConceptSkill2(String conceptSkill2) {
        this.conceptSkill2 = conceptSkill2;
    }
}
