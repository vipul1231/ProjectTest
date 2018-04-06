package com.src;

import java.util.Scanner;
public class ItemDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Item[] items = new Item[5];
        for(int i = 0;i<items.length;i++)
        {
            //System.out.print("Enter item id:");
            int itemId = Integer.parseInt(sc.nextLine());
            //System.out.print("Enter item name:");
            String itemName = sc.nextLine();
            //System.out.print("Enter item price:");
            double price = Double.parseDouble(sc.nextLine());
            //System.out.print("Enter item discount:");
            double discount = Double.parseDouble(sc.nextLine());
            items[i] = new Item(itemId, itemName, price, discount);
        }
        Item leastPriceItem = getLeastPriceItem(items);
        sc.close();
        System.out.println("item with least price is" + leastPriceItem.getName());
    }
        

public static Item getLeastPriceItem(Item[] items)
{
 
    for(int i = 0;i<items.length;i++)
	{
		for(int j=0;j<items.length;j++)
               {
                  if(items[i]. getItemPrice() < items[j].getItemPrice())
                       {
                         Item temp = items[i];
                         items[i] = items[j];
                         items[j] = temp;
                        }
                }
      }
return items[0];
}

static class Item
{
    private int itemId;
    private String itemName;
    private double itemPrice;
    private double itemDiscount;
    public Item(int itemId, String itemName, double itemPrice,double itemDiscount) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDiscount = itemDiscount;
}
    public double getItemPrice() {
        return itemPrice;
}
    public void setitemPricel(double itemPrice) {
        this.itemPrice = itemPrice;
}
    public double getitemDiscount() {
        return itemDiscount;
}
    public void setitemDiscount(double itemDiscount) {
        this.itemDiscount = itemDiscount;
}
    public int getitemId() {
        return itemId;
}
    public String getName() {
        return itemName;
}
}
}

