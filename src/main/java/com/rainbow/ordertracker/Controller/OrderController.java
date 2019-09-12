package com.rainbow.ordertracker.Controller;

import com.rainbow.ordertracker.Model.Delivery;
import com.rainbow.ordertracker.Model.Orders;
import com.rainbow.ordertracker.Model.Payment;
import com.rainbow.ordertracker.Model.Status;
import com.rainbow.ordertracker.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * GET all
     * @return List
     */
    @RequestMapping("/orders")
    public List<Orders> getAllOrders() {
        return orderService.getAllOrder();
    }

    /**
     *GET one
     * @param id
     * @return List
     */
    @RequestMapping("/orders/{id}")
    public Orders getOrder(@PathVariable Integer id){
        return orderService.getOrder(id);
    }

    /**
     * GET all Status.Designing
     * @return
     */
    @RequestMapping("/orders/design")
    public List<Orders> getAllOrders_status(){
        return orderService.getAllOrder_design();
    }

    /**
     * GET all Status.Printing
     * @return
     */
    @RequestMapping("/orders/print")
    public List<Orders> getAllOrders_print(){
        return orderService.getAllOrder_print();
    }

    /**
     * GET all Status.Printing
     * @return
     */
    @RequestMapping("/orders/postpress")
    public List<Orders> getAllOrders_postpress(){
        return orderService.getAllOrder_postpress();
    }

    /**
     * POST an order
     * @param order
     */
    @RequestMapping(method = RequestMethod.POST, value = "/orders")
    public void addOrders(@RequestBody Orders order){
        orderService.addOrder(order);
    }

    /**
     * PUT based on order
     * @param id
     * @param order
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/orders/{id}")
    public void putOrder(@PathVariable Integer id, @RequestBody Orders order){
        orderService.putOrder(id,order);
    }

    /**
     * DELETE
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/orders")
    public void deleteAllOrders(){
        orderService.deleteAllOrders();
    }

    /**
     * DELETE by id
     * @param id
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/orders/{id}")
    public void deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
    }

}
