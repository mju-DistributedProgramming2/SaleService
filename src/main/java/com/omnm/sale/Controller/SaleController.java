package com.omnm.sale.Controller;

import com.omnm.sale.Entity.Sale;
import com.omnm.sale.Service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;

@RestController
public class SaleController {
    @Autowired
    SaleService saleService;
    @PostMapping("/offer")
    public ResponseEntity<Integer> postSale(@RequestBody HashMap<String, String> param) {
        String saleEmployeeId = param.get("saleEmployeeId");
        String customerId = param.get("customerId");
        Integer insuranceId = Integer.valueOf(param.get("insuranceId"));
        String message = param.get("message");
        return this.saleService.postSale(saleEmployeeId, customerId, insuranceId, message);
    }
    @GetMapping("/list/sales")
    public ResponseEntity<List<Sale>> getSaleListByCustomerId(@Param("customerId") String customerId) {
        return this.saleService.getSaleListByCustomerId(customerId);
    }
}
