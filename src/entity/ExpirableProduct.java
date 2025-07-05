package entity;

import java.time.LocalDate;

public class ExpirableProduct extends Product implements IExpirable{

    LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getExpiryDate() {return expiryDate;}
    public void setExpiryDate(LocalDate expiryDate) {this.expiryDate = expiryDate;}

    @Override
    public boolean isExpired() {return IExpirable.super.isExpired();}

}
