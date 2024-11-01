package com.chipperSage.chipperSage.Repository;

import com.chipperSage.chipperSage.Model.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, Integer> {
}
