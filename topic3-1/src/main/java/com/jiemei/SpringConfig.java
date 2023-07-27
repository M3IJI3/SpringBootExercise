package com.jiemei;

import com.jiemei.data.OrderDataServiceForRepository;
import com.jiemei.data.OrdersDataAccessInterface;
import com.jiemei.services.OrderBusinessService;
import com.jiemei.services.OrderBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import javax.sql.DataSource;

/** create Bean config files to make dependency injection **/
@Configuration
public class SpringConfig {
    @Bean(name="orderBusinessService")
    /**
     * @RequestScope: The connections are built up only when requests start,
     *                and it destroys soon when requests finish.
     *
     * @SessionScope: It will start
     * **/
    @RequestScope
//    @SessionScope: this can be used when develop a shop cart
    public OrderBusinessServiceInterface getOrderBusiness(){
        return new OrderBusinessService();
    }

    @Autowired
    DataSource dataSource;

    @Bean(name="orderDAO")
    @RequestScope
    public OrdersDataAccessInterface getDataService(){
//        return new OrderDataService();
        return new OrderDataServiceForRepository(dataSource);
    }
}
