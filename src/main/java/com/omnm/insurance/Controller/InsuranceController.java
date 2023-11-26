package com.omnm.insurance.Controller;


import com.omnm.insurance.DTO.*;
import com.omnm.insurance.Entity.Insurance;
import com.omnm.insurance.enumeration.insurance.InsuranceStatus;
import com.omnm.insurance.enumeration.insurance.InsuranceType;
import com.omnm.insurance.exception.DataDuplicationException;
import com.omnm.insurance.exception.EmptyListException;
import com.omnm.insurance.exception.NoDataException;
import com.omnm.insurance.exception.TimeDelayException;
import com.omnm.insurance.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.RemoteException;

@RestController
public class InsuranceController {
    @Autowired
    InsuranceService insuranceService;

    @GetMapping("/list/insurances")
    public GetInsuranceListResponse getInsuranceList() throws RemoteException, TimeDelayException, EmptyListException {
        return new GetInsuranceListResponse(this.insuranceService.getInsuranceList());
    }
    @GetMapping("/list/insurances-by-status")
    public GetInsuranceListResponse getInsuranceList(@RequestBody InsuranceStatus insuranceStatus) throws RemoteException, EmptyListException, TimeDelayException {
        return new GetInsuranceListResponse(this.insuranceService.getInsuranceList(insuranceStatus));
    }
    @GetMapping("/list/insurances-by-type")
    public GetInsuranceListResponse getInsuranceList(@RequestBody InsuranceType type, InsuranceStatus status) throws RemoteException, EmptyListException, TimeDelayException {
        return new GetInsuranceListResponse(this.insuranceService.getInsuranceList(type, status));
    }
    @GetMapping("/insurances")
    public GetInsuranceResponse getInsurance(int selectedInsuranceId) throws RemoteException, NoDataException {
        return new GetInsuranceResponse(this.insuranceService.getInsurance(selectedInsuranceId));
    }

    @PostMapping("/insurances")
    public MakeInsuranceResponse makeInsurance(@RequestBody Insurance insurance) throws RemoteException, DataDuplicationException {
        return new MakeInsuranceResponse(this.insuranceService.makeInsurance(insurance));
    }
    @PostMapping("/authorization")
    public ExamineAuthorizationResponse examineAuthorization(int id, InsuranceStatus status) throws RemoteException, NoDataException {
        return new ExamineAuthorizationResponse(this.insuranceService.examineAuthorization(id, status));
    }

    @GetMapping("/check-name")
    public CheckNameDuplicationResponse checkNameDuplication(String name) throws RemoteException, DataDuplicationException {
        return new CheckNameDuplicationResponse(this.insuranceService.checkNameDuplication(name));
    }
}
