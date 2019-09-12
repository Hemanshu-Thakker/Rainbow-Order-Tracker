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

    /**
     * GET all orders from the database
     * @return
     */
    public List<Orders> getAllOrder(){
        List<Orders> orders=new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    /**
     * GET all orders in design phase from the database
     * @return
     * @param
     */
    public List<Orders> getAllOrder_design(){
        List<Orders> orders=new ArrayList<>();
        for(Orders temp: orderRepository.findAll()){
            if(temp.getProductStatus()== Status.Designing){
                orders.add(temp);
            }
        }
        return orders;
    }

    /**
     * GET all Status.Printing orders
     * @return
     */
    public List<Orders> getAllOrder_print(){
        List<Orders> orders=new ArrayList<>();
        for(Orders temp: orderRepository.findAll()){
            if(temp.getProductStatus()==Status.Printing){
                orders.add(temp);
            }
        }
        return orders;
    }

    /**
     * GET all Status.Postpress orders
     * @return
     */
    public List<Orders> getAllOrder_postpress(){
        List<Orders> orders=new ArrayList<>();
        for(Orders temp: orderRepository.findAll()){
            if(temp.getProductStatus()==Status.Postpress){
                orders.add(temp);
            }
        }
        return orders;
    }

    /**
     * GET an order based on id
     * @param orderId
     * @return
     */
    public Orders getOrder(Integer orderId){
        return orderRepository.findById(orderId).get();
    }

    /**
     * POST an order
     * @param orders
     */
    public void addOrder(Orders orders){
        orderRepository.save(orders);
    }

    /**
     * PUT an order based on id
     * @param orderId
     * @param order
     */
    public void putOrder(Integer orderId, Orders order){
        order.setOrderId(orderId);
        orderRepository.save(order);
    }

    /**
     * DELETE an order
     */
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }

    /**
     * DELETE an order based on id
     * @param orderId
     */
    public void deleteOrder(Integer orderId){
        orderRepository.deleteById(orderId);
    }
}
