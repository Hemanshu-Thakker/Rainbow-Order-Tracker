package com.rainbow.ordertracker.Repository;

import com.rainbow.ordertracker.Model.Orders;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<Orders,Integer> {
}
