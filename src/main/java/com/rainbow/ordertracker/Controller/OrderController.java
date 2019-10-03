package com.rainbow.ordertracker.Controller;

import com.rainbow.ordertracker.Model.Delivery;
import com.rainbow.ordertracker.Model.Orders;
import com.rainbow.ordertracker.Model.Payment;
import com.rainbow.ordertracker.Model.Status;
import com.rainbow.ordertracker.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * GET all
     * @return List
     */
    @RequestMapping("/orders")
    public String getAllOrders(Model model) {
        model.addAttribute("orders",orderService.getAllOrder());
        return "home";
    }

    /**
     *GET one
     * @param id
     * @return List
     */
    @RequestMapping("/orders/{id}")
    public String getOrder(@PathVariable Integer id, Model model) {
        model.addAttribute("order", orderService.getOrder(id));
        return "orderDetail";
    }

    /**
     * GET all Status.Designing
     * @return
     */
    @RequestMapping("/orders/design")
    public String getAllOrders_status(Model model){
        model.addAttribute("orders",orderService.getAllOrder_design());
        return "design";
    }

    /**
     * GET all Status.Printing
     * @return
     */
    @RequestMapping("/orders/print")
    public String getAllOrders_print(Model model){
        model.addAttribute("orders",orderService.getAllOrder_print());
        return "print";
    }

    /**
     * GET all Status.Printing
     * @return
     */
    @RequestMapping("/orders/postpress")
    public String getAllOrders_postpress(Model model){
        model.addAttribute("orders",orderService.getAllOrder_postpress());
        return "postpress";
    }

    /**
     * POST an order
     */
    @RequestMapping("/orders/add")
    public String addOrderPage(Model model){
        //new id is created here
        model.addAttribute("orders",new Orders());
        return "addOrder";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/orders")
    public String addOrders(Orders order, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "errorpage";
        }
        if(order.getOrderId()!= null){
            orderService.putOrder(order.getOrderId(),order);
        }
        orderService.addOrder(order);
        return "redirect:/orders/"+order.getOrderId();
    }

    /**
     * PUT an order
     */
    @RequestMapping("/orders/add/{id}")
    public String putOrder(@PathVariable Integer id, Model model){
        model.addAttribute("orders",orderService.getOrder(id));
        model.addAttribute(id);
        return "addOrder";
    }

    /**
     * DELETE by id
     * @param id
     */
    @RequestMapping("/orders/delete/{id}")
    public String deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }

}
