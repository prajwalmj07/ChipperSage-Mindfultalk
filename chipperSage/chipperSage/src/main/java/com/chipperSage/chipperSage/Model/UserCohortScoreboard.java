package com.chipperSage.chipperSage.Model;

import jakarta.persistence.*;

@Entity
public class UserCohortScoreboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leaderboardId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cohortId")
    private Cohort cohort;

    private int totalScore;

    public UserCohortScoreboard() {
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public Cohort getCohort() {
        return cohort;
    }

    public void setCohort(Cohort cohort) {
        this.cohort = cohort;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getLeaderboardId() {
        return leaderboardId;
    }

    public void setLeaderboardId(int leaderboardId) {
        this.leaderboardId = leaderboardId;
    }
}
