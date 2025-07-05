package entity;


import java.time.LocalDate;

public class Ship_ExpProduct extends ExpirableProduct implements IShippable {
    private double weight;

    public Ship_ExpProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {return weight;}
    public void setWeight(double weight) {this.weight = weight;}
}
