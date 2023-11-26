package com.omnm.sale.service;

import com.omnm.sale.DAO.SaleDao;
import com.omnm.sale.Entity.Sale;
import com.omnm.sale.exception.EmptyListException;
import com.omnm.sale.exception.TimeDelayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService implements SaleServiceIF {
    @Autowired
    SaleDao saleDao;
    @Override
    public int offerInsurance(String saleEmployeeId, String customerId, int insuranceId, String message) throws RemoteException {
        Sale sale = new Sale(saleEmployeeId, customerId, insuranceId, message);
        saleDao.save(sale);
        return sale.getId();
    }
    @Override
    public List<Sale> getSaleList(String customerId) throws RemoteException, EmptyListException, TimeDelayException {
        long beforeTime = System.currentTimeMillis();
        List<Sale> saleList = new ArrayList<>();
        for(Sale sale : this.saleDao.findAll()){
            if(sale.getCustomerId().equals(customerId)) {
                saleList.add(sale);
            }
        }
        if(saleList.isEmpty()) throw new EmptyListException("! 목록이 존재하지 않습니다.");
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        if(secDiffTime>=7) throw new TimeDelayException("! 시스템에 오류가 발생했습니다. 다시 시도해주세요.");
        return saleList;
    }
}
