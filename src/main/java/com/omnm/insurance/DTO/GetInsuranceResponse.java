package com.omnm.insurance.DTO;

import com.omnm.insurance.Entity.Insurance;

public class GetInsuranceResponse {
    Insurance insurance;
    public GetInsuranceResponse(Insurance insurance) {
        this.insurance = insurance;
    }
    public Insurance getInsuranceList() {
        return  this.insurance;
    }
}
