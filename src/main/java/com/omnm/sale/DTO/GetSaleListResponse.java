package com.omnm.sale.DTO;

import com.omnm.sale.Entity.Sale;
import java.util.List;

public class GetSaleListResponse {
    List<Sale> saleList;
    public GetSaleListResponse(List<Sale> saleList) {
        this.saleList = saleList;
    }
}
