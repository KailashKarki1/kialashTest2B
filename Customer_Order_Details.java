package com.example.csd214test2bkailash;

public class Customer_Order_Details {
    private int OrderID;
    private String ProductName;
    private int Quantity;
    private int TotalPrice;

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
    }

    public Customer_Order_Details(int orderID, String productName, int quantity, int totalPrice) {
        OrderID = orderID;
        ProductName = productName;
        Quantity = quantity;
        TotalPrice = totalPrice;
    }
}
