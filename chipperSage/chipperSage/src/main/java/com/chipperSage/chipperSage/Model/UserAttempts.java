package com.chipperSage.chipperSage.Model;

import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
public class UserAttempts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attemptId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "sessionId")
    private UserSession userSession;

    @ManyToOne
    @JoinColumn(name = "stageId")
    private Stage stage;

    @ManyToOne
    @JoinColumn(name = "unitId")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "subConceptId")
    private SubConcept subConcept;

    private boolean attemptedFlag;
    private int attemptScore;
    private Timestamp attemptStartTimestamp;
    private Timestamp attemptEndTimestamp;

    public UserAttempts() {
    }

    public int getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(int attemptId) {
        this.attemptId = attemptId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
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

    public boolean isAttemptedFlag() {
        return attemptedFlag;
    }

    public void setAttemptedFlag(boolean attemptedFlag) {
        this.attemptedFlag = attemptedFlag;
    }

    public int getAttemptScore() {
        return attemptScore;
    }

    public void setAttemptScore(int attemptScore) {
        this.attemptScore = attemptScore;
    }

    public Timestamp getAttemptStartTimestamp() {
        return attemptStartTimestamp;
    }

    public void setAttemptStartTimestamp(Timestamp attemptStartTimestamp) {
        this.attemptStartTimestamp = attemptStartTimestamp;
    }

    public Timestamp getAttemptEndTimestamp() {
        return attemptEndTimestamp;
    }

    public void setAttemptEndTimestamp(Timestamp attemptEndTimestamp) {
        this.attemptEndTimestamp = attemptEndTimestamp;
    }
    // Getters and Setters
}
