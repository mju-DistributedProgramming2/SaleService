package com.omnm.insurance.DTO;

import com.omnm.insurance.Entity.Insurance;

import java.util.List;

public class GetInsuranceListResponse {
    List<Insurance> insuranceList;
    public GetInsuranceListResponse(List<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }
    public List<Insurance> getInsuranceList() {
        return  this.insuranceList;
    }
}
