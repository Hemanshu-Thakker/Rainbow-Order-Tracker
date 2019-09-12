package com.rainbow.ordertracker.Model;

import javax.persistence.*;
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue
    @Column(name = "id")
    Integer orderId;
    @Column(name = "product")
    @Enumerated(EnumType.STRING)
    Product product;
    @Column(name = "description")
    String description;
    @Column(name = "quantity")
    Integer quantity;
    @Column(name = "amount")
    Integer amount;
    @Column(name = "clientName")
    String clientName;
    @Column(name = "clientNumber")
    Long clientNumber;
    @Column(name = "productStatus")
    @Enumerated(EnumType.STRING)
    Status productStatus;
    @Column(name = "paymentStatus")
    @Enumerated(EnumType.STRING)
    Payment paymentStatus;
    @Column(name = "deliveryStatus")
    @Enumerated(EnumType.STRING)
    Delivery deliveryStatus;


    public Orders(){

    }

    public Orders(Product product, String description, Integer quantity, String clientName, Long clientNumber) {
        this.product = product;
        this.description = description;
        this.quantity= quantity;
        this.clientName=clientName;
        this.clientNumber=clientNumber;
        productStatus=Status.Designing;
        paymentStatus=Payment.Unpaid;
        deliveryStatus=Delivery.Undelivered;
    }

    /**
     * Getters
     */
    public Integer getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Status getProductStatus() {
        return productStatus;
    }

    public Payment getPaymentStatus() {
        return paymentStatus;
    }

    public Delivery getDeliveryStatus() {
        return deliveryStatus;
    }

    public String getClientName() {
        return clientName;
    }

    public Long getClientNumber() {
        return clientNumber;
    }

    /**
     *Setter
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProductStatus(Status productStatus) {
        this.productStatus = productStatus;
    }

    public void setPaymentStatus(Payment paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setDeliveryStatus(Delivery deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientNumber(Long clientNumber) {
        this.clientNumber = clientNumber;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", product=" + product +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", clientName='" + clientName + '\'' +
                ", clientNumber=" + clientNumber +
                ", productStatus=" + productStatus +
                ", paymentStatus=" + paymentStatus +
                ", deliveryStatus=" + deliveryStatus +
                '}';
    }
}

