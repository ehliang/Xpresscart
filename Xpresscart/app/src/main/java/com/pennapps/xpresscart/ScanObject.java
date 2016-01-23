package com.pennapps.xpresscart;

import java.util.ArrayList;

/**
 * Created by xe on 2016-01-23.
 */
public class ScanObject {
    private String itemName;
    private String scanCode;
    private int quantity;
    private String price;

    public ScanObject(String itemName, String scanCode, int quantity, String price)
    {
        this.itemName = itemName;
        this.scanCode = scanCode;
        this.quantity = quantity;
        this.price = price;

    }

    public String getItemName()
    {
        return itemName;
    }
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }
    public String getScanCode()
    {
        return scanCode;
    }
    public void setScanCode(String scanCode)
    {
        this.scanCode = scanCode;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity(int quantity)
    {
       this.quantity=quantity;
    }
    public void decreaseQuantity()
    {
        quantity--;
    }
    public void increaseQuantity()
    {
        quantity++;
    }
    public String getPrice()
    {
        return price;
    }

}
