package com.omnm.sale.DAO;

import com.omnm.sale.Entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDao extends JpaRepository<Sale, Integer> {

}