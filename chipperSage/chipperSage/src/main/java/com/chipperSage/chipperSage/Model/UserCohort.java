package com.chipperSage.chipperSage.Model;

import jakarta.persistence.*;

@Entity
public class UserCohort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userCohortId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cohortId")
    private Cohort cohort;

    public UserCohort() {
    }

    public int getUserCohortId() {
        return userCohortId;
    }

    public void setUserCohortId(int userCohortId) {
        this.userCohortId = userCohortId;
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
}
