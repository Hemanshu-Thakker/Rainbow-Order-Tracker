package com.rainbow.ordertracker.Service;

import com.rainbow.ordertracker.Model.Orders;
import com.rainbow.ordertracker.Model.Status;
import com.rainbow.ordertracker.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> getAllOrder(){
        List<Orders> orders=new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    public List<Orders> getAllOrder_design(){
        List<Orders> orders;
        orders= getAllOrder();
        for( Orders temp: orders){
            if(temp.getProductStatus()== Status.Designing){}
            else{
                orders.remove(temp);
            }
        }
        return orders;
    }

    public Orders getOrder(Integer orderId){
        return orderRepository.findById(orderId).get();
    }

    public void addOrder(Orders orders){
        orderRepository.save(orders);
    }

    public void putOrder(Integer orderId, Orders order){
        order.setOrderId(orderId);
        orderRepository.save(order);
    }

    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }

    public void deleteOrder(Integer orderId){
        orderRepository.deleteById(orderId);
    }
}
