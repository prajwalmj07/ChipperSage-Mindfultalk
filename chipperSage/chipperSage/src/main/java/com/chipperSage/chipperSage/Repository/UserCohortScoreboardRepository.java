package com.chipperSage.chipperSage.Repository;

import com.chipperSage.chipperSage.Model.UserCohortScoreboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCohortScoreboardRepository extends JpaRepository<UserCohortScoreboard, Integer> {

}
