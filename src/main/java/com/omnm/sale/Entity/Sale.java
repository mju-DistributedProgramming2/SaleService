package com.omnm.sale.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Sale implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "sale_employee_id", nullable = false)
    private String saleEmployeeId;
    @Column(name = "customer_id", nullable = false)
    private String customerId;
    @Column(name = "insurance_id", nullable = false)
    private int insuranceId;
    private String message;

    public Sale(String saleEmployeeId, String customerId, int insuranceId, String message) {
        this.saleEmployeeId = saleEmployeeId;
        this.customerId = customerId;
        this.insuranceId = insuranceId;
        this.message = message;
    }

    public Sale() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaleEmployeeId() {
        return saleEmployeeId;
    }

    public void setSaleEmployeeId(String saleEmployeeId) {
        this.saleEmployeeId = saleEmployeeId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
