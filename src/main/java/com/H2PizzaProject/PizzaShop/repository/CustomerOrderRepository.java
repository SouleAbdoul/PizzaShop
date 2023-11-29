package com.H2PizzaProject.PizzaShop.repository;
import com.H2PizzaProject.PizzaShop.model.CustomerOrder;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomerOrderRepository extends CrudRepository<CustomerOrder,Integer>{
        @Query (value = "SELECT * FROM customer_order c WHERE C.employee_id LIKE %:keyword%",nativeQuery = true)
        public List<CustomerOrder> getOrderByEmployeeId(@Param("keyword") int keyword);
        @Query (value = "SELECT * FROM customer_order c WHERE C.phone_number LIKE %:phone_number%",nativeQuery = true)
        List<CustomerOrder> getOrderByCustomer(@Param("phone_number") Long phone_number);

}
