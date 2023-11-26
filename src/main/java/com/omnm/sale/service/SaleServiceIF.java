package com.omnm.sale.service;

import com.omnm.sale.Entity.Sale;
import com.omnm.sale.exception.EmptyListException;
import com.omnm.sale.exception.TimeDelayException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface SaleServiceIF  extends Remote {
    int offerInsurance(String saleEmployeeId, String customerId, int insuranceId, String message) throws RemoteException;
    List<Sale> getSaleList(String customerId) throws RemoteException, EmptyListException, TimeDelayException;
}
