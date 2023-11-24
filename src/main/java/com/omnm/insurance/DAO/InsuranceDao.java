package com.omnm.insurance.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.omnm.insurance.Entity.Insurance;

@Repository
public interface InsuranceDao extends JpaRepository<Insurance, Integer> {
	@Query("SELECT r FROM Insurance r WHERE r.id = :insuranceId")
	Insurance findById(String insuranceId);
}