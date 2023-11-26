package com.omnm.insurance.DAO;

import com.omnm.insurance.enumeration.insurance.InsuranceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omnm.insurance.Entity.Insurance;

import java.util.List;

@Repository
public interface InsuranceDao extends JpaRepository<Insurance, Integer> {
	Insurance findById(int insuranceId);
	Insurance findByName(String name);
	List<Insurance> findByStatus(InsuranceStatus status);
}