package entity;

import java.util.Map;

public class Cart {
    Map<Product, Integer> items;
    public Cart(Map<Product, Integer> items) {
        this.items= items;
    }

    public Map<Product, Integer> getItems() {return items;}
    public void addItem(Product product, int quantity) {items.put(product, quantity);}
    public void removeItem(Product product) {items.remove(product);}

    public String toString(){
        StringBuilder str = new StringBuilder();
        for(Map.Entry<Product, Integer> entry : items.entrySet()){
            Product product = entry.getKey();
            int quantity = entry.getValue();
            str.append(product.getName());
            str.append(" ");
            str.append(quantity);
            str.append("\n");
        }
        return str.toString();
    }
}
