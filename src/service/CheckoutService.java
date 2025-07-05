package service;
import entity.Customer;
import entity.IShippable;
import entity.Product;

import java.util.HashMap;
import java.util.Map;

public class CheckoutService {
    private Customer customer;
    private CartService cartService;
    private ShippingService shippingService;

    public CheckoutService(Customer customer, CartService cartService, ShippingService shippingService) {
        this.customer = customer;
        this.cartService = cartService;
        this.shippingService = shippingService;
    }

    private double shippingPrice = 25;

    public void checkOut(){
        if(customer.getCart() == null || customer.getCart().getItems().isEmpty())
            throw new NullPointerException("Your cart is empty");
        if(this.cartService.getTotalCartPrice(customer.getCart())> customer.getBalance())
            throw new IllegalArgumentException("Not enough balance to cover your cart");

        Map<Product,Integer> shippableItems = new HashMap<>();
        boolean flag = false;
        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> item : customer.getCart().getItems().entrySet()){
            Product product = item.getKey();
            Integer quantity = item.getValue();
            product.setQuantity(product.getQuantity() - quantity);
            if (product instanceof IShippable) {
                shippableItems.put(product, quantity);
                flag = true;
            }

            System.out.println(quantity + "x " + product.getName() + " " + product.getPrice() * quantity);
        }
        double subtotal = cartService.getTotalCartPrice(customer.getCart());
        System.out.println("--------------------------");
        System.out.println("Subtotal: " + subtotal);
        if(flag){
            System.out.println("Shipping: " + shippingPrice);
            subtotal += shippingPrice;
        }
        System.out.println("Total: " + subtotal );
        double newBalance = customer.getBalance() - subtotal;
        System.out.println("Your new balance is: " + newBalance +"\n");

        if(!shippableItems.isEmpty())
            shippingService.shippingReciept(shippableItems);
    }

}
