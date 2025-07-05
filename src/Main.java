import entity.*;
import service.CartService;
import service.CheckoutService;
import service.ShippingService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        ShippingService shippingService = new ShippingService();

        Map<Product, Integer> items = new HashMap<Product, Integer>();
        Cart cart = new Cart(items);
        Customer test1 = new Customer("Mostafa", 4000, cart);

        //Product Cheese = new Ship_ExpProduct("Cheese", 12.5, 5, LocalDate.now().minusDays(60), 100);
        Product Cheese = new Ship_ExpProduct("Cheese", 12.5, 5, LocalDate.now().plusDays(60), 100);
        Product Biscuits = new Ship_ExpProduct("Biscuits", 25, 1, LocalDate.now().plusDays(120), 100);
        Product TV = new ShippableProduct("TV", 2000, 1, 2500);
        Product ScratchCard = new Product("ScratchCard", 30, 1);
        Product GiftCard = new ExpirableProduct("GiftCard", 50, 1, LocalDate.now().plusDays(120));

        cartService.addToCart(test1.getCart(), Cheese,1);
        cartService.addToCart(test1.getCart(), Biscuits,1);
        cartService.addToCart(test1.getCart(), TV,1);
        cartService.addToCart(test1.getCart(), ScratchCard,1);
        cartService.addToCart(test1.getCart(), GiftCard,1);
        CheckoutService checkoutService = new CheckoutService(test1, cartService, shippingService);
        checkoutService.checkOut();

        //Tests                : Status
        //Correct data         : PASS
        //Insufficient product : PASS
        //Insufficient balance : PASS
        //Expiry Date          : PASS
    }
}