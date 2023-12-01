package com.omnm.sale.DAO;

import com.omnm.sale.Entity.Sale;
import com.omnm.sale.Repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaleDAO {
    @Autowired
    private SaleRepository saleRepository;
    public void createSale(Sale sale) {
//        String query ="insert into sale values ("+
//                sale.getId()+", "+
//                "'"+sale.getSaleEmployeeId()+"'"+", "+
//                "'"+sale.getCustomerId()+"'"+", "+
//                "'"+sale.getInsuranceId()+"'"+", "+
//                "'"+sale.getMessage()+"'"+
//                ");";
//        return this.create(query);
        this.saleRepository.save(sale);
    }
    public List<Sale> findSale(){
//        ArrayList<Sale> saleList = new ArrayList<Sale>();
//        String query = "select * from sale;";
//        resultSet=this.retrieve(query);
//        try {
//            while(resultSet.next()) {
//                Sale sale = new Sale(resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5));
//                sale.setId(resultSet.getInt(1));
//                saleList.add(sale);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
//        return saleList;
        return this.saleRepository.findAll();
    }
}