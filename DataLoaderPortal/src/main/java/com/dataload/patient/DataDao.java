package com.dataload.patient;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dataload.constants.DataBaseConstants;
import com.dataload.models.UserDetails;

@Repository
public interface DataDao extends JpaRepository<UserDetails, Integer> {

	@Query(value = "SELECT * FROM " + DataBaseConstants.DATABASE_NAME + "." + DataBaseConstants.USER_DATA
			+ " where patient_name like :patientName% ORDER BY patient_name", nativeQuery = true)
	Optional<List<UserDetails>> searchByName(String patientName);

}
