package service;

import entity.IShippable;
import entity.Product;

import java.util.Map;

public class ShippingService {

    public void shippingReciept(Map<Product, Integer> shippedItems){
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (Map.Entry<Product, Integer> item : shippedItems.entrySet()) {
            Product product = item.getKey();
            Integer quantity = item.getValue();
            double itemWeight = ((IShippable) product).getWeight();
            totalWeight += itemWeight;
            System.out.println(quantity + "x " + product.getName() +" "+ weightMod(itemWeight));
        }

        System.out.println("Total package weight: " + weightMod(totalWeight) + "\n");
    }

    private String weightMod(double weight){
        if(weight >=1000)
            return weight / 1000.0 + "Kg";
        else
            return weight + "g";
    }
}
