package com.csis3275.finalexam.repository.Item.Sale;

import com.csis3275.finalexam.model.SalesEntity;
import com.csis3275.finalexam.model.SalesModel;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SaleRepository implements SaleDAOInterface<SalesModel>{

    @Resource
    SaleRepositoryInterface saleRepositoryInterface;

    public JdbcTemplate jdbcTemplate;

    public SaleRepository(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<SalesModel> getAllSales() {
        Iterable<SalesEntity> salesEntities =saleRepositoryInterface.findAll();
        List<SalesModel> salesModels = new ArrayList<>();

        for(SalesEntity salesEntity : salesEntities)
        {
            salesModels.add(modelMapper.map(salesEntity, SalesModel.class));
        }
        return salesModels;
    }

    @Override
    public void addNewSale(SalesModel sale) {
        saleRepositoryInterface.save(modelMapper.map(sale, SalesEntity.class));
    }

    @Override
    public void removeRecord(SalesModel sale) {
        saleRepositoryInterface.delete(modelMapper.map(sale, SalesEntity.class));
    }
}
