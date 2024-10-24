package com.chipperSage.chipperSage.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Cohort {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cohortId;

    @ManyToOne
    @JoinColumn(name = "orgId")
    private Organisation organisation;

    private String cohortName;
    private Date cohortStartDate;
    private Date cohortEndDate;
}
