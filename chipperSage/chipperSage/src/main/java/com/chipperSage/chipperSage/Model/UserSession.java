package com.chipperSage.chipperSage.Model;

import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userSessionId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cohortId")
    private Cohort cohort;

    private Timestamp sessionStartTimestamp;
    private Timestamp sessionEndTimestamp;

    public UserSession() {
    }

    public int getUserSessionId() {
        return userSessionId;
    }

    public void setUserSessionId(int userSessionId) {
        this.userSessionId = userSessionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cohort getCohort() {
        return cohort;
    }

    public void setCohort(Cohort cohort) {
        this.cohort = cohort;
    }

    public Timestamp getSessionStartTimestamp() {
        return sessionStartTimestamp;
    }

    public void setSessionStartTimestamp(Timestamp sessionStartTimestamp) {
        this.sessionStartTimestamp = sessionStartTimestamp;
    }

    public Timestamp getSessionEndTimestamp() {
        return sessionEndTimestamp;
    }

    public void setSessionEndTimestamp(Timestamp sessionEndTimestamp) {
        this.sessionEndTimestamp = sessionEndTimestamp;
    }
}
