package com.omnm.sale.Controller;



import com.omnm.sale.DTO.GetSaleListResponse;
import com.omnm.sale.DTO.OfferInsuranceResponse;
import com.omnm.sale.Entity.Sale;
import com.omnm.sale.exception.EmptyListException;
import com.omnm.sale.exception.TimeDelayException;
import com.omnm.sale.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.RemoteException;
import java.util.ArrayList;

@RestController
public class SaleController {
    @Autowired
    SaleService saleService;
    @PostMapping("/offer")
    public OfferInsuranceResponse offerInsurance(String saleEmployeeId, String customerId, int insuranceId, String message) throws RemoteException {
        return new OfferInsuranceResponse(saleService.offerInsurance(saleEmployeeId, customerId, insuranceId, message));
    }
    @GetMapping("/list/sales")
    public GetSaleListResponse getSaleList(String customerId) throws RemoteException, EmptyListException, TimeDelayException {
        return new GetSaleListResponse(saleService.getSaleList(customerId));
    }
}
