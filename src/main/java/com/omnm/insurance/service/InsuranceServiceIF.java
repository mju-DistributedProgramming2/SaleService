package com.omnm.insurance.service;

import com.omnm.insurance.enumeration.insurance.InsuranceType;
import com.omnm.insurance.enumeration.insurance.InsuranceStatus;
import com.omnm.insurance.Entity.Insurance;
import com.omnm.insurance.exception.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InsuranceServiceIF  extends Remote {
    List<Insurance> getInsuranceList(InsuranceStatus insuranceStatus) throws RemoteException, EmptyListException, TimeDelayException;

    List<Insurance> getInsuranceList(InsuranceType type, InsuranceStatus status) throws RemoteException, EmptyListException, TimeDelayException;

    Insurance getInsurance(int selectedInsuranceId) throws RemoteException, NoDataException;

    List<Insurance> getInsuranceList() throws RemoteException, EmptyListException, TimeDelayException;

    int makeInsurance(Insurance insurance) throws RemoteException, DataDuplicationException;

    boolean examineAuthorization(int id, InsuranceStatus status) throws RemoteException, NoDataException;

    boolean checkNameDuplication(String name) throws DataDuplicationException, RemoteException;
}
