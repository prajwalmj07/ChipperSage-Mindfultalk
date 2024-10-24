package com.chipperSage.chipperSage.Model;

import jakarta.persistence.*;

@Entity
public class SubConcept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subConceptId;

    @ManyToOne
    @JoinColumn(name = "contentMasterId")
    private ContentMaster contentMaster;

    @ManyToOne
    @JoinColumn(name = "conceptId")
    private Concept concept;

    private String subConceptDesc;
    private String subConceptType;
    private String subConceptGroup;
    private String dependency;
    private String subConceptDesc2;
    private int numberOfQs;
    private String subConceptLink;

    public SubConcept() {
    }

    public int getSubConceptId() {
        return subConceptId;
    }

    public void setSubConceptId(int subConceptId) {
        this.subConceptId = subConceptId;
    }

    public ContentMaster getContentMaster() {
        return contentMaster;
    }

    public void setContentMaster(ContentMaster contentMaster) {
        this.contentMaster = contentMaster;
    }

    public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    public String getSubConceptDesc() {
        return subConceptDesc;
    }

    public void setSubConceptDesc(String subConceptDesc) {
        this.subConceptDesc = subConceptDesc;
    }

    public String getSubConceptType() {
        return subConceptType;
    }

    public void setSubConceptType(String subConceptType) {
        this.subConceptType = subConceptType;
    }

    public String getSubConceptGroup() {
        return subConceptGroup;
    }

    public void setSubConceptGroup(String subConceptGroup) {
        this.subConceptGroup = subConceptGroup;
    }

    public String getDependency() {
        return dependency;
    }

    public void setDependency(String dependency) {
        this.dependency = dependency;
    }

    public String getSubConceptDesc2() {
        return subConceptDesc2;
    }

    public void setSubConceptDesc2(String subConceptDesc2) {
        this.subConceptDesc2 = subConceptDesc2;
    }

    public int getNumberOfQs() {
        return numberOfQs;
    }

    public void setNumberOfQs(int numberOfQs) {
        this.numberOfQs = numberOfQs;
    }

    public String getSubConceptLink() {
        return subConceptLink;
    }

    public void setSubConceptLink(String subConceptLink) {
        this.subConceptLink = subConceptLink;
    }
}
