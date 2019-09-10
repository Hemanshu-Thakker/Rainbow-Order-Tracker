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

    @RequestMapping("/orders")
    public List<Orders> getAllOrders() {
        return orderService.getAllOrder();
    }

    @RequestMapping("/orders/{id}")
    public Orders getOrder(@PathVariable Integer id){
        return orderService.getOrder(id);
    }

    @RequestMapping("/orders/design")
    public List<Orders> getAllOrders_design(){
        return orderService.getAllOrder_design();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/orders")
    public void addOrders(@RequestBody Orders order){
        orderService.addOrder(order);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/orders/{id}")
    public void putOrder(@PathVariable Integer id, @RequestBody Orders order){
        orderService.putOrder(id,order);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/orders")
    public void deleteAllOrders(){
        orderService.deleteAllOrders();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/orders/{id}")
    public void deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
    }

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }


}
