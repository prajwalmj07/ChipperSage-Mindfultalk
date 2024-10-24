package com.chipperSage.chipperSage.Repository;

import com.chipperSage.chipperSage.Model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, Integer> {
}
