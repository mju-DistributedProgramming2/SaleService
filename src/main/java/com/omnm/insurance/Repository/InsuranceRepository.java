package com.omnm.insurance.Repository;

import com.omnm.insurance.Entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Integer> {

}
