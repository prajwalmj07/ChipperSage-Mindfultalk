package com.chipperSage.chipperSage.Repository;

import com.chipperSage.chipperSage.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
