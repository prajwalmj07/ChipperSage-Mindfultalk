package com.chipperSage.chipperSage.Repository;

import com.chipperSage.chipperSage.Model.UserSubConceptCompletion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSubConceptCompletionRepository extends JpaRepository<UserSubConceptCompletion, Integer> {
}
