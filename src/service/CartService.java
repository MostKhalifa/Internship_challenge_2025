package service;


import entity.Cart;
import entity.Customer;
import entity.IExpirable;
import entity.Product;

import java.util.Map;

public class CartService {

    public void addToCart(Cart cart, Product product, int quantity) {
        if(product == null)
            throw new IllegalArgumentException("This product does not exist");
        if(product.getQuantity() < quantity)
            throw new IllegalArgumentException("This product does not have enough in stock");
        if(product instanceof IExpirable && ((IExpirable) product).isExpired())
            throw new IllegalArgumentException("This product has expired");
        cart.addItem(product, quantity);
    }

    public void removeFromCart(Cart cart, Product product) {
        if(product == null)
            throw new IllegalArgumentException("This product does not exist in your cart");
        cart.removeItem(product);
    }

    public double getTotalCartPrice(Cart cart) {
        double totalPrice = 0;
        for (Map.Entry<Product, Integer> item : cart.getItems().entrySet()){
            Product product = item.getKey();
            Integer quantity = item.getValue();
            double itemTotalPrice = product.getPrice() * quantity;
            totalPrice += itemTotalPrice;
        }
        return totalPrice;
    }
}
