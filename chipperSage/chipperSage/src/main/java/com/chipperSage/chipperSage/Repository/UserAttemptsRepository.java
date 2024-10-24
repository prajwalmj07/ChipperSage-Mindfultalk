package com.chipperSage.chipperSage.Repository;

import com.chipperSage.chipperSage.Model.UserAttempts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAttemptsRepository extends JpaRepository<UserAttempts, Integer> {
}
